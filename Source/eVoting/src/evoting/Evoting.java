/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting;

import gui.MainWindow;

/**
 *
 * @author Nikos
 */
public class Evoting {

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                /**
                 * Look and feel code *
                 */
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {

                } catch (InstantiationException ex) {

                } catch (IllegalAccessException ex) {

                } catch (javax.swing.UnsupportedLookAndFeelException ex) {

                }
                /**
                 * Look and feel code END *
                 */
                new MainWindow();
            }
        });
    }

}
