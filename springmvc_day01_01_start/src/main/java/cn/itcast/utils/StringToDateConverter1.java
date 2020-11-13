package cn.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把字符串转换成日期
 */
public class StringToDateConverter1 implements Converter<String, Date> {
    /**
     * @param s 传入进来的字符串的值
     * @return
     */
    @Override
    public Date convert(String s) {
        if(s == null) {
            throw new RuntimeException("请传入参数");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //把字符串转换成日期
            return df.parse(s);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出现了错误");
        }
    }
}
