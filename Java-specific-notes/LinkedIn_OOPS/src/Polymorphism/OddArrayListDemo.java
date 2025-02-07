package Polymorphism;
import java.util.ArrayList;
import java.util.Random;

public class OddArrayListDemo {
    public static void addRandomNumberToList(ArrayList<Integer> lst){
        Random random = new Random();
        //which add is called depends on the type of list passed(ArrayList or OddArrayList)
        lst.add(random.nextInt(100));
    }
    public static void main(String[] args) {

        OddArrayList oddList = new OddArrayList(1,2,3,4,7,9,-13);
        System.out.println(oddList);

        ArrayList<Integer> list  = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(7);
        list.add(9);
        list.add(-13);

        System.out.println(list);

        addRandomNumberToList(oddList);
        addRandomNumberToList(list);
        System.out.println(oddList);
        System.out.println(list);
    }
}
