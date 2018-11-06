//package com.example.demo.Metrics;
//
//import org.junit.Test;
//
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.IntStream;
//
//import static org.junit.Assert.*;
//
//public class MeterTest {
//
//    private Meter meter = new Meter();
//
//    @Test
//    public void mark() throws InterruptedException {
//        IntStream.rangeClosed(1, 100).forEach( a -> {
//            meter.mark(a);
//        });
//        TimeUnit.SECONDS.sleep(6);
//        double oneMinuteRate = meter.getOneMinuteRate();
//        double fiveMinuteRate = meter.getFiveMinuteRate();
//        double fifteenMinuteRate = meter.getFifteenMinuteRate();
//
//        System.out.println(oneMinuteRate);
//        System.out.println(fiveMinuteRate);
//        System.out.println(fifteenMinuteRate);
//        System.out.println(meter.getMeanRate());
//
//    }
//
//    @Test
//    public void mark1() throws InterruptedException {
//
//        long l = System.nanoTime();
//        TimeUnit.SECONDS.sleep(6);
//        long l2 = System.nanoTime() - l;
//        System.out.println(l2);
//        System.out.println(TimeUnit.SECONDS.toNanos(6));
//    }
//
//    @Test
//    public void getOneMinuteRate() {
//    }
//
//    @Test
//    public void getFiveMinuteRate() {
//    }
//
//    @Test
//    public void getFifteenMinuteRate() {
//    }
//}