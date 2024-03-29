/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Miguel
 */
public class Util {

    public static void centerOnScreen(final Component target) {
        if (target != null) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension dialogSize = target.getSize();

            if (dialogSize.height > screenSize.height) {
                dialogSize.height = screenSize.height;
            }
            if (dialogSize.width > screenSize.width) {
                dialogSize.width = screenSize.width;
            }

            target.setLocation((screenSize.width - dialogSize.width) / 2,
                    (screenSize.height - dialogSize.height) / 2);
        }
    }

    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
