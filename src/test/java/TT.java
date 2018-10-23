import java.util.Collections;
import java.util.LinkedList;

public class TT {
    static LinkedList<Integer> sSorted = new LinkedList<>();
    public static void main(String[] args) {
        sSorted.add(99);
        sSorted.add(3);
        sSorted.add(6);
        sSorted.add(128);
        Collections.sort(sSorted);
        while (!sSorted.isEmpty()){
//            System.out.println(sSorted.add());
        }

        System.out.println(sSorted);

    }
}
