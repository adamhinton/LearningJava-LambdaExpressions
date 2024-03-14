package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"
        ));

        // there's a better way to loop over Arraylist
        for (String s : list){
            System.out.println(s);
        }

        System.out.println("-------");

        // yay
        // This is so much like arrow fxns
        list.forEach((s) -> System.out.println(s));

    }
}