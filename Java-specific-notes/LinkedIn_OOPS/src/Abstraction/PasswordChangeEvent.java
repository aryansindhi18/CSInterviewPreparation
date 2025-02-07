package Abstraction;

import java.sql.Timestamp;

public class PasswordChangeEvent extends AbstractEvent implements Event{
    //no need because it will be same for all events, hence keeping it in abstract class
    //private final String id;
    //private final Long timeStamp;

    PasswordChangeEvent(String id){
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
        System.out.println("Customer "+id +" changed their password. Sending confirmation mail.");
    }
}
