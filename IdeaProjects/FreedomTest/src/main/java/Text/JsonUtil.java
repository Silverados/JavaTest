/**
 * Amendment History
 *
 * 	Amended       by: liangyanjun
 * 	Amendment   Date: 2018/3/12
 * 	Amendment Number: A20180312
 * 	Amendment Detail: initial version - JSON util
 *
 * Copyright (C) 2018 1ziton
 *
 * WARNING:
 * This code is the sole property of 1ziton and is protected
 * by international copyright laws.
 * This program is confidential and proprietary, not to be disclosed
 * without written authorization from Ignite Vision Limited.
 * Any use, duplication, or disclosure of this program by other than
 * 1ziton strictly forbidden by law.
 */
package Text;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

public class JsonUtil {

    /**
     * Convert object to JSON string
     *
     * @param obj
     * @return
     */
    public static String toJsonString(Object obj){
        ObjectMapper mapper = null;
        StringWriter writer = null;

        try {
            mapper = new ObjectMapper();
            writer = new StringWriter();
            mapper.setSerializationInclusion(Include.NON_NULL);
            mapper.writeValue(writer, obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return writer.toString();
    }

    /**
     * Convert JSON string to object
     *
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T toObject(String json, Class<T> clazz){
        T t = null;
        ObjectMapper mapper = null;

        try {
            mapper = new ObjectMapper();
            mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);

            t = mapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return t;
    }

    /**
     * Convert JSON string to Map
     *
     * @param json
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> toMap(String json){
        return toObject(json, Map.class);
    }

    /**
     * Convert JSON string to Map
     *
     * @param json
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Map<String, T> toObjectMap(String json){
        return toObject(json, Map.class);
    }

    /**
     * Convert JSON string to List
     *
     * @param json
     * @param clazz
     * @return
     */
    public static <T> List<T> toList(String json, Class<T> clazz){
        List<T> list = null;
        JavaType javaType = null;
        ObjectMapper mapper = null;

        try {
            mapper = new ObjectMapper();
            mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);

            javaType = mapper.getTypeFactory().constructParametricType(List.class, clazz);
            list = mapper.readValue(json, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
