
package com.example.SW2_Project.drivingsystem.src.drivingsystem;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *
 * @author DELL
 */
 public class  AbstractUser {
    protected String name;
    protected String mobileNumber;
    protected String password;
    protected String email;
    protected float balence;
    private static int incremental=1;
    //protected Regesteration regesteration;
    protected boolean logedIn;
    protected  Date birthDate;
    protected int id ; 
    public static DB DataBase ;

    public AbstractUser() {
        this.DataBase = DB.getDatabase();
        logedIn =false;
        incremental++;
        id = incremental;
        balence = 0;
        
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

    public  int getId() {
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

    public float getBalence() {
        return balence;
    }

    public void setBalence(float balence) {
        this.balence = balence;
    }

    public static int getIncremental() {
        return incremental;
    }

    public static void setIncremental(int incremental) {
        AbstractUser.incremental = incremental;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public boolean isLogedIn() {
        return logedIn;
    }

}
