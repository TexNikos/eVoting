/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.utilities;

import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author Nikos
 */
public class UtilFuncs
{
    
        public static Frame getDialogOwnerFrame()
    {
        Frame[] frames = JFrame.getFrames();
        for (int i = 0; i < frames.length; i++)
        {
            Frame frame = frames[i];
            if (frame.isVisible())
            {
                return frame;
            }
        }
        return null;
    }
    
}
