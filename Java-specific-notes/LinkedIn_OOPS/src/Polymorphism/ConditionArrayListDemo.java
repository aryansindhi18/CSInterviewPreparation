package Polymorphism;
import java.util.ArrayList;
import java.util.Random;

public class ConditionArrayListDemo {
    public static void addRandomNumberToList(ArrayList<Integer> lst){
        Random random = new Random();
        int n = random.nextInt(100);
        //check if the lst is of type ConditonArrayList
        if(lst instanceof ConditionArrayList){
            //cast lst to type ConditionArrayList to access the isEligible method
            ConditionArrayList conditionList = (ConditionArrayList) lst;
            while(!conditionList.isEligible(n)){
                n = random.nextInt(100);
            }
        }
        lst.add(n);
    }
    public static void main(String[] args) {

        ConditionArrayList oddList = new ConditionArrayList(n -> n%2==1,1,2,3,4,7,9,-13);
        System.out.println(oddList);

        ConditionArrayList evenList = new ConditionArrayList(n -> n%2==0,1,2,3,4,7,9,-13);
        System.out.println(evenList);

        addRandomNumberToList(oddList);
        addRandomNumberToList(evenList);
        System.out.println(oddList);
        System.out.println(evenList);
    }
}
