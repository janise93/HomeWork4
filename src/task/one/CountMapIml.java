package task.one;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class CountMapIml<T> implements CountMap<T> {

    public Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T o) {
        if (map != null && map.get(o) == null)
            map.put(o, 1);
        else
            map.put(o, map.get(o) + 1);
    }

    @Override
    public int getCount(T o) {
        return map.get(o) == null ? 0 : map.get(o);
    }

    @Override
    public int remove(T o) {
        int count = getCount(o);
        if (count == 1) {
            map.remove(o);
        } else if (count > 1) {
            map.put((T) o, count - 1);
        }
        return count;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap source) {
        for (Object pair : source.toMap().entrySet()) {
            T Key = ((Map.Entry<T, Integer>) pair).getKey();
            if (map.containsKey(Key))
                map.put(Key, map.get(Key) + ((Map.Entry<T, Integer>) pair).getValue());
        }
    }

    @Override
    public Map toMap() {
        return map;
    }

    @Override
    public void toMap(Map destination) {
        destination.clear();
        for (Map.Entry<T, Integer> pair : map.entrySet()) {
            destination.put(pair.getKey(), pair.getValue());
        }
    }

    @Override
    public String toString() {
        return "CountMapIml{" +
                "map=" + map +
                '}';
    }
}
