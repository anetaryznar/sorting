package pl.sdacademy.rozkocha.szymon.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuickSort {
    public static <Type> List<Type> sort(List<Type> list, Comparator<Type> comparator) {
        List<Type> result = new ArrayList<>(list);

        if(list.size() < 2) {
            return result;
        } else if(result.size() == 2) {
            if(comparator.compare(result.get(0), result.get(1)) > 0) {
                SortUtils.swap(result, 0, 1);
            }

            return result;
        }

        int point = result.size() / 2;
        Type value = result.get(point);

        List<Type> left = new ArrayList<>();
        List<Type> right = new ArrayList<>();

        for(int i = 0;i < result.size();++i) {
            if(i == point) continue;

            Type actual = result.get(i);

            if(comparator.compare(value, actual) > 0) {
                left.add(actual);
            } else {
                right.add(actual);
            }
        }

        List<Type> sortedLeft = sort(left, comparator);
        List<Type> sortedRight = sort(right, comparator);

        sortedLeft.add(value);
        sortedLeft.addAll(sortedRight);

        return sortedLeft;
    }
}
