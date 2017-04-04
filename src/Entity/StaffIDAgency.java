/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Prepare.RdmNumGen;
import Prepare.FileOperator;
import java.util.*;

/**
 *this is the class to control the StaffID.txt
 * @author Yi Cheng
 * @author Yuanhao Feng
 * @version 1.0
 */
public class StaffIDAgency extends FileOperator{
    /**
     * total ID size
     */
    int totalIDSize=10000;
    
    /**
     *the Staff ID List
     */
    public ArrayList<IDRecord>StaffIDList=new ArrayList<>();

    /**
     *the constructor
     */
    public StaffIDAgency(){
        super("StaffID.txt","Database");
        ArrayList<String>StaffIDList;
        StaffIDList=super.getRecord();
        if (!StaffIDList.isEmpty()){//the number does not exist
            for(String record:StaffIDList){
                this.StaffIDList.add(new IDRecord(record));
            }
        }
        else this.fillStaffID();
    }
    
    /**
     * fill the StaffID
     * @return the number that it fills to the StaffID
     */
    protected int fillStaffID(){
        int fillNum=0;
    	while(StaffIDList.size()<totalIDSize){
            int tryTime=0;
            String newStaffID=Staff.STAFFID_HEADER+RdmNumGen.rdmGenerate(Staff.STAFF_ID_LENGTH-Car.ID_HEADER_LENGTH,RdmNumGen.NUM_ELMNT);
            while(tryTime<RdmNumGen.RDM_TRY_TIMES){
                if(this.idExist(newStaffID)){
                   newStaffID=Public.TICKET_HEADER+RdmNumGen.rdmGenerate(Staff.STAFF_ID_LENGTH-Car.ID_HEADER_LENGTH,RdmNumGen.NUM_ELMNT);
                    tryTime++;}
                else break;
             }
            if(tryTime==RdmNumGen.RDM_TRY_TIMES){
                return fillNum;}
            StaffIDList.add(new IDRecord(newStaffID,false));
            fillNum++;
    	}
        this.refreshFile();
    	return fillNum;
    }
    
    /**
     * find any unregistered ID, often used in testing
     * @return one unregistered ID
     */
    protected String findAnyURID(){
        for(IDRecord rec:StaffIDList){
            if(!rec.state){
                return rec.ID;
            }
        }
        return null;
    }
    /**
     * find the state of a given ID
     * @param ID
     * @return whether it has been registered or not
     */
    protected boolean checkState(String ID){
        for(IDRecord rec:StaffIDList){
            if(ID.equals(rec.ID)){
                return rec.state;
            }
        }
        return false;
    }
    /**
     * register the ID
     * @param ID
     * @return register successful or not
     */
    protected boolean IDRegister(String ID){
        for(IDRecord rec:StaffIDList){
            if(ID.equals(rec.ID)&!rec.state){
                rec.state=true;
                return true;
            }
        }
        return false;
    }
    /**
     * refresh the file,used when it is going to close the file
     */
    protected void refreshFile(){
        if(!this.StaffIDList.isEmpty()){
            ArrayList<String> recordList=new ArrayList<>();
            for(IDRecord idRec:StaffIDList){
                recordList.add(idRec.toString());
            }
             super.refresh(recordList);
        }
           
        else
            super.deleteFile();
    }

    /**
     * get all registered ID
     * @return registered ID list
     */
    public ArrayList<String> getRegisteredID(){
        ArrayList<String> IDList=new ArrayList<>();
        for(IDRecord rec:StaffIDList){
            if(rec.state)
                IDList.add(rec.ID);
        }
        return IDList;
    }
    
    /**
     * whether the id exist
     * @param id
     * @return exist or not
     */
    public boolean idExist(String id){
        for(IDRecord StaffID:StaffIDList){
            if (id.equals(StaffID.ID)){
                return true;
            }
        }
        return false;
    }   
    
    /**
     * the ID record class
     */
    public class IDRecord{
        /**
         * column of ID
         */
        public final static int COL_ID  =   0;
        

        /**
        * column of ID state
        */
        public final static int COL_IDSTATE  =1;

        /**
         * total column of ID agency
         */
        public final static int IDAG_COL=2;
        
        String ID;
        boolean state;

        /**
         * constructor
         * @param ID
         * @param state
         */
        public IDRecord(String ID,boolean state){
            this.ID=ID;
            this.state=state;
        }

        /**
         * Constructor
         * @param rec
         */
        public IDRecord(String rec){
            String[]tmp=rec.split(FileOperator.SPLIT_WORD);
            this.ID=tmp[IDRecord.COL_ID];
            this.state=Boolean.parseBoolean(tmp[IDRecord.COL_IDSTATE]);
        }
        @Override
        public String toString(){
            String record="";
            for(int i=0;i<IDRecord.IDAG_COL;i++){
                switch(i){
                    case IDRecord.COL_ID:
                        record+=this.ID;
                        break;
                    case IDRecord.COL_IDSTATE:
                        record+=this.state;
                        break;
                }
                if(i<IDRecord.IDAG_COL-1){
                    record+=FileOperator.SPLIT_WORD;
                }
            }
            return record;
        }
    }
}