package cn.jason.demo;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JSON操作工具类
 * 
 * @JsonUtils.java
 * @author yaobo
 * @2013-2-1 上午10:28:11 www.gopay.com.cn Inc.All rights reserved.
 */
public class JsonUtils {
	/**
     * 将Json转换为List
     * 
     * @param content
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
 @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> toList(String content) throws JsonParseException, JsonMappingException,
            IOException {
        if (StringUtils.isBlank(content)) {
            return null;
        }

        List<Map<String, Object>> model = new ArrayList<Map<String, Object>>();
        ObjectMapper mapper = new ObjectMapper();

        model = mapper.readValue(content, List.class);

        return model;
    }
    /**
     * 将Json转换为Map
     * 
     * @param content
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> toMap(String content) throws JsonParseException, JsonMappingException,
            IOException {
        if (StringUtils.isBlank(content)) {
            return null;
        }

        Map<String, String> model = new HashMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();

        model = mapper.readValue(content, Map.class);

        return model;
    }

    /**
     * 将JSON串转为Map
     * 
     * @param json
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> jsonToMap(String json) throws JsonParseException, JsonMappingException,
            IOException {
        if (StringUtils.isBlank(json)) {
            return null;
        }

        Map<String, Object> model = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();

        model = mapper.readValue(json, Map.class);

        return model;
    }

    /**
     * 将对象解析为json串
     * 
     * @param obj
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static String toJson(Object obj) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(obj);

        return json;
    }
}
