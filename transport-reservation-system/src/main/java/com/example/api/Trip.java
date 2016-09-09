package com.example.api;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by ayesh on 9/8/16.
 */
public class Trip {
    private long t_id;
    private Date t_date;
    private int t_class;
    private String s_location;
    private String e_location;
    private String medium;
    private int no_of_passengers;

    public long gett_id(){
        return t_id;
    }
    public void sett_id(long i) {
        this.t_id = i;
    }
    public Date gett_Date(){
        return t_date;
    }
    public void sett_Date(Date d){
        this.t_date = d;
    }
    public int gett_class(){
        return t_class;
    }
    public void sett_class(int t){
        this.t_class=t;
    }
    public String gets_loc(){
        return s_location;
    }
    public void sets_loc(String s){
        this.s_location = s;
    }
    public String gete_loc(){
        return e_location;
    }
    public void sete_loc(String e){
        this.e_location=e;
    }
    public String getMedium(){return medium;}
    public void setMedium(String e){this.medium = e;}
    public int getPassengers(){
        return no_of_passengers;
    }
    public void setPassengers(int t){
        this.no_of_passengers = t;
    }

}
