package task.one;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapIml<>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        int count1 = map.getCount(5); // 2
        int count2 = map.getCount(6); // 1
        int count3 = map.getCount(10); // 3

        System.out.println(map.toString());
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);

        map.addAll(map);
        System.out.println(map.toString());

        Map<Integer,Integer> map2 = new TreeMap<>();
        map.toMap(map2);
        System.out.println(map2.toString());
    }
}
