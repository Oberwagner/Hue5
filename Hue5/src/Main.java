import interfaces.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("HalloOSD");
        list.add("FABiaN");
        list.add("LauRenz");

        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(3);
        integerList.add(70);
        integerList.add(3);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(2d);
        doubleList.add(2.80);
        doubleList.add(2.40);

        System.out.println(findSum(3,5));                    //Aufgabe 1
        System.out.println(stringisEmpty("Hallo"));  //Aufgabe 2
        System.out.println(convertListToUpperLowerCase(list));   // Aufgabe 3
        isEvenOrOdd(integerList);                               // Augabe 4
        System.out.println("\n" + SortListAlphabetically(list));// Aufgabe 5
        System.out.println(findAverageFromDoubles(doubleList));  // Aufgabe 6
        System.out.println(removeDuplicates(integerList));
        System.out.println(calculateFactorial(4));
    }

    public static int findSum(int a, int b){
        IFindSum ifindSum = (number1, number2) -> Integer.sum(a, b);
        return ifindSum.sum(a, b);
    }

    public static boolean stringisEmpty(String searchedString){
        IStringisEmpty iStringisEmpty = s -> s.isEmpty();
        return iStringisEmpty.IsStringEmpty(searchedString);
    }

    public static List<String> convertListToUpperLowerCase(List<String> list){
        IConvertListOfStringsToUpperLowerCase lowerCaseConverter = stringList -> stringList.stream().map(String::toLowerCase).toList();
        IConvertListOfStringsToUpperLowerCase upperCaseConverter = stringList -> stringList.stream().map(String::toUpperCase).toList();
        return upperCaseConverter.ConvertList(list);
    }

    public static void isEvenOrOdd(List<Integer> number){
        IEvenOrOdd evenOrOdd = number1 -> {
            for (int i : number1){
                if ((i%2) == 0) System.out.print("EVEN, ");
                else System.out.print("ODD, ");
            }
        };
        evenOrOdd.isEvenOrOdd(number);
    }

    public static List<String> SortListAlphabetically(List<String> stringList){
        ISortListAlphabetically sortListAlphabetically = list -> {
            Collections.sort(list);
            return list;
        };

        return sortListAlphabetically.sortList(stringList);
    }

    public static double findAverageFromDoubles(List<Double> doubleList){
        IFindAverageFromDoubleList findAverageFromDoubleList = doubles -> {
            double sum = 0;
            for (double value : doubles){
                sum += value;
            }
            return sum/doubles.size();
        };

        return findAverageFromDoubleList.findAverage(doubleList);
    }

    public static List<Integer> removeDuplicates(List<Integer> integerList){
        IRemoveDuplicatesFromListOfInts removeDuplicatesFromListOfInts = ints -> {
            Set<Integer> integerSet = new HashSet<>(ints);
            ints.clear();
            ints.addAll(integerSet);
            return ints;
        };
        return removeDuplicatesFromListOfInts.removeDuplicates(integerList);
    }

    public static int calculateFactorial(int number){
        ICalculateTheFactorial calculateTheFactorial = number1 -> {
            int sum = 1;
            for (int i = 1; i <= number1; i++) {
                sum = sum * i;
            }
            return sum;
        };
        return calculateTheFactorial.caluclateFactorial(number);
    }
}
