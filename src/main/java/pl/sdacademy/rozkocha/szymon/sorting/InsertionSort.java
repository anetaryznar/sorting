package pl.sdacademy.rozkocha.szymon.sorting;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class InsertionSort {
    public static <Type> List<Type> sort(Collection<Type> collection,
                                         Comparator<Type> comparator) {
        List<Type> in = new LinkedList<>(collection);

        List<Type> result = new LinkedList<>();

        while(!in.isEmpty()) {
            Type value = in.remove(0);

            boolean end = true;
            for(int i = result.size() - 1;i >= 0;--i) {
                if(comparator.compare(value, result.get(i)) > 0) {
                    result.add(i + 1, value);
                    end = false;
                    break;
                }
            }

            if(end) {
                result.add(0, value);
            }
        }

        return result;
    }
}
