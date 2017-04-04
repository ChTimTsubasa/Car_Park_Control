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
 * @author Tianyi Chen
 * @author Yuzhe Zhang
 */
public class BillMakerTest {
    RecordOperator RO=new RecordOperator();
    StaffIDAgency SA=new StaffIDAgency();
    BillMaker MB=new BillMaker(RO,SA);
    public BillMakerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of genOneBill method, of class BillMaker.
     */
    @Test
    public void testGenOneBill() {
        System.out.println("genOneBill");
        Calendar cal=Calendar.getInstance();
        String ID=SA.findAnyURID();
        assertEquals(false,MB.genOneBill(ID,cal));
        SA.IDRegister(ID);
        RO.newInRecord(ID, new Date());
        assertEquals(true,MB.genOneBill(ID, cal));
    }
//
//    /**
//     * Test of genBills method, of class BillMaker.
//     */
//    @Test
//    public void testGenBills() {
//        System.out.println("genBills");
//        ArrayList<String> IDList = null;
//        Calendar cal = null;
//        BillMaker instance = null;
//        instance.genBills(IDList, cal);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of generateStaffMonthBill method, of class BillMaker.
//     */
//    @Test
//    public void testGenerateStaffMonthBill() {
//        System.out.println("generateStaffMonthBill");
//        BillMaker instance = null;
//        instance.generateStaffMonthBill();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
