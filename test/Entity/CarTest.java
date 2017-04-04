/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tianyi Chen 
 * @author Yuzhe Zhang
 */
public class CarTest {

    /**
     * Test of getIn method, of class Car.
     */
    @Test 
    public void testGetIn() {
        System.out.println("getIn");
        Date inDate=new Date();
        Car car=new Public("P",inDate);
        car.getIn();
        assertEquals(car.ID,"P");
        assertEquals(car.inDate,inDate);
    }
    /**
     * Test of getOut method, of class Car
     */
    @Test
    public void testGetOut(){
        System.out.println("getOut");
        Date outDate=new Date();
        Car car=new Staff("s",outDate);
        car.getOut();
        assertEquals(true,(outDate.getTime()-car.outDate.getTime())<1000);
    }
}
