package Entity;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Yi Cheng
 * @author Yuanhao Feng
 */
public class CashBoxTest {
     CashBox box=new CashBox();
    public CashBoxTest() {
    }
@Before
    public void setUp() {
        box=new CashBox();
    }
    
    @After
    public void tearDown() {
        box.clearCashBox();
        box.refreshFile();
    }
    /**
     * Test of AddCash method, of class CashBox.
     */
    @Test
    public void testAddCash() {
        int m1=box.record.money1p;
        box.AddCash(CashBox.TYPE_1p);
        assertEquals(m1+1,box.record.money1p);
        int m2=box.record.money2p;
        box.AddCash(CashBox.TYPE_2p);
        assertEquals(m2+1,box.record.money2p);
        int m3=box.record.money50;
        box.AddCash(CashBox.TYPE_50);
        assertEquals(m3+1,box.record.money50);
        for(int i=m3+1;i<box.limit50;i++){
            box.AddCash(CashBox.TYPE_50);
        }
        assertEquals(false,box.AddCash(CashBox.TYPE_50));
        assertEquals(box.limit50,box.record.money50);
    }

    /**
     * Test of clearCashBox method, of class CashBox.
     */
    @Test
    public void testClearCashBox() {
        box.clearCashBox();
        assertEquals("0;0;0",box.record.toString());  
    }

    /**
     * Test of isAllFull method, of class CashBox.
     */
    @Test
    public void testIsAllFull() {
        box.clearCashBox();
        assertEquals(false,box.isAllFull());
         for(int i=0;i<box.limit50;i++){
            box.AddCash(CashBox.TYPE_50);
        }
        assertEquals(false,box.isAllFull());
        for(int i=0;i<box.limit1p;i++){
            box.AddCash(CashBox.TYPE_1p);
        }for(int i=0;i<box.limit2p;i++){
            box.AddCash(CashBox.TYPE_2p);
        }
        System.out.print(box.record);
        assertEquals(true,box.isAllFull());
    }

    /**
     * Test of refreshFile method, of class CashBox.
     */
    @Test
    public void testRefreshFile() {
        box.refreshFile();
        String tmp=box.getRecord().get(0);
        assertEquals(tmp,box.record.toString());
        
    }
    
}
