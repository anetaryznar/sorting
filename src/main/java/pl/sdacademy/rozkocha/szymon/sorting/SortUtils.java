package pl.sdacademy.rozkocha.szymon.sorting;

import java.util.List;

public class SortUtils {
    static <Type> void swap(List<Type> numbers, int i, int j) {
        Type temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }
}
