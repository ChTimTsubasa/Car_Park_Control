/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Yi Cheng
 * @author Yuanhao Feng
 * @version 2015-5-19
 */
public interface Payable {

    /**
     * how much the car has paid
     * @return payFee
     */
    public double   getPayFee();

    /**
     * the get in time of the car
     * @return in time
     */
    public Date     getInTime();

    /**
     * calculate the total fee
     * @return total fee
     */
    public double   calFee();

    /**
     *
     * @param money
     * @return whether the car has paid
     */
    public boolean  pay(double money);
}
