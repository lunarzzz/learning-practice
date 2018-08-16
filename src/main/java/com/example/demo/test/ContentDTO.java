package com.example.demo.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ContentDTO {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        List<User1> user1s = Arrays.asList(new User1(1, 2), new User1(1, 3), new User1(2, 6));
        List<Integer> collect = user1s.stream().map(User1::getAge).distinct().collect(Collectors.toList());
        collect.forEach((u)->
            System.out.println(u)
        );
    }
}


class User1{
    int age;
    int number;

    public User1(int age, int number) {
        this.age = age;
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
