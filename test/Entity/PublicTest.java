/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yi Cheng
 * @author Yuanhao Feng
 */
public class PublicTest {
    
    public PublicTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calFee method, of class Public.
     */
    @Test
    public void testCalFee() {
        System.out.println("calFee");
        Date inDate=new Date();
        inDate.setTime(inDate.getTime()-60*60*1000);
        Public instance = new Public("ids",inDate);
        //1 hour
        double expResult = 0.5;
        double result = instance.calFee();
        assertEquals(0.5, result, 0.0);
        
        //3 hours
        inDate.setTime(inDate.getTime()-2*60*60*1000);
        instance.inDate=inDate;
        assertEquals(1, instance.calFee(), 0.0);
        //5 hours
        inDate.setTime(inDate.getTime()-2*60*60*1000);
        instance.inDate=inDate;
        assertEquals(2, instance.calFee(), 0.0);
        //9 hours
        inDate.setTime(inDate.getTime()-4*60*60*1000);
        instance.inDate=inDate;
        assertEquals(3, instance.calFee(), 0.0);
        //13 hours
        inDate.setTime(inDate.getTime()-4*60*60*1000);
        instance.inDate=inDate;
        assertEquals(5, instance.calFee(), 0.0);
        //30 hours
        inDate.setTime(inDate.getTime()-17*60*60*1000);
        instance.inDate=inDate;
        assertEquals(5+2, instance.calFee(), 0.0);
    }

    /**
     * Test of pay method, of class Public.
     */
    @Test
    public void testPay() {
        System.out.println("pay");
        double money = 0.0;
        Public instance = null;
        boolean expResult = false;
        //boolean result = instance.pay(money);
        //assertEquals(expResult, result);
       
    }
    
}
