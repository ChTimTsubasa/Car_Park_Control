/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Calendar;
import java.util.Date;

/**
 *constructor of public car
 * used for parkLot when initializing
 * @author Yi Cheng
 * @author Yuanhao Feng
 * @version 2015-5-10
 */
public class Public extends Car implements Payable {
    /**
     * total length of ticket ID
     */
    public static int TICKET_ID_LENGTH=4;
    /**
     * header of staff ticket
     */
        public final static String TICKET_HEADER="1";

    /**
     *
     */
    public double payFee;
    /**
     * Constructor of public user
     * used when initializing car park
     * @param ID
     * @param inDate 
     */
    public Public(String ID,Date inDate){
        super(ID,inDate);
        this.outable=false;
        this.payFee=0;
    }
    /**
     * calculate the parking fee
     * @return fee
     */
    @Override
    public double calFee(){
        Date now=new Date();
        int duration=(int)((double)(now.getTime()-inDate.getTime())/(1000*60*60));//in 2 hours
        double fee=0;
        fee+=(double)5*(int)(duration/24);
        int remain=duration%24;
        //up to 2 hours
        if(remain<=2)
            return fee+=0.5;
        //2 to 4 hours
        else if(remain<=4)
            return fee+=1;
        //4 to 8 hours
        else if(remain<=8)
            return fee+=2;
        //8 to 12 hours
        else if(remain<=12)
           return fee+=3;
        //12 to 24 hours
        else 
            return fee+=5;
    }
    
    /**
     * pay for the fee
     * @param money
     * @return enough
     */
    public boolean pay(double money){
        fee=this.calFee();
        payFee+=money;
        this.outable=(payFee>=fee);
        return this.outable;
    }
    /**
     * check if today is weekend
     * @return isWeekend
     */
    public static boolean checkWeekend(){
        Calendar today= Calendar.getInstance();
        int day=today.get(Calendar.DAY_OF_WEEK);
        return (day==Calendar.SATURDAY|day==Calendar.SUNDAY);
    }

    /**
     *
     * @return
     */
    public double getPayFee() {
        return this.payFee;
    }

    /**
     *
     * @return
     */
    public Date getInTime() {
        return this.inDate;
    }
}
