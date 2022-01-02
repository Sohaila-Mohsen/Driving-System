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
 public class  AbstractUser {
    protected String name;
    protected String mobileNumber;
    protected String password;
    protected String email;
    private static int incremental=1;
    //protected Regesteration regesteration;
    protected boolean logedIn;
    protected int id ; 
    public DB DataBase ;

    public AbstractUser() {
        this.DataBase = DB.getDatabase();
        logedIn =false;
        incremental++;
        id = incremental;
        
    } 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Regesteration getRegesteration() {
//        return regesteration;
//    }
//
//    public void setRegesteration(Regesteration regesteration) {
//        this.regesteration = regesteration;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DB getDataBase() {
        return DataBase;
    }
    public void setLogedIn(boolean value)
    {
    	logedIn=value;
    }
    public void setDataBase(DB DataBase) {
        this.DataBase = DataBase;
    }

}
