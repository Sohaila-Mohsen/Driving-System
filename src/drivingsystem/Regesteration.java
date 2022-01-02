/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingsystem;

import javax.jws.WebService;

/**
 *
 * @author DELL
 */
@WebService
public interface Regesteration {
   DB dataBase = DB.getDatabase();
   public void regester(AbstractUser abstractuser);
}
