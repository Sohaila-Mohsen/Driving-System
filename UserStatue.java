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
public enum UserStatue {
    SUSPENDED,ACTIVE;
    @Override
    public String toString(){
        switch (this){
            case SUSPENDED : return "SUSPENDED";
            case ACTIVE : return "Active";
            default: return "Active";
        }
    }
    
}
