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
 * @author Tianyi Chen
 * @author Yuzhe Zhang
 */
public class ParkLotTest {
    ParkLot park;
    RecordOperator RO=new RecordOperator();
    public ParkLotTest() {
    }
    
    @Before
    public void setUp() {
        park=new ParkLot(RO);
        park.addCar(new Public("1test",new Date()));
        park.addCar(new Staff("0test",new Date()));
    }
    
    @After
    public void tearDown() {
        park.removeCar("1test");
        park.removeCar("0test");
        System.out.println(park.checkRemain());
        park.refreshFile();
    }

    /**
     * Test of addCar method, of class ParkLot.
     */
    @Test
    public void testAddCar() {
        System.out.println("addCar");
        Car car = new Public("12345",new Date());
        park.addCar(car);
        assertEquals(true, park.carExist("12345"));
        park.removeCar("12345");
        
    }

    /**
     * Test of checkLot method, of class ParkLot.
     */
    @Test
    public void testCarExist() {
        System.out.println("carExist");
        assertEquals(false, park.carExist("123"));
        assertEquals(true, park.carExist("0test"));
    }

    /**
     * Test of removeCar method, of class ParkLot.
     */
    @Test
    public void testRemoveCar() {
        assertEquals(true,park.removeCar("0test"));
    }

    /**
     * Test of findCar method, of class ParkLot.
     */
    @Test
    public void testFindCar() {
        System.out.println("findCar");
        Public pub=(Public)park.findCar("1test");
        Staff st=(Staff)park.findCar("0test");
    }

    /**
     * Test of checkRemain method, of class ParkLot.
     */
    @Test
    public void testCheckRemain() {
        System.out.println("checkRemain");
        int result = park.parkLotSize-2;
        assertEquals(result, park.checkRemain());
    }
    
    /**
     * Test of refresh method, of class ParkLot.
     */
    @Test
    public void testRefreshFile() {
        System.out.println("refreshFile");
        park.refreshFile();
        
    }
}
