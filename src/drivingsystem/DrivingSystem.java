/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingsystem;

import static drivingsystem.SystemInterface.mainInterface;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DrivingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	SystemInterface S1=new SystemInterface();
    	S1.start();
    	SystemInterface S2=new SystemInterface();
    	S2.start();
    	

    }
    
}
