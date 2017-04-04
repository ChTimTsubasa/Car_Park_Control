/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tianyi Chne
 * @author Yuzhe Zhang
 */
public class RecordOperatorTest {
    RecordOperator ro;
    ParkLot         pk;
    public RecordOperatorTest() {
    }
    
    @Before
    public void setUp() {
        ro=new RecordOperator(); 
        pk=new ParkLot(ro);
    }
    
    @After
    public void tearDown() {
        //ro.deleteFile();
        ro.deleteFile();
        ro=null;
        pk.deleteFile();
        pk=null;
    }

    /**
     * Test of newInRecord method, of class RecordOperator.
     */
    @Test
    public void testNewInRecord() {
        System.out.println("newInRecord");
        Date inDate=new Date();
        pk.addCar(CarFactory.getCar("0123", inDate));
        assertEquals("0123",ro.carRecords.get(0).ID);
        assertEquals(inDate,ro.carRecords.get(0).opDate);
        assertEquals(1,ro.carRecords.get(0).opType);
    }

    /**
     * Test of newOutRecord method, of class RecordOperator.
     */
    @Test
    public void testNewOutRecord() {
        System.out.println("newOutRecord");
        Date inDate=new Date();
        pk.addCar(CarFactory.getCar("0123", inDate));
        Car car=pk.findCar("0123");
        car.getOut();
        pk.removeCar("0123");
        assertEquals("0123",ro.carRecords.get(1).ID);
        assertEquals(car.outDate,ro.carRecords.get(1).opDate);
        assertEquals(0,ro.carRecords.get(1).opType);
    }

    /**
     * Test of sortRecord method, of class RecordOperator.
     */
    @Test
    public void testSortRecord() {
        System.out.println("sortRecord");
        Date date1=new Date();
        Date date2=new Date(date1.getTime()+DateManager.ONE_DAY);
        Date date3=new Date(date2.getTime()+DateManager.ONE_DAY);
        ro.newInRecord("3", date3);
        ro.newInRecord("2", date2);
        ro.newInRecord("1", date1);
        ro.sortRecord();
        assertEquals("1",ro.carRecords.get(0).ID);
        assertEquals("2",ro.carRecords.get(1).ID);
        assertEquals("3",ro.carRecords.get(2).ID);
    }

    /**
     * Test of findIDRecord method, of class RecordOperator.
     */
    @Test
    public void testFindIDRecord() {
        Calendar cal=Calendar.getInstance();
        Date date1=new Date();
        Date date2=new Date(date1.getTime()+DateManager.ONE_DAY);
        ro.newOutRecord("1", date2);
        ro.newInRecord("1", date1);
        assertEquals(2,ro.findIDRecord("1", cal).size());
        ro.newInRecord("2", date1);
        ArrayList<Date> dateList=ro.findIDRecord("2",cal);
        assertEquals(2,dateList.size());
        System.out.println(dateList.get(0));
        System.out.println(dateList.get(1));
        
        
    }

//    /**
//     * Test of refreshFile method, of class RecordOperator.
//     */
//    @Test
//    public void testRefreshFile() {
//        System.out.println("refreshFile");
//        RecordOperator instance = new RecordOperator();
//        instance.refreshFile();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}