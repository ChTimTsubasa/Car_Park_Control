/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *  Staff
 * @author Tianyi Chen, Yuzhe Zhang
 */
public class Staff extends Car implements Billable{
    /**
     * the length of staff ID 
     */
        public final static int STAFF_ID_LENGTH=5;//should be of different length with ticket ID

    /**
     * the header of staff ID
     */
    public final static String STAFFID_HEADER="0";
    /**
     *
     */
    public Date lastDate;//last time the car got out

    /**
     *
     */
    public RecordOperator RO;
    /**
     * constructor used by Parklot when initializing
     * @param ID
     * @param inDate 
     */
    public Staff(String ID,Date inDate){
        super(ID,inDate);
        this.outable=true;
        fee=0;
        
    }
    
    /**
     * calculate the fee using given date list
     * @param dateList(total number must be even)
     * @return staff fee
     */
    public double calFee(ArrayList<Date> dateList){
        Date lastDate=null;
        double calFee=0;
        double addFee=0;
        Date dayIn=new Date();
        Date dayOut=new Date();
        if(dateList.isEmpty()){
            return 0;}
        for(int i=0; i<dateList.size();i++){
            if(i%2==0){  //it is an in date
                dayIn=dateList.get(i);
                if(lastDate!=null){
                    if(sameDate(lastDate,dayIn))
                        addFee=0;
                    else addFee=1;
                    }
                else addFee=1;
            }
            else {       //it is an out date
                dayOut=dateList.get(i);
                addFee=addFee+(double)(this.dateGap(dayIn, dayOut)*1);
                lastDate=dayOut;
                calFee+=addFee;
            }
        }
        return calFee;
    }
    
    /**
     * calculate the date gap between day1 and day 2
     * @param day1
     * @param day2
     * @return day2-day1
     */
    private int dateGap(Date day1, Date day2){
        Calendar date1=Calendar.getInstance();
        date1.setTime(day1);
        date1.set(Calendar.HOUR, 0);
        date1.set(Calendar.MINUTE,0);
        date1.set(Calendar.SECOND,0);
        Calendar date2=Calendar.getInstance();
        date2.setTime(day2);
        date2.set(Calendar.HOUR, 0);
        date2.set(Calendar.MINUTE,0);
        date2.set(Calendar.SECOND,10);
        int dayGap=(int)(day2.getTime()-day1.getTime())/(24*60*60*1000);
        return dayGap;
    }
    /**
     * if the two date are in the same date;
     * @param day1
     * @param day2
     * @return same date or not
     */
    private boolean sameDate(Date day1, Date day2){
        Calendar date1=Calendar.getInstance();
        date1.setTime(day1);
        Calendar date2=Calendar.getInstance();
        date2.setTime(day2);
        return (date1.get(Calendar.YEAR)==date2.get(Calendar.YEAR)&
                date1.get(Calendar.MONTH)==date2.get(Calendar.MONTH)&
                date1.get(Calendar.DATE)==date2.get(Calendar.DATE));
        
    }
}
