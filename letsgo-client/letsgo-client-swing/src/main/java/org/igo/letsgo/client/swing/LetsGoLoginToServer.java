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

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author surzhin.konstantin
 */
public class LetsGoLoginToServer implements Runnable {

    @Override
    public void run() {
    
        final JFrame f = new JFrame(java.util.ResourceBundle.getBundle("Bundle").getString("HELLO"));
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        f.setLayout(new BorderLayout());
        f.add(new JLabel(java.util.ResourceBundle.getBundle("Bundle").getString("HELLO")), BorderLayout.NORTH);

        final JPanel pn = new JPanel(new GridLayout(4, 4));
        final JTextField  loginTextField = new JTextField();
        
        pn.add(new JLabel(java.util.ResourceBundle.getBundle("Bundle").getString("LOGIN")));
        pn.add(loginTextField);

        final JTextField passwordTextField = new JTextField();
        pn.add(new JLabel(java.util.ResourceBundle.getBundle("Bundle").getString("PASSWORD")));
        pn.add(passwordTextField);

        final Icon guestIcon = new ImageIcon(getClass().getResource("/com/famfamfam/silk/user_suit.png"));
        final String guestName = java.util.ResourceBundle.getBundle("Bundle").getString("GUEST");

        Action action = new AbstractAction(guestName) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox cb = (JCheckBox) e.getSource();
                passwordTextField.setEnabled(!cb.isSelected());
            }
        };
        
        JCheckBox guestCheckBox = new JCheckBox(action);
        pn.add(new JLabel(guestName, guestIcon, JLabel.LEFT));
        pn.add(guestCheckBox);

        final Icon serverIcon = new ImageIcon(getClass().getResource("/com/famfamfam/silk/server_connect.png"));
        final String connectionLabel = java.util.ResourceBundle.getBundle("Bundle").getString("SUBMIT");
        final ConnectToServerAction ctsa = new ConnectToServerAction( connectionLabel, loginTextField, passwordTextField, guestCheckBox );

        
        pn.add(new JLabel(java.util.ResourceBundle.getBundle("Bundle").getString("SUBMIT"), serverIcon, JLabel.LEFT));
        pn.add(new JButton(ctsa));

        f.add(pn);

        f.pack();
        f.setVisible(true);

    }

}
