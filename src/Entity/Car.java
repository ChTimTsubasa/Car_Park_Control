package Entity;

import java.util.Date;


/**
 * the Class to describe a car including 
 * @author Yi Cheng
 * @author Yuanhao Feng
 * @version 2015-5-3
 */
public class Car{
    /**
     * the length of ID header
     */
    public final static int ID_HEADER_LENGTH=1;

    /**
     * the ID of the car
     */
    public String ID;

    /**
     * the get in time 
     */
    public Date inDate;

    /**
     *the get out time
     */
    public Date outDate;

    /**
     *whether the car can be out
     */
    public boolean outable;

    /**
     * car fee
     */
    public double fee;
    
    /**
     * constructor used by parkLot
     * @param ID
     * @param inDate
     */
    public Car(String ID,Date inDate){
        this.ID=ID;
        this.inDate=inDate;
    }

    /**
     * make inDate the current time
     */
    public void getIn(){
        inDate=new Date();
    }

    /**
     * check if the car is outable and make the outDate the current time is so
     * @return if car get out successfully
     */
    public boolean getOut(){
        if(outable){
            outDate=new Date();
        }
        return outable;
    }
    
}
