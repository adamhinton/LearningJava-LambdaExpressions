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
        // Only works on functional interfaces - has a single abstract method. We're calling it here.
        list.forEach( (var myString) -> System.out.println(myString));

        System.out.println("-------");

        // We're using this in the lambda so we can't change it, must be final
        String prefix = "nato";

        // Can't do this, variable names can't conflict
        // I would never commit this kind of code war crime anyway
//        String myString = "fjdisaofas";

        list.forEach((var myString) ->{
            char first = myString.charAt(0);
            System.out.println(prefix + " " +  myString + " means " +    first);
        });


        int result = calculator((a, b) -> a + b, 5, 2);

    }

    public static <T> T calculator(Operation<T> function, T value1, T value2){
        T result = function.operate(value1, value2);
        System.out.println("Result: " + result);
        return result;
    }

}