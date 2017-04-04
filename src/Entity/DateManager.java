package Entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * a class to manage the threads related to time, including generating monthly bill in a month
 * @author Yuzhe Zhang
 * @author Tianyi Chen
 * @version 2015-5-23
 */
public class DateManager {
    /**
     * total length of one day
     */
    public final static int ONE_DAY=24*60*60*1000;
    
    /**
     *@see BillMaker
     */
    public BillMaker BM;

    /**
     * initialize and set the timer period to be one date and the task to to be of MonthBillTask
     * @see MonthBillTask
     * @param BM
     */
    public DateManager(BillMaker BM){
        this.BM=BM;
        //set operating date to be 23:50:50
        Calendar calendar= Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 50);
        calendar.set(Calendar.SECOND, 50);
        Date date=calendar.getTime(); 
        //first time to do the task
        Timer monthlyBiller =new Timer();
        MonthBillTask monthTask =new MonthBillTask(); 
        //do the task every day
        monthlyBiller.schedule(monthTask,date,1000);
    }
    
    
    /**
     * generate monthlyBill
     */
    public void monthlyBillGenerate(){
        ArrayList IDList=this.BM.SA.getRegisteredID();
        if(!IDList.isEmpty()){
            BM.generateStaffMonthBill();
        }
    }
    
    /**
     * MonthBillTask is a class inheritance from TimerTask to generate bill at the final day of this month.
     */
    protected class MonthBillTask extends TimerTask {
        /**
         * check if today is the final day of the month
         * @return true if it is the end
         */
        public boolean checkEndOfMonth(){
            Calendar cal=Calendar.getInstance();
            int preMonth=cal.get(Calendar.MONTH);
            cal.add(Calendar.DATE, 1);
            int thisMonth=cal.get(Calendar.MONTH);
            return (thisMonth!=preMonth);
        }
        @Override
        public void run() {
            try {
                if(this.checkEndOfMonth()){
                    BM.generateStaffMonthBill();
                }
            } catch (Exception e) {
            }
        }
    }
}
