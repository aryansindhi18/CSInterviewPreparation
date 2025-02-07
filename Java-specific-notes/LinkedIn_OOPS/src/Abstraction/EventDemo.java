package Abstraction;

public class EventDemo {
    public static void main(String[] args) {
        Event pwdChange = new PasswordChangeEvent("1");
        Event missedPayment = new MissedPaymentEvent("2");
        Event ActTransfer = new AccountTransferEvent("3");

        Event events[] = {pwdChange,missedPayment,ActTransfer};
        for(Event event : events){
            System.out.println(event.getTimeStamp());
            event.process();
            System.out.println("==========================");
        }

    }
}
