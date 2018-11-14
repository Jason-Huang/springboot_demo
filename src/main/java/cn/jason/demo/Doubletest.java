package cn.jason.demo;

import java.io.IOException;

public class Doubletest {
    public static void main(String[] args) throws IOException {
        double d = 5.456;
        System.out.println(d - 5);
        System.out.println();

        String len8 = "2.99999996";
        System.out.println(new Float(len8));
        String len7 = "2.9999996";
        System.out.println(new Float(len7));
        String len6 = "2.999996";
        System.out.println(new Float(len6));

        String len18 = "2.000000000000000005";
        System.out.println(new Double(len18));
        String len17 = "2.0000000000000005";
        System.out.println(new Double(len17));
        String len16 = "2.000000000000005";
        System.out.println(new Double(len16));

    }

}
