/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * class that manage the staff id information
 * @author Yi Cheng 
 * @author Yuanhao Feng
 */
public class StaffIDAgencyTest {
    StaffIDAgency ag=new StaffIDAgency();
    public StaffIDAgencyTest() {
        
    }
    /**
     * Test of fillStaffID method, of class StaffIDAgency.
     */
    @Test
    public void testFillStaffID() {
        ag.file.delete();
        ag.StaffIDList.clear();
        assertEquals(ag.totalIDSize,ag.fillStaffID());
    }

    /**
     * Test of idExist method, of class StaffIDAgency.
     */
    @Test
    public void testId() {
        String ID=ag.findAnyURID();
        assertEquals(true,ag.idExist(ID));
        assertEquals(false,ag.checkState(ID));
        ag.IDRegister(ID);
        assertEquals(true,ag.checkState(ID));
    }

    

    /**
     * Test of getRegisteredID method, of class StaffIDAgency.
     */
    @Test
    public void testGetRegisteredID() {
        System.out.println("getRegisteredID");
        ArrayList<String>IDList=ag.getRegisteredID();
        for(String ID:IDList){
            assertEquals(true,ag.idExist(ID));
            assertEquals(true,ag.checkState(ID));
        }
    }
    
}
