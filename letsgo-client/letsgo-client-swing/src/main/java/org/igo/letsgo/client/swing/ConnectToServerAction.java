/*
 * Copyright (C) 2017 surzhin.konstantin
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
package org.igo.letsgo.client.swing;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author surzhin.konstantin
 */
public class ConnectToServerAction extends AbstractAction {

    private final JTextField user;
    private final JTextField password;
    private final JCheckBox guest;

    ConnectToServerAction(String name, JTextField user, JTextField password, JCheckBox guest) {
        super(name);
        this.user = user;
        this.password = password;
        this.guest = guest;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (guest.isSelected() && user.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "You must enter a username.",
                    "Username is empty",
                    JOptionPane.ERROR_MESSAGE);
            return;
        } else {
           
            
            
        }
//        if (!user.isGuest() && !user.getLogin().isEmpty() && !user.getPassword().isEmpty()) {
//            //соединяемся с сервером
//        } else {
//            JOptionPane.showMessageDialog(null,
//                    "You must enter a username and password.",
//                    "Username or password is empty",
//                    JOptionPane.ERROR_MESSAGE);
//        }
    }
}
