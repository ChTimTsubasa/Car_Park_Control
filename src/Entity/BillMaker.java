package Entity;

import Prepare.FileOperator;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * This class helps to generate and send bills according to record operator to get the total time and calculate fee according to billable interface. It requires file operation so it is inheritance from FileOperation class
 * @author Tianyi Chen
 * @author Yuzhe Zhang
 * @version 2015-5-22
 */
public class BillMaker extends FileOperator{
    /**
     * record operator to help generate records in the bill
     * @see RecordOperator
     */
    RecordOperator RO;
    
    /**
     * Staff ID Agency to help get the list of ID to generate bills accordingly
     * @see StaffIDAgency
     */
    StaffIDAgency SA;
    
    /**
     * the constructor of BillMaker class
     *
     * @param RO record operator is used to get transaction record
     * @param SA Staff ID Agency is used to get the Staff ID list to generate bill for all staffs
     */
    public BillMaker(RecordOperator RO,StaffIDAgency SA){
        super(".txt","Bill");
        this.RO=RO;
        this.SA=SA;
    }
    /**
     * generate one Bill with given ID in the month described in calIn parameter;
     * @param ID
     * @param calIn 
     * @return whether the record exist
     */
    public boolean genOneBill(String ID,Calendar calIn){
        ArrayList<Date>dateList=RO.findIDRecord(ID, calIn);
        if(dateList.size()==0)
            return false;
        //preparing file
        int year1=calIn.get(Calendar.YEAR);
        int month1=calIn.get(Calendar.MONTH);
        super.setFileName(ID+"_"+year1+month1+".txt");
        //print transactions
        StringBuilder transRecord=new StringBuilder();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(int i=0; i<dateList.size();i++){
            if(i%2==0){  //it is an in date
                transRecord=new StringBuilder();
                transRecord.append("From "+sdf.format(dateList.get(i))+" to ");
            }
            else {       //it is an out date
                transRecord.append(sdf.format(dateList.get(i)));
                super.appendRec(transRecord.toString());
            }
        }
        Billable payCar=(Billable)(CarFactory.getCar(ID,calIn.getTime()));
        super.appendRec("total fee: "+payCar.calFee(dateList)); 
        return true;
    }
    
    /**
     * generate bills for all ID in the IDList in the month describe by cal
     * @param IDList 
     * @param cal 
     */
    public void genBills(ArrayList<String> IDList,Calendar cal){
        for(String id:IDList){
            this.genOneBill(id, cal);
        }
    }
    /**
     * generate staff monthly Bill
     * called in Date Manager.
     */
    public void generateStaffMonthBill(){
        Calendar today=Calendar.getInstance();
        ArrayList<String> IDList=SA.getRegisteredID();
        this.genBills(IDList,today);
    }
}