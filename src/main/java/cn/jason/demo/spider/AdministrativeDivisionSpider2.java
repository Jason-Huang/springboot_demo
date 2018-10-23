package cn.jason.demo.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java实现爬虫
 */
public class AdministrativeDivisionSpider2 {


    public static void main(String[] args) {
        Map<String, String> provinceMap = new HashMap<>();
        Map<String, String> cityMap = new HashMap<>();
        Map<String, String> countyMap = new HashMap<>();
        String spec = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/index.html";
        Elements proElmts = spider(spec);
        List<Xzqh> provinceList = new ArrayList<>();
        List<Xzqh> cityList = new ArrayList<>();
        List<Xzqh> countyList = new ArrayList<>();
        chouqu(provinceMap, proElmts, "[0-9]+.html", null, provinceList);
        for (Map.Entry entry : provinceMap.entrySet()) {
            System.out.println("【省】" + entry);
            Elements cityElements = spider("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/" + entry.getKey() + ".html");
            chouqu(cityMap, cityElements, "[0-9]+.html", entry.getKey() + "", cityList);
        }
        for (Map.Entry cityEntry : cityMap.entrySet()) {
            try {
                System.out.println("【市】" + cityEntry);
                Elements countyElements = spider("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/" + cityEntry.getKey() + ".html");
                String superiorCode = cityEntry.getKey() + "";
                chouqu(countyMap, countyElements, "[0-9]+.html", superiorCode.substring(superiorCode.indexOf("//")), countyList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(provinceList);
        System.out.println(cityList);
        System.out.println(countyList);
    }

    private static Elements spider(String spec) {
        System.out.println("url=" + spec);
        URL url = null;
        try {
            url = new URL(spec);
            Document doc = Jsoup.parse(url, 10000);
            Elements elements = doc.select("a");
            return elements;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private static void chouqu(Map<String, String> map, Elements elements, String regex, String superiorCode, List list) {
        Xzqh xzqh = new Xzqh();
        String urlstr;
        String name;
        Pattern pattern = Pattern.compile(regex);
        try {
            for (Element element : elements) {
                urlstr = element.attr("href");
                Matcher matcher = pattern.matcher(urlstr);
                if (matcher.find()) {
                    name = element.html().replace("<br>", "");
                    map.put(urlstr.substring(0, urlstr.indexOf(".")), name);
                    xzqh.setCode(urlstr.substring(urlstr.indexOf("//") >= 0 ? urlstr.indexOf("//") : 0, urlstr.indexOf(".")));
                    xzqh.setName(name);
                    xzqh.setSuperiorCode(superiorCode);
                    list.add(xzqh);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}