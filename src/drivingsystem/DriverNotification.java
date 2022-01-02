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
public class DriverNotification implements Notification{
    private String message ;
    private String source ;

    public DriverNotification( String source ,String destination,int id) {
        message ="User #"+id+" reruested ride from "+source+" to "+destination;
        this.source = source;
    }

    @Override
    public void notifyAllObservers() {
        int size =  dataBase.getDrivers().size();
        for (int i = 0; i < size ; i++) {
            Driver get = dataBase.getDrivers().get(i);
            for(int j=0 ; j<get.getFavoriteArea().size() ; i++)
            {
                if(get.getFavoriteArea().get(i)== source ){
                    get.update(message);
                }
            }      
        }
    }
    
}
