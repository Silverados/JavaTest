package JsonTest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class JsonTest1 {
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
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.writeValue(writer, obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return writer.toString();
    }
}
