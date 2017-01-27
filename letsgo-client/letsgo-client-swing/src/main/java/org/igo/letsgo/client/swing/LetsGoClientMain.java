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

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author surzhin.konstantin
 */
public class LetsGoClientMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (LetsGoClientSettings.isThereRequestForHelp(args)) {
            LetsGoClientSettings.printHelp();
            return;  
        }
        

      //  LetsGoClientSettings.commandLinArgumentParse(args);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println(java.text.MessageFormat.format(
                    java.util.ResourceBundle.getBundle("Bundle").getString("LOOK_AND_FEEL_ERROR"), new Object[]{e.getMessage()}));
        }
        //SwingUtilities.invokeLater(new LetsGoLoginToServer());
        // SwingUtilities.invokeLater(new NewJDialog(null,true));
        java.awt.EventQueue.invokeLater(() -> {
            NewJDialog dialog = new NewJDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
}
