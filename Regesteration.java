/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingsystem;

/**
 *
 * @author DELL
 */
public interface Regesteration {
   DB dataBase = DB.getDatabase();
   public DriverStatue regester(AbstractUser abstractuser);
}
