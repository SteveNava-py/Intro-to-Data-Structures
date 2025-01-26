package everythingHash;

import java.util.HashMap;
import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        String s = "I just lost mah dawg yea";
        findDistinct1(s);
    }

    public static void findDistinct1(String s) {
        String[] words = s.split(" ");
        HashSet<String> hs = new HashSet<>();
        for (String st: words)
            hs.add(st.toLowerCase());
        System.out.println(hs);
        findDistinct2(s);

        /*
        String[] colors = {"Black", "White", "Red", "Blue"};
        HashSet<String> hs = new HashSet<String>();

        for(int i = 0; i < colors.length; i++) {
            hs.add(colors[i]);

        System.out.println(hs);

        boolean found = hs.contains("Black");
        System.out.println(found);

        Iterator it = hs.iterator();
        while(it.hasNext())
            System.out.println(it.next());

        for(String s: hs)
            System.out.println(s);

        }

         */
    }

    public static void findDistinct2(String s) {
        HashMap<String, Integer> hm = new HashMap<>();
        String[] words = s.split(" ");
        for(String st: words) {
            Integer frequency = hm.get(st);
            if(frequency == null)
                frequency = 1;
            else {
                frequency ++;
            }
            hm.put(st, frequency);
        }
        System.out.println(hm);
    }

}
