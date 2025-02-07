package Abstraction;

import java.sql.Timestamp;

public abstract class AbstractEvent implements Event{
    protected final String id;
    protected final Long timeStamp;

    protected AbstractEvent(String id){
        this.id= id;
        this.timeStamp = new Timestamp(System.currentTimeMillis()).getTime();
    }

    public Long getTimeStamp() {
        return this.timeStamp;
    }
}
