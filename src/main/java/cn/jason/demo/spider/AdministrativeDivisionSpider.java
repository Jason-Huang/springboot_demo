package cn.jason.demo.spider;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java实现爬虫
 */
public class AdministrativeDivisionSpider {
    // 所有省份代码
//    static final String[] provinceArray = {"11", "12", "13", "14", "15", "21", "22", "23", "29", "32", "33", "34", "35", "36", "37", "41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65", "71", "81", "82"};
    Map<String, String> provinceMap = new HashMap<>();
    Map<String, String> cityMap = new HashMap<>();
    Map<String, String> countyMap = new HashMap<>();

    public BufferedReader spiderURL(String url) {
        URL realURL;
        URLConnection connection;
        BufferedReader br = null;

        try {
            realURL = new URL(url);
            connection = realURL.openConnection();
            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "gb2312"));
            return br;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return br;
    }


    public static void main(String[] args) throws IOException {
        String url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/index.html";
        String regex = "[0-9]+.html";
        AdministrativeDivisionSpider spider = new AdministrativeDivisionSpider();
        BufferedReader bufferedReader = spider.spiderURL(url);
        String line;
        Pattern pattern = Pattern.compile(regex);
        while ((line = bufferedReader.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }

    }
}