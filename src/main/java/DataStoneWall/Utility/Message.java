/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStoneWall.Utility;

import javax.swing.JOptionPane;

/**
 *
 * @author AbdulRehman
 */
public class Message {
    public static void showMessage(String message,String Type) {
        if(Type.equalsIgnoreCase("error"))
        {
            JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(Type.equalsIgnoreCase("warning"))
        {
            JOptionPane.showMessageDialog(null, message,"Data Missing",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null, message,"Message",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
}
