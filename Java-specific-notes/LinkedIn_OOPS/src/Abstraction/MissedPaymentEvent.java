package Abstraction;

import java.sql.Timestamp;

public class MissedPaymentEvent extends AbstractEvent implements Event{
    //no need because it will be same for all events, hence keeping it in abstract class
    //private final String id;
    //private final Long timeStamp;

    MissedPaymentEvent(String id){
        super(id);
        //this.id= id;
        //this.timeStamp = new Timestamp(System.currentTimeMillis()).getTime();
    }

    //no need because it will be same for all events, hence keeping it in abstract class
    /*@Override
    public Long getTimeStamp() {
        return this.timeStamp;
    }*/

    @Override
    public void process() {
        System.out.println("Customer "+id +" missed their payment. Sending reminder mail.");
    }
}
