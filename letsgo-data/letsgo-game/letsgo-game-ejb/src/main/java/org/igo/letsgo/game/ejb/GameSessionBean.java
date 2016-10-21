/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.game.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import org.igo.letsgo.remote.IGameRemote;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class GameSessionBean implements IGameRemote {

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "java:/jms/queue/DLQ")
    private Queue queue;

    @Override
    public String getGame(int id) {

        try {
            try (Connection connection = connectionFactory.createConnection()) {
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                try (MessageProducer messageProducer = session.createProducer(queue)) {
                    
                    ObjectMessage message = session.createObjectMessage();
                    message.setObject("Leningrad game started!");
                    messageProducer.send(message);
                }
            }

        } catch (JMSException ex) {
            Logger.getLogger(GameSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Leningrad";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
