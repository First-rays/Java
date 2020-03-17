package frank.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class JSONUtil {

    //yyyy-MM-dd HH:mm:ss
    //序列化操作：java对象转化为json对象字符串
    public static String serialize(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat(Constant.DATE_PATTERN));
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON序列化失败"+ obj , e);
        }
    }
   //从输入流获取数据，反序列化为只指定一个Java类型对象
    public static <T> T deserialize(InputStream is, Class<T>clazz){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat(Constant.DATE_PATTERN));
        try {
            return objectMapper.readValue(is,clazz);
        } catch (IOException e) {
            throw new RuntimeException("JSON序列化失败", e);
        }
    }



}
