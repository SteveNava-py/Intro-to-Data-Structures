package everythingHash;

import java.util.HashSet;

public class PhoneNumberTest {
    public static void main(String [] args) {
        PhoneNumber p1 = new PhoneNumber(609, 258, 4455);
        PhoneNumber p2 = new PhoneNumber(609, 879, 5309);
        PhoneNumber p3 = new PhoneNumber(609, 555, 5309);
        PhoneNumber p4 = new PhoneNumber(215, 876, 5309);
        PhoneNumber p5 = new PhoneNumber(609, 879, 5309);

        HashSet<PhoneNumber> hs = new HashSet<>();
        hs.add(p1);
        hs.add(p2);
        hs.add(p3);
        hs.add(p4);
        hs.add(p5);
        System.out.println(hs);
        System.out.println(p2 == p5);
        System.out.println(p2.hashCode() == p5.hashCode()); 
    }
}
