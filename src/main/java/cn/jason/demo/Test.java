package cn.jason.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        List l = new ArrayList<>();
//        HashMap<String, String> m = new HashMap<>();
//        m.put("id","1111111111111");
//        m.put("r", "0");
//        m.put("f", "0");
//        l.add(m);
//        m.put("id","2222222222222");
//        m.put("r", "0");
//        m.put("f", "0");
//        l.add(m);
//        m.put("id","3333333333333");
//        m.put("r", "0");
//        m.put("f", "0");
//        l.add(m);
        Result r = new Result("111","456","789");
        Result r1 = new Result("222","456","789");
        Result r2 = new Result("333","456","789");
        

        l.add(r);
        l.add(r1);
        l.add(r2);
        System.out.println(JsonUtils.toJson(l));
                HashMap m2 = new HashMap<>();
        m2.put("1111111111111", new String[]{"0", "0"});
        m2.put("2222222222222", new String[]{"0", "0"});
        m2.put("3333333333333", new String[]{"0", "0"});
        System.out.println(JsonUtils.toJson(m2));
    }

}
