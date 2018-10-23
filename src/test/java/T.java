import cn.jason.demo.util.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class T {
    public static void main(String[] args) throws IOException {
        String s = "{\"\":\"\"}";
        Map<String, String> map = JsonUtils.toMap(s);
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("结束");

    }
}
