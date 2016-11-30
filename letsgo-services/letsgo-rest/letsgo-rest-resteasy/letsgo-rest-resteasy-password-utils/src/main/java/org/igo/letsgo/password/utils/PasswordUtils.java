/*
 * Copyright (C) 2016 surzhin.konstantin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.igo.letsgo.password.utils;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.igo.entities.GoUser;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
@Path("user")
public class PasswordUtils {

    @PersistenceContext(unitName = "gamePU")
    private EntityManager em;

    @Context
    ServletContext context;

    @GET
    @Path("{password}")
    @Consumes({MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_XML})
    public PasswordHash getPasswordAsHash(@PathParam("password") final String password)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        final int iterations = Integer.parseUnsignedInt(context.getInitParameter("iterations"));
        final byte[] spaceSalt = fromStringToHex(context.getInitParameter("spaceSalt"));

        return generateStorngPasswordHash(password, iterations, spaceSalt);
    }

    @GET
    @Path("{password}/{login}")
    @Consumes({MediaType.TEXT_PLAIN})
    @Produces({MediaType.TEXT_PLAIN})
    public String isPasswordValid(@PathParam("password") final String password, @PathParam("login") final String login) {

        final TypedQuery<GoUser> query = em.createNamedQuery("League.findByUserName", GoUser.class);
        query.setParameter("userName", login);
        try {
            final GoUser user = query.getSingleResult();
            final int iterations = Integer.parseUnsignedInt(context.getInitParameter("iterations"));
            if (validatePassword(password,
                    user.getPassword(),
                    user.getSalt(),
                    iterations)) {
                return "true";
            } else {
                return "false";
            }
        } catch (Exception e) {
            //TODO: set error
            return "false";
        }
    }

    private PasswordHash generateStorngPasswordHash(final String password,
            final int iterations,
            final byte[] spaceSalt) throws NoSuchAlgorithmException, InvalidKeySpecException {

        final byte[] earthSalt = getSalt();
        final ByteBuffer bb = ByteBuffer.allocate(spaceSalt.length + earthSalt.length);

        bb.put(spaceSalt);
        bb.put(earthSalt);

        final byte[] salt = bb.array();
        final char[] chars = password.toCharArray();
        final PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        final SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1"); //NOI18N
        final byte[] hash = skf.generateSecret(spec).getEncoded();
        final PasswordHash passwordHash = new PasswordHash();

        passwordHash.setHash(fromHexToString(hash));
        passwordHash.setSalt(fromHexToString(earthSalt));

        return passwordHash;
    }

    private byte[] getSalt() throws NoSuchAlgorithmException {
        final SecureRandom sr = SecureRandom.getInstance("SHA1PRNG"); //NOI18N
        final byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private String fromHexToString(final byte[] array) {
        final BigInteger bi = new BigInteger(1, array);
        final String hex = bi.toString(16);
        final int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex; //NOI18N
        } else {
            return hex;
        }
    }

    private boolean validatePassword(final String originalPassword,
            final String storedPassword,
            final String storedSalt,
            final int iterations
    ) throws NoSuchAlgorithmException, InvalidKeySpecException {

        final byte[] salt = fromStringToHex(storedSalt);
        final byte[] hash = fromStringToHex(storedPassword);

        final PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
        final SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        final byte[] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;
        for (int i = 0; i < hash.length && i < testHash.length; i++) {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }

    private byte[] fromStringToHex(String hex) throws NoSuchAlgorithmException {
        final byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}
