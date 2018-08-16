package com.example.demo.fuction_programing;


import org.junit.Assert;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-13 20:41
 **/
public class Test {
    static List<User> users = Arrays.asList(new User().setName("zjw").setAge(18).setPasswd("word"),new User().setName("zliuyu").setAge(18).setPasswd("wordwwww"));

    static Optional<User> filter(User user){
        return Optional.of(new User().setName(user.getName()+" after optional"));
    }

    @org.junit.Test
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> complete_over = CompletableFuture.completedFuture("complete over");
        Assert.assertTrue(complete_over.isDone());
        Assert.assertEquals(complete_over.getNow(null), "complete over");
        CompletableFuture<Void> sleep_over = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sleep over");
        });
        Assert.assertFalse(sleep_over.isDone());
        Thread.sleep(2000);
        Assert.assertTrue(sleep_over.isDone());
        System.out.println(Runtime.getRuntime().availableProcessors());

    }

    // 自己去包装流
    private static <T> Stream<T> nonEmptyStream(
            Stream<T> stream, Supplier<RuntimeException> e) {

        Spliterator<T> it=stream.spliterator();
        return StreamSupport.stream(new Spliterator<T>() {
            boolean seen;
            public boolean tryAdvance(Consumer<? super T> action) {
                boolean r=it.tryAdvance(action);
                if(!seen && !r) throw e.get();
                seen=true;
                return r;
            }
            public Spliterator<T> trySplit() { return null; }
            public long estimateSize() { return it.estimateSize(); }
            public int characteristics() { return it.characteristics(); }
        }, false);
    }





}
