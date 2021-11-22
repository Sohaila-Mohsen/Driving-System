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
public class DB {
    private static DB Database;

    public static synchronized DB getDatabase() {
        if(Database == null)
            Database = new DB();
        return Database;
    }

    private DB() {
    }
    
    
}
