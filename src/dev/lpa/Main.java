package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

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


        System.out.println("-------");


        int result = calculator((var a, var b) -> {return a + b;}, 5, 2);
        var result2 = calculator((a, b) -> a / b, 10.0, 2.5);
        var result3 = calculator((a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "Ralph", "Kramden");

        var coords = Arrays.asList(
          new double[] {47.2160, -95.2348},
          new double[] {29.1566, -89.2495},
          new double[] {35.1566, -90.0659}
        );

        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        BiConsumer<Double, Double> p1 =(lat, lng) ->
            System.out.printf("[lat:%.3f long:%.3f]%n", lat, lng);

        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);

        System.out.println("-------");

        coords.forEach(s -> processPoint(s[0], s[1], p1));
        coords.forEach(s -> processPoint(s[0], s[1], (lat, lng) ->
                System.out.printf("[lat:%.3f long:%.3f]%n", lat, lng)));


        System.out.println("-------");

        // removeIf is pretty cool, checks for boolean and whacks if so
        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));

        System.out.println("-------");

        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s -> System.out.println(s));


        System.out.println("-------");

        list.removeIf(s-> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));

        list.replaceAll((s) -> s.charAt(0) + " - " + s.toUpperCase());
        System.out.println("-------");
        list.forEach(s -> System.out.println(s));

        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));


    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result: " + result);
        return result;
    }

    public static <T> void processPoint (T t1, T t2, BiConsumer<T, T> consumer){
        consumer.accept(t1, t2);
    }

}