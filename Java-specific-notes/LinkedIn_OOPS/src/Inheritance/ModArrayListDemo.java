package Inheritance;

import java.util.ArrayList;

public class ModArrayListDemo {
    public static void main(String[] args) {
        ModArrayList<Integer> list = new ModArrayList<>();
        list.add(1);
        list.add(4);
        list.add(10);

        System.out.println(list.getUsingMod(5));
        System.out.println(list.getUsingMod(-5));
    }
}
