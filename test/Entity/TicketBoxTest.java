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
 *
 * @author Yi Cheng
 * @author Yuanhao Feng
 */
public class TicketBoxTest {
        TicketBox box=new TicketBox();
    public TicketBoxTest() {
    }
     @Before
    public void setUp() {
        box=new TicketBox();
    }
    
    @After
    public void tearDown() {
        box.refreshFile();
    }

    /**
     * Test of fillTicketBox method, of class TicketBox.
     */
    @Test
    public void testFillTicketBox() {
        System.out.println("fillTicket");
        box.fillTicketBox();
        assertEquals(box.ticketBoxSize,box.ticketList.size());
    }

    /**
     * Test of getTicket method, of class TicketBox.
     */
    @Test
    public void testGetTicket() {
        System.out.println("getTicket");
        String id=box.getTicket();
        assertEquals(Public.TICKET_ID_LENGTH,id.length());
    }

    /**
     * Test of isEmpty method, of class TicketBox.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        assertEquals(false, box.isEmpty());
        box.ticketList=new ArrayList<String>();
        assertEquals(true, box.isEmpty());
    }

    /**
     * Test of refreshFile method, of class TicketBox.
     */
    @Test
    public void testRefreshFile() {
        System.out.println("refreshFile");
        box.refreshFile();
        ArrayList<String>idFromFile=box.getRecord();
        int i=0;
        for(String id:idFromFile){
            assertEquals(true,box.idExist(id));
        }
    }
    
}
