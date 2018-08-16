package com.example.demo.test;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-07 15:32
 **/
public class Jira {

    /**
     *
     * @param rowInfoSet 需要迭代的集合
     * @param separator 分隔符
     * @param count 多分割符的分割间隔数
     * @param lineBreak 多分割符
     * @return
     */
    public static String joinWithLineBreak(Iterable<?> rowInfoSet, String separator, int count, String lineBreak) {
        if (rowInfoSet == null){
            return null;
        }
        Iterator<?> iterator = rowInfoSet.iterator();
        if (!iterator.hasNext()){
            return "";
        }
        Object first = iterator.next();
        if (!iterator.hasNext()) {
            return first.toString();
        } else {
            StringBuilder buf = new StringBuilder(256);
            if (first != null) {
                buf.append(first);
            }
            int tempCount = 0;
            while (iterator.hasNext()) {
                tempCount++;
                if (separator != null) {
                    buf.append(separator);
                    if (tempCount % count == 0) {
                        buf.append(lineBreak);
                    }
                }
                Object obj = iterator.next();
                if (obj != null) {

                    buf.append(obj);

                }
            }
            return buf.toString();
        }
    }

    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("123","456","123","456","123","456","123","456","123","456","123","456",
                "123","456","123","456","123","456","123","456","123","456","123","456","123","456","123","456","123","456",
                "123","456","123","456","123","456","123","456","123","456");
//        Collection<String> collection = Arrays.asList("123","456","1232123213123");
        String s = joinWithLineBreak(collection, ",", 3,"<br/>");
        System.out.println(s);

    }
}
