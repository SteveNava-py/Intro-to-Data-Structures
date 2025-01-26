package everythingHash;

import java.util.*;

public class ComparingDictionaries {
    public static void main(String[] args) {
        String [] data = new String("cooked fried deepFried boiled baked sauteed seasoned oiled broiled grilled airFried microwaved burnt").split(" ");
        HashSet<String> hs = new HashSet<>();
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        TreeSet<String> ts = new TreeSet<>();
        HashMap<String, Integer> hm = new HashMap<>();
        TreeMap<String, Integer> tm = new TreeMap<>();
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        for (String s: data) {
            hs.add(s);
            lhs.add(s);
            ts.add(s);
            Integer freq = hm.get(s);
            hm.put(s, freq == null ? 1: freq + 1);
            tm.put(s, freq == null ? 1: freq + 1);
            lhm.put(s, freq == null ? 1: freq + 1);

        }

        System.out.println("The HashSet is " + hs);
        System.out.println("The Linked Hash Set is: " + lhs);
        System.out.println("=================================");
        System.out.println("The Hash Map is " + hm);
        System.out.println("The Tree Map is" + tm);
        System.out.println("The Linked Hash Map is " + lhm);
    }
}
