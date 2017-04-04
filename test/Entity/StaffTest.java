/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tianyi Chen
 * @author Yuzhe Zhang
 */
public class StaffTest {
    public StaffTest() {
    }
     Staff stf=new Staff("0123",new Date());
    @Before
    public void setUp() {
       
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of getFee method, of class Staff.
     */
    @Test
    public void testCalFee() {
        System.out.println("calFee");
        Date inDate=new Date();
        Date outDate=new Date(inDate.getTime()+2*DateManager.ONE_DAY);
        ArrayList<Date> dateList=new ArrayList<>();
        dateList.add(inDate);
        dateList.add(outDate);
        double fee=stf.calFee(dateList);
        assertEquals(3, fee,0.0);
        
    }

    
    
}
