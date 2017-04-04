package Entity;

import java.util.Date;

/**
 * used to instantiate a staffCar or a publicCar with given ID according to the ID Header
 * @author TianyiChen 
 * @author Yuzhe Zhang
 * @version 2015-5-10
 */
public class CarFactory {
    
    /**
     * instantiate a car with given the ID and inDate
     * @param ID
     * @param inDate
     * @return a specific car instance
     */
    public static Car getCar(String ID, Date inDate){
        String type=ID.substring(0, Car.ID_HEADER_LENGTH);
        switch(type){
            case Staff.STAFFID_HEADER:
               return new Staff(ID,inDate);
            case Public.TICKET_HEADER:
               return new Public(ID,inDate);
            default: 
                return null;
        }
    }
}
