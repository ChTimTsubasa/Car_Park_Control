/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Calendar;
import java.util.Date;

/**
 * the interface class for UI and entity class
 * @author Tianyi Chen
 * @author Yongli Wang
 * @author Yuzhe Zhang
 * @author Jingtai Li
 * @author Yi Cheng
 * @author Yuanhao Feng
 * @version 2015-5-23
 */
public class ParkCntrl {
    RecordOperator RO   =   new RecordOperator();
    ParkLot        PK   =   new ParkLot(RO);
    CashBox        CB   =   new CashBox();
    TicketBox      TB   =   new TicketBox();
    StaffIDAgency  AG   =   new StaffIDAgency();
    BillMaker      BM   =   new BillMaker(RO,AG);
    DateManager    DM   =   new DateManager(BM);
    String         ID   ;
    Payable        payCar;
    //errors type

    /**
     * operation successful
     */
        public final static int SUCCESS         = 1;

    /**
     * pre operation finds that ID does not exist in specific location
     */
    public final static int ID_NOT_EXIST    =-1;

    /**
     *ID hasn't been registered
     */
    public final static int ID_NOT_REG      =-2;

    /**
     * parkLot is full already so no in operation is available
     */
    public final static int PARK_FULL       =-3;

    /**
     * for public user, it's not weekend
     */
    public final static int DAY_UNAVAILABLE =-4;

    /**
     * ticket box is empty
     */
    public final static int TICKET_EMPTY    =-5;

    /**
     * car can't get out(fee not paid or other possible reason)
     */
    public final static int CAR_UNOUTABLE   =-6;

    /**
     * ID has already registered
     */
    public final static int ID_ALREADY_REG  =-7;

    /**
     * car is not a payable car(staff)
     */
    public final static int CAR_NOT_PAYABLE =-8;

    /**
     * fee that has paid is not enough
     */
    public final static int PAY_NOT_OVER    =-9;

    /**
     * Not enough space in the cash box for specific kind of coin
     */
    public final static int NOT_ENOUGH      =-10;

    /**
     * the cash box is full
     */
    public final static int THIS_BOX_FULL   =-11;

    /**
     * car has already paid so it doesn't need to pay anymore
     */
    public final static int ALREADY_CLEAR   =-13;

    /**
     * car has already get into the park lot
     */
    public final static int CAR_IN_ALREADY  =-14;

    /**
     * the ID is not a correct type for generating billl
     */
    public final static int ID_NOT_BILLABLE =-15;
    
    /**
     * allow staff to come in
     * @param ID
     * @return SUCCESS/ID_NOT_EXIST/ID_NOT_REG/PARK_FULL
     * 
     */
    public int staffIn(String ID){
        if(PK.carExist(ID))
            return CAR_IN_ALREADY;
        if(!AG.idExist(ID))                         //check if ID exist
            return ID_NOT_EXIST;
        if(!AG.checkState(ID)){
            System.out.println("fail");
            return ID_NOT_REG; }                     //check if ID registered
        Staff staff=new Staff(ID,new Date());       //create a staff instance
        if(PK.addCar(staff))
            return SUCCESS;                         //Parklot add car success
        else
            return PARK_FULL;                       //parklot full
    }
    
    /**
     * allow public to get in
     * @return SUCCESS/DAY_UNAVAILABLE/TICKET_EMPTY/PARK_FULL
     */
    public int publicIn(){
        if(!Public.checkWeekend())
            return DAY_UNAVAILABLE;
        if(TB.isEmpty())
            return TICKET_EMPTY;
        if(PK.isFull())
            return PARK_FULL;
        ID=TB.getTicket();
        Public pub=new Public(ID,new Date());
        PK.addCar(pub);
        return SUCCESS;
    }
    /**
     * return the ticketNo of the car that just get in
     * @return ticket ID
     */
    public String getTicketID(){
        return ID;
    }
    
    /**
     * allow car to get out
     * @param ID
     * @return SUCCESS/ID_NOT_EXIST/CAR_UNOUTABLE
     */
    public int getOut(String ID){
        if(!PK.carExist(ID))
            return ID_NOT_EXIST;
        Car car=PK.findCar(ID);
        if(!car.outable)
            return CAR_UNOUTABLE;
        car.getOut();
        PK.removeCar(ID);
        return SUCCESS;
    }
    /**
     * check the number of empty spaces left in the park lot
     * @return the number of empty spaces
     */
    public int parkLotLeft(){
        return PK.lotRemain;
    }
    
    /**
     *
     */
    public void cashClear(){
        CB.clearCashBox();
    }
    /**
     * get the cash box state showing how many coins are there in the box
     * @return number of coins in the cash box: <50><1p><2p>.
     */
    public int[] cashBoxState(){
        return CB.cashState();
    }
   
    /**
     *
     */
    public void fillTicket(){
        TB.fillTicketBox();
    }
    /**
     * get the left number of tickets in the ticket box
     * @return the number of ticket left
     */
    public int ticketBoxState(){
        return TB.ticketNumber();
    }
    
    /**
     * staff to register
     * @param ID
     * @return SUCCESS/ID_ALREADY_REG/ID_NOT_EXIST;
     */
    public int register(String ID){
        if(!AG.idExist(ID))
            return ID_NOT_EXIST;
        if(AG.checkState(ID))
            return ID_ALREADY_REG;
        AG.IDRegister(ID);
        return SUCCESS;
    }
    
    
    /**
     * 
     * @param ID
     * @return result of operation
     */
    public int checkPayable(String ID){
        if(!PK.carExist(ID))
            return ID_NOT_EXIST;
        Car car=PK.findCar(ID);
        if (car.outable)
            return ALREADY_CLEAR;
        try{
        payCar=(Payable)car;
        }
        catch(Exception e){
            return CAR_NOT_PAYABLE; //means it is not a payable car
        }
        return SUCCESS;
    }
    
    /**
     * get the car fee
     * @return fee of the car
     */
    public double getFee(){
        return this.payCar.calFee();
    }
    /**
     * get the fee that the car has already paid
     * @return fee paid
     */
    public double getPayFee(){
        return this.payCar.getPayFee();
    }

    /**
     *
     * @return
     */
    public Date getInDate(){
        return this.payCar.getInTime();
    }
    /**
     * pay one coin
     * @param MoneyType
     * @return SUCCESS/NOT_ENOUGH/THIS_BOX_FULL
     */
    public int pay(int MoneyType){
        if(CB.AddCash(MoneyType)){
            double money=CB.moneyTranslate(MoneyType);
            if(payCar.pay(money))
               return SUCCESS;
            else
               return NOT_ENOUGH;
        }
        else return THIS_BOX_FULL;
    }
    
   
    /**
     * 
     * @param ID
     * @param cal
     * @return 
     */
    public int generateBill(String ID,Calendar cal){
        if(!AG.checkState(ID))
            return ID_NOT_EXIST;
        try{
            Billable billCar=(Billable)CarFactory.getCar(ID, cal.getTime());
        }
        catch(Exception e){
            return ID_NOT_BILLABLE;
        }
        BM.genOneBill(ID, cal);
        return SUCCESS;
    }
    /**
     * generate month bill
     */
    public void generateMonthBill(){
        BM.generateStaffMonthBill();
    }
    /**
     * refresh all records into file
     */
    public void refresh(){
        CB.refreshFile();
        TB.refreshFile();
        PK.refreshFile();
        RO.refreshFile();
        AG.refreshFile();
    }
    
}