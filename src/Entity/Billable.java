package Entity;

import java.util.ArrayList;
import java.util.Date;

/**
 * an interface for generating bill since the fee calculation is different according to different kind of car
 * @author Tianyi Chen
 * @author Yuzhe Zhang
 * @version 2015-5-21
 */
public interface Billable {

    /**
     * within the given transaction records describe by dateList, calculate the fee accordingly
     * @param dateList (of even number so that one is for in and another is for out)
     * @return fee
     */
    public double calFee(ArrayList<Date> dateList);
}
