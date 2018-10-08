package com.example.demo.code.other;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ClassNameSolution443
 * @Description TODO
 * @Author apple
 * @Date 2018/8/28 11:20 PM
 * @Version 1.0
 */
public class Solution443 {
    /**
     * 输入：
     ["a","a","b","b","c","c","c"]

     输出：
     返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]

     说明：
     "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
     示例 2：

     输入：
     ["a"]

     输出：
     返回1，输入数组的前1个字符应该是：["a"]

     说明：
     没有任何字符串被替代。
     示例 3：

     输入：
     ["a","b","b","b","b","b","b","b","b","b","b","b","b"]

     输出：
     返回4，输入数组的前4个字符应该是：["a","b","1","2"]。

     说明：
     由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
     注意每个数字在数组中都有它自己的位置。
     */
    public int compress(char[] chars) {
        char curr = chars[0];
        int count = 0;
        int tempCount = 0;
        for (int i = 0; i < chars.length; ) {
            while (i <= chars.length-1 && chars [i] == curr ){
                tempCount++;
                i++;
            }
            // 第一个不相等
            if (tempCount == 1){
                chars[count] = curr;
                count++;
            }else{
                // tempcount == 3
                chars[count++] = curr;
                char[] chars1 = String.valueOf(tempCount).toCharArray();
                for (int j = 0; j < String.valueOf(tempCount).length(); j++) {
                    chars[count++] = chars1[j];
                }
            }
            tempCount = 0;
            if (i > chars.length-1)
                break;
            curr = chars[i];
        }
        Stream.of(chars).forEach(System.out::print);
        System.out.println();
        return count;
    }

    @Test
    public void test(){
        int compress = compress(new char[]{'a', 'b', 'b', 'b'});
        Assert.assertEquals(3, compress);
    }

    @Test
    public void test_1(){
        int compress = compress(new char[]{'a', 'b', 'b', 'b','c'});
        Assert.assertEquals(4, compress);
    }

    @Test
    public void test_2(){
        int compress = compress(new char[]{'a', 'a'});
        Assert.assertEquals(2, compress);
    }

}
