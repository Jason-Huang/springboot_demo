package cn.jason.demo;

public class StringConcatTest {
    public static void main(String[] args) {
        plus();
        concat();
        stringBuffer();
        stringBuilder();
    }

    public static void plus() {
        String initial = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            initial = initial + "a";
        }
        long end = System.currentTimeMillis();
        System.out.println("plus:" + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String a = "a";
            a = a + String.valueOf(i);
            //a = a + String.valueOf(i) + String.valueOf(i) + String.valueOf(i) + String.valueOf(i) + String.valueOf(i) + String.valueOf(i) + String.valueOf(i) + String.valueOf(i);
        }
        end = System.currentTimeMillis();
        System.out.println("double plus:" + (end - start));
    }

    public static void stringBuilder() {
        StringBuilder initial = new StringBuilder("");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            initial = initial.append("b");
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder:" + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            StringBuilder b = new StringBuilder("b");
            b.append(String.valueOf(i));
            //b.append(String.valueOf(i)).append(String.valueOf(i)).append(String.valueOf(i)).append(String.valueOf(i)).append(String.valueOf(i)).append(String.valueOf(i)).append(String.valueOf(i)).append(String.valueOf(i));
        }
        end = System.currentTimeMillis();
        System.out.println("double StringBuilder:" + (end - start));
    }

    public static void stringBuffer() {
        StringBuffer initial = new StringBuffer("");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            initial = initial.append("c");
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuffer:" + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            StringBuffer c = new StringBuffer("c");
            c.append(String.valueOf(i));
            //c.append(String.valueOf(i)).append(String.valueOf(i)).append(String.valueOf(i)).append(String.valueOf(i)).append(String.valueOf(i)).append(String.valueOf(i)).append(String.valueOf(i)).append(String.valueOf(i));
        }
        end = System.currentTimeMillis();
        System.out.println("double StringBuffer:" + (end - start));
    }

    public static void concat() {
        String initial = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            initial = initial.concat("d");
        }
        long end = System.currentTimeMillis();
        System.out.println("concat:" + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String d = "d";
            d = d.concat(String.valueOf(i));
//            d = d.concat(String.valueOf(i)).concat(String.valueOf(i)).concat(String.valueOf(i)).concat(String.valueOf(i)).concat(String.valueOf(i)).concat(String.valueOf(i)).concat(String.valueOf(i)).concat(String.valueOf(i));
        }
        end = System.currentTimeMillis();
        System.out.println("double concat:" + (end - start));
    }
}
