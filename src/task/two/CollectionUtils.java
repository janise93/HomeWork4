package task.two;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> List<? extends T> limit(List<? extends T> source, int size) {
        if (source.size() == size || source.size() < size)
            return source;
        else
            return source.subList(0, size);
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return (c1.containsAll(c2));
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T e : c2) {
            if (c1.contains(e))
                return true;
        }
        return false;
    }

    public static <T extends Comparable<T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> sublist = new ArrayList<>();
        for (T e : list) {
            if (e.compareTo(min) == 0 || e.compareTo(max) == 0)
                sublist.add(e);
            else if (e.compareTo(min) > 0 && e.compareTo(max) < 0)
                sublist.add(e);
        }
        Collections.sort(sublist);
        return sublist;
    }

    public static <T> List<? extends T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        list.sort(comparator);
        return list.subList(list.indexOf(min), list.lastIndexOf(max) + 1);
    }

}
