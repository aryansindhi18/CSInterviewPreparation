package Abstraction;

import java.sql.Timestamp;

public class AccountTransferEvent extends AbstractEvent {
    //no need to implement Event now as abstract event already does it
    //public class AccountTransferEvent extends AbstractEvent implements Event
    //no need because it will be same for all events, hence keeping it in abstract class
    //private final String id;
    //private final Long timeStamp;

    AccountTransferEvent(String id){
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
        System.out.println("Customer "+id +" has requested to transfer their account. Reaching out to admin team to remove services from old account and add them to new one.");
    }
}
