package pl.sdacademy.rozkocha.szymon.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        //int size = random.nextInt(11) + 5;

        int size = 5;

        List<Integer> numbers = new ArrayList<Integer>(size);

        for(int i = 0;i < size;++i) {
            numbers.add(random.nextInt(21));
        }

        System.out.println(numbers);

        //System.out.println(BubbleSort.sort(numbers, Comparator.naturalOrder()));
        System.out.println(QuickSort.sort(numbers, Comparator.reverseOrder()));
    }
}
