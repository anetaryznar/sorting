package pl.sdacademy.rozkocha.szymon.sorting;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SelectionSort {
    public static <Type> List<Type> sort(Collection<Type> collection,
                                     Comparator<Type> comparator) {
        List<Type> result = new LinkedList<>(collection);

        for(int i = 0;i < result.size() - 1;++i) {
            Type actual = result.get(i);

            for(int j = i + 1;j < result.size();++j) {
                if(comparator.compare(actual, result.get(j)) > 0) {
                    Type temp = actual;
                    actual = result.get(j);
                    result.set(j, temp);
                }
            }

            result.set(i, actual);
        }

        return result;
    }
}
