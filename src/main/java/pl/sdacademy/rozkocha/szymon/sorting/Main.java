package pl.sdacademy.rozkocha.szymon.sorting;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        //int size = random.nextInt(11) + 5;

        int size = 1000;

        List<Integer> numbers = new ArrayList<Integer>(size);

        for(int i = 0;i < size;++i) {
            numbers.add(random.nextInt(21));
        }

        //System.out.println(numbers);

        long now = System.nanoTime();
        BubbleSort.sort(numbers, Comparator.naturalOrder());
        System.out.println("BubbleSort: " + (System.nanoTime() - now) / 1000000000.0);

        now = System.nanoTime();
        QuickSort.sort(numbers, Comparator.naturalOrder());
        System.out.println("QuickSort: " + (System.nanoTime() - now) / 1000000000.0);

        now = System.nanoTime();
        InsertionSort.sort(numbers, Comparator.naturalOrder());
        System.out.println("InsertionSort: " + (System.nanoTime() - now) / 1000000000.0);

        now = System.nanoTime();
        SelectionSort.sort(numbers, Comparator.naturalOrder());
        System.out.println("SelectionSort: " + (System.nanoTime() - now) / 1000000000.0);
    }

    private static List<LocalDate> findWeekends(LocalDate start, LocalDate end) {
        LocalDate current = start;

        List<LocalDate> list = new LinkedList<>();

        while(current.isBefore(end) || current.isEqual(end)) {
            if(current.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    current.getDayOfWeek() == DayOfWeek.SUNDAY) {
                list.add(current);
            }

            current = current.plusDays(1);
        }

        return list;
    }

    private static List<LocalDate> findWeekendsWithStream(LocalDate start, LocalDate end) {
        return Stream.iterate(start, current -> current.plusDays(1))
                .limit(Duration.between(start, end).toDays() + 1)
                .filter(Main::isWeekend)
                .collect(Collectors.toList());
    }

    private static boolean isWeekend(LocalDate localDate) {
        return localDate.getDayOfWeek() == DayOfWeek.SATURDAY ||
                localDate.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}
