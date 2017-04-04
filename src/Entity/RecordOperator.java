/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Prepare.FileOperator;
import java.util.*;
/**
 *
 * @author Tianyi Chen
 * @author Yuzhe Zhang
 * @version 2015-5-19
 */
public class RecordOperator extends FileOperator {
    
    //stores in ID->yyyyMM->Record data structure
    ArrayList<TransRecord> carRecords= new ArrayList<>();
    RecordOperator recordOperator; 
    /**
     * Constructor
     */
    public RecordOperator(){
        super("Records.txt","Database");
          ArrayList<String>recList=super.getRecord();
        if (!recList.isEmpty()){
            for(String rec:recList){
                String[] tmp=rec.split(FileOperator.SPLIT_WORD);
                String ID=tmp[TransRecord.COL_ID];
                Date opDate=new Date(tmp[TransRecord.COL_OPDATE]);
                int opType=Integer.parseInt(tmp[TransRecord.COL_OPTYPE]);
                 TransRecord record=new TransRecord(ID,opDate,opType);
                carRecords.add(record);
            }
            this.sortRecord();
        }
    }
    /**
     * add one car record to transaction records 
     * @param ID
     * @param inDate 
     */
    public void newInRecord(String ID,Date inDate){
        TransRecord record=new TransRecord(ID,inDate,TransRecord.IN);
        carRecords.add(record);
    }
    /**
     * add one car record to transaction records
     * @param ID 
     * @param outDate 
     */
    public void newOutRecord(String ID,Date outDate){
        TransRecord record=new TransRecord(ID,outDate,TransRecord.OUT);
        carRecords.add(record);
    }
    /**
     * sort the Record according to date
     */
    public void sortRecord(){
        Collections.sort(carRecords,new SortByDate());
    }
    /**
     * get the operation list of car ID in the month defined by Calendar
     * @param ID
     * @param calIn
     * @return 
     */
    public ArrayList<Date> findIDRecord(String ID,Calendar calIn){
        this.sortRecord();
        ArrayList<Date> dateList=new ArrayList<>();
        int year1=calIn.get(Calendar.YEAR);
        int month1=calIn.get(Calendar.MONTH);
        Calendar beginCal=Calendar.getInstance();
        beginCal.set(year1, month1,0,0,0);//start of the month
        Date beginDate  =beginCal.getTime();
        boolean firstRecord=true;
        Date preInDate=null;
        Date preOutDate=null;
        //go through the car records to pick correct records
        
        for(TransRecord rec:carRecords){
            if(rec.ID.equals(ID)){
                Calendar recCal=Calendar.getInstance();
                recCal.setTime(rec.opDate);
                int year=recCal.get(Calendar.YEAR);
                int month=recCal.get(Calendar.MONTH);
                
                //before date check
                if(rec.opDate.before(beginDate)){
                    if(rec.opType==TransRecord.IN)
                        preInDate=rec.opDate;
                    else if(rec.opType==TransRecord.OUT)
                        preOutDate=rec.opDate;  
                }
                //current month check
                if((year==year1)&(month==month1)){
                    if(firstRecord){
                        if(preInDate!=null){
                            if(preOutDate!=null){
                                if(preOutDate.before(preInDate))
                                    dateList.add(beginDate);}//car has in but not out
                            else dateList.add(beginDate);//car has in but not out
                        }
                        firstRecord=false;
                    }
                    dateList.add(rec.opDate);
                    }
                }
            }
        
        //if the last record of the month is in, add one more date to out
        if(dateList.size()%2==TransRecord.IN){
            Date finalDate=new Date();
            Calendar finalCal=Calendar.getInstance();
            finalCal.set(year1, month1+1,1,0,0,0);
            finalCal.add(Calendar.SECOND,-1);
            finalDate=finalCal.getTime();
            dateList.add(finalDate);
        }
        return dateList;
    }
    /**
     * refresh the records file
     * used when it is going to close the system
     */
    public void refreshFile(){
         ArrayList<String>recList=new ArrayList<>();
        for(TransRecord rec:carRecords){
            recList.add(rec.toString());
        }
        super.refresh(recList);
    }
    
    
    private class SortByDate implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
        TransRecord s1 = (TransRecord) o1;
        TransRecord s2 = (TransRecord) o2;
        return s1.opDate.compareTo(s2.opDate);
        }
    }   
    /**
     * inner class that stores a line of transfer record
     */
    public class TransRecord{
        /**
         * column of ID
         */
        public final static int COL_ID  =   0;
        
        /**
         * column for date
         */
         public final static int COL_OPDATE=1;

        /**
         * column for operating type
         */
        public final static int COL_OPTYPE=2;
        /**
         * operating type of IN
         */
        public final static int IN      =   1;
        /**
         * operating type of OUT
         */
        public final static int OUT     =   0;
        
        /**
        * total column of record
        */
        public final static int RECORD_COL=4;
        String ID;
        Date opDate;
        int  opType;
        
        TransRecord(String ID,Date opDate,int opType){
            this.ID=ID;
            this.opDate=opDate;
            this.opType=opType;
        }
        @Override
        public String toString(){
            String record="";
            record+=ID+FileOperator.SPLIT_WORD;
            record+=this.opDate+FileOperator.SPLIT_WORD;
            record+=opType;
            return record;
        }

        
    }
}