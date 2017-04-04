/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
import Prepare.FileOperator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  the class that holds the cars
 * @author Tianyi Chen
 * @author Yuzhe Zhang
 * @version 2015-5-19
 */
public class ParkLot extends FileOperator{
    /**
     *the get in date of the car
     */
    public final static int COL_INDATE=1;
    
    /**
     * column of ID
     */
    public final static int COL_ID=0;
    /**
     *total column in the file
     */
    public final static int PARKLOT_COL=2;
    
    /**
     * the size of parking lot
     */
    public int parkLotSize=30;
    /**
     *the car list that holds all car parking in the park lot at the time
     */
    public ArrayList<Car>carList=new ArrayList<>();

    /**
     *the space remain
     */
    public int lotRemain;

    /**
     *the format to stores write the file
     */
    protected SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    RecordOperator RO;
    
    /**
     * the constructor of ParkLot class;
     * it reads records from ParkLot.txt;
     * <ID>;<inDate>;
     * @param RO
     */
    public ParkLot(RecordOperator RO){
        super("ParkLot.txt","Database");
        this.RO=RO;
        ArrayList<String>recList=super.getRecord();
        lotRemain=this.parkLotSize-recList.size();
        if (!recList.isEmpty()){
            for(String rec:recList){
                //get the car type
                String[] tmp=rec.split(FileOperator.SPLIT_WORD);
                String ID=tmp[ParkLot.COL_ID];
                Date inDate;
                try {
                    inDate = format.parse(tmp[ParkLot.COL_INDATE]);
                } catch (ParseException ex) {
                    Logger.getLogger(ParkLot.class.getName()).log(Level.SEVERE, null, ex);
                    inDate=new Date();
                }
               carList.add(CarFactory.getCar(ID, inDate));
                       
            }
        }
    }
    /**
     * check whether the ID exists or not
     * @param ID
     * @return whether the ID exists or not
     */
    public boolean carExist(String ID){
        for(Car car:carList){
            if(car.ID.equals(ID)){
                return true;}
        }
        return false;
    }
    /**
     * add car to the parkLot
     * @param car
     * @return car adding success or not
     */
    public boolean addCar(Car car){
        if(lotRemain>0){
            carList.add(car);
            this.RO.newInRecord(car.ID, car.inDate);
            lotRemain--;
            System.out.print(lotRemain);
            return true;}
        else return false;
    }
    
    /**
     * remove car from the park lot
     * @param ID
     * @return car find or not
     */
    public boolean removeCar(String ID){
        for(Car car:carList){
            if(car.ID.equals(ID)){
                carList.remove(car);
                this.RO.newOutRecord(ID, car.outDate);
                lotRemain++;
                return true;
            }
        }
        return false;
    }
    
    /**
     * get the remain number of empty lot
     * @return lotRemain
     */
    public int checkRemain(){
        return lotRemain;
    }
    /**
     * check if the parkLot is full or not
     * @return fullOrNot
     */
    public boolean isFull(){
        return (lotRemain==0);
    }
    
    
    /**
     * find car by ID 
     * @param ID
     * @return car 
     */
    public Car findCar(String ID){
        for(Car car:carList){
            if(car.ID.equals(ID)){
                return car;
            }
        }
        return null;
    }
    
    /**
     * refresh the file ParkLot.txt
     * used when leaving the system
     */
    
    public void refreshFile(){
        if(!carList.isEmpty()){
            ArrayList<String>recList=new ArrayList<>();
            for(Car car:carList){
                String rec="";
                for(int i=0;i<ParkLot.PARKLOT_COL;i++){
                    switch(i){
                        case ParkLot.COL_ID:
                            rec+=car.ID;
                            break;
                        case ParkLot.COL_INDATE:
                            rec+=format.format(car.inDate);
                            break;
                    }
                if (i<ParkLot.PARKLOT_COL-1)
                    rec+=FileOperator.SPLIT_WORD;
                }
                recList.add(rec);
            }
            refresh(recList);
        }
        else{
            super.deleteFile();
        }
    }   
}