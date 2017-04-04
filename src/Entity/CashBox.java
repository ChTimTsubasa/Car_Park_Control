package Entity;

import Prepare.FileOperator;
import java.util.ArrayList;

/**
 *
 * @author Yi Cheng
 * @author Yuanhao Feng
 * @see CashRecord
 * @version 2015-5-3
 */
public class CashBox extends FileOperator {
    /**
     * @see CashRecord
     */
    public CashRecord record;
    
    /**
     * limit number of 50p
     */
    public int limit50=100; //limit of money numbers

    /**
     *limit number of 1p
     */
    public int limit1p=100;

    /**
     *limit number of 2p
     */
    public int limit2p=100;
    /**
     * money type of 50p
     */
    public final static int TYPE_50=0;  //type of money

    /**
     * money type of 1p
     */
    public final static int TYPE_1p=1;

    /**
     *money type of 2p
     */
    public final static int TYPE_2p=2;

    private final static int COL_50=0;   //column orders of different kinds of money stores in file
    private final static int COL_1p=1;
    private final static int COL_2p=2;
    private final static int CASHBOX_COL=3;//overall columns
    
    /**
     * constructor of CashBox, it gets all the record in the CashBox.txt file and initial the 
     */
    public CashBox(){
        super("CashBox.txt","Database");
        ArrayList<String>recList=super.getRecord();
        if(recList.isEmpty())
            this.record=new CashRecord();
        else
            this.record=new CashRecord(recList.get(0));
    }
  
    
    
    /**
     * add cash of moneyType given to the cash box
     * @param moneyType
     * @return whether add money success or not
     */
    public boolean AddCash(int moneyType){
        switch(moneyType){
        case TYPE_50:
            if(record.money50<limit50){
            record.money50++;
            break;
            }
            else return false;
        case TYPE_2p:
            if(record.money2p<limit2p){
            record.money2p++;
            break;
            }
            else return false;
        case TYPE_1p:if(record.money1p<limit1p){
            record.money1p++;
            }
            else return false;
        }
        return true;
    }
    /**
     * translate the money of coins to double
     * @param moneyType
     * @return money amount that the moneyType represents
     */
    public double moneyTranslate(int moneyType){
        switch(moneyType){
        case TYPE_50:
            return 0.5;
        case TYPE_2p:
            return 2;
        case TYPE_1p:
            return 1;
        }
        return 0;
    }
    
    /**
     * clear the cash box
     */
    public void clearCashBox(){
        record.money1p=0;
        record.money2p=0;
        record.money50=0;
    }
    
    /**
     * @return whether th box is all full
     */
    public boolean isAllFull(){
        return((record.money1p==limit1p)&(record.money2p==limit2p)&(record.money50==limit50));
    }
    /**
     * @return number of coins in the cash box: <50><1p><2p>
     */
    public int[] cashState(){
        int[]state={record.money50,record.money1p,record.money2p};
        return state;
    }
    /**
       * refresh the cash record in the CashBox.txt
       * used when closing the system
       */
    public void refreshFile(){
        ArrayList<String> reclist=new ArrayList<>();
        reclist.add(this.record.toString());
        super.refresh(reclist);
    }
    
    /**
     * inner class for record translation
     */
    protected class CashRecord{

        /**
         * number of 50p in the box
         */
        public int money50;

        /**
         *number of 1p in the box
         */
        public int money1p;

        /**
         *number of 2p in the box
         */
        public int money2p;
        /**
         * constructor of class CashRecord
         */
        public CashRecord(){
                money50=0;
                money1p =0;
                money2p =0;
            }
        
        /**
         * constructor of class CashRecord
         * @param record
         */
        public CashRecord(String record){
            if(record!=null){
                String[]tmp=record.split(FileOperator.SPLIT_WORD);
                money50=Integer.parseInt(tmp[COL_50]);
                money1p =Integer.parseInt(tmp[COL_1p]);
                money2p =Integer.parseInt(tmp[COL_2p]);
            }
        }
        /**
         * 
         * @return String type of the record
         */
        @Override
        public String toString(){
            String str="";
            for(int i=0;i<CASHBOX_COL;i++){
                switch(i){
                    case COL_50:
                        str+=this.money50;
                        break;
                    case COL_1p:
                        str+=this.money1p;
                        break;
                    case COL_2p:
                        str+=this.money2p;
                }
               if(i!=CASHBOX_COL-1)
                   str+=FileOperator.SPLIT_WORD;
            }
            return str;
        }  
    }
}
