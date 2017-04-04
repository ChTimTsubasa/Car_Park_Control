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
 *this is the class to control the TicketBox.txt
 * @author Yi Cheng
 * @author Yuanhao Feng
 * @version 1.0
 */
public class TicketBox extends FileOperator{
    /**
     * total length of ticket ID
     */
    public static int TICKET_ID_LENGTH=4;
    
    /**
     *the total size of the ticket box
     */
    public int ticketBoxSize=200;
    ArrayList<String>ticketList=new ArrayList<>();
    
    /**
     *constructor of the TicketBox
     */
    public TicketBox(){
        super("TicketBox.txt","Database");
        ticketList=super.getRecord();
    }
    /**
     * get the ticket number in the box
     * @return the ticket number
     */
    public int ticketNumber(){
        return ticketList.size();
    }
    /**
     * fill the ticket box
     * @return the number that it fills to the ticket box
     */
    protected int fillTicketBox(){
        int fillNum=0;
    	while(ticketList.size()<ticketBoxSize){
            int tryTime=0;
            String newTicket=Public.TICKET_HEADER+RdmNumGen.rdmGenerate(Public.TICKET_ID_LENGTH-Car.ID_HEADER_LENGTH,RdmNumGen.NUM_ELMNT);
            while(tryTime<RdmNumGen.RDM_TRY_TIMES){
                if(this.idExist(newTicket)){
                    newTicket=Public.TICKET_HEADER+RdmNumGen.rdmGenerate(Public.TICKET_ID_LENGTH-Car.ID_HEADER_LENGTH,RdmNumGen.NUM_ELMNT);
                    tryTime++;}
                else break;
             }
            if(tryTime==RdmNumGen.RDM_TRY_TIMES){
                return fillNum;}
            ticketList.add(newTicket);
            fillNum++;
    	}
    	return fillNum;
    }
    /**
     * get a Ticket from the ticket box
     * @return ticket ID
     */
    protected String getTicket(){
        if(ticketList.isEmpty()){
            return null;
        }
        else{
            String ticket=ticketList.get(0);
            ticketList.remove(0);
            return ticket;
        }
    }
    
    /**
     * check if the ticket box is empty
     * @return true if empty
     */
    protected boolean isEmpty(){
        return ticketList.isEmpty();
    }
    
    /**
     * refresh the file,used when it is going to close the file
     */
    protected void refreshFile(){
        if(!ticketList.isEmpty())
            super.refresh(ticketList);
        else
            super.deleteFile();
    }
    
    /**
     * if the id exist in the ticket box
     * @param id
     * @return if the ID exist
     */
    public boolean idExist(String id){
        for(String ticket:ticketList){
            if (id.equals(ticket)){
                return true;
            }
        }
        return false;
    }
            
}
