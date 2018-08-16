package com.example.demo.code;

import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @description: 下一个排列
 * @author: zhangjiawei
 * @create: 2018-08-10 10:27
 **/
public class Solution31 {

//    @Test
    public void name() {
        List<Integer> integers = Arrays.asList(1, 3, 4, 5, 67, 8);
        // 将所有的操作合并到一个结果中
        integers.stream().reduce((a,b)-> a>b? a:b).ifPresent(a -> System.out.println("max is " + a));
        integers.stream().reduce((a,b)-> a>b? a:b);
        Integer res  = 0 ;

        // 输入一个实体值
        Integer reduce = integers.stream().reduce(res, (a, b) -> a + b);


        // 输入一个标识符 在paralerStream下调用第三个参数；
        Integer reduce1 = integers.parallelStream().reduce(0, (a, b) -> a + b, (a, b) -> a + b);
//        Assert.assertEquals(reduce1.intValue(),88);

        //
        long count = integers.parallelStream().map(a -> a + 1).count();
        List<User1> user1s = Arrays.asList(new User1("a", 12), new User1("c", 2), new User1("b", 67), new User1("b", 12));
//        Assert.assertEquals(count,6);
//        Collections.sort(user1s,Comparator.comparing(User1::getName).thenComparing(User1::getInteger));
        user1s.sort(Comparator.comparing(User1::getName).thenComparingInt(User1::getInteger));
        user1s.forEach(System.out::println);

        Optional option;

    }

    class User1{
        String name;
        Integer integer;

        public String getName() {
            return name;
        }

        public User1 setName(String name) {
            this.name = name;
            return this;
        }

        public Integer getInteger() {
            return integer;
        }

        public User1 setInteger(Integer integer) {
            this.integer = integer;
            return this;
        }

        public User1(String name, Integer integer) {
            this.name = name;
            this.integer = integer;
        }

        @Override
        public String toString() {
            return "User1{" +
                    "name='" + name + '\'' +
                    ", integer=" + integer +
                    '}';
        }
    }
}
