/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import gui.Authentication;
import gui.SplashScreen;

/**
 *
 * @author emmanuel
 */
public class Splash {
    /**
     * 
     * @param args the command line arguments - unsed
     */
    public static void main(String[] args) {
        SplashScreen sp = new SplashScreen();
        sp.setVisible(true);
        Authentication authentication = new Authentication();
        try {
            for (int i = 0; i < 101; i++) {
                Thread.sleep(30);
                sp.label1.setText(Integer.toString(i));
                sp.jProgressBar1.setValue(i);
                if(i==100){
                sp.setVisible(false);
                authentication.setVisible(true);
                }
                
            }
        } catch (Exception e) {
        }
    }
}
