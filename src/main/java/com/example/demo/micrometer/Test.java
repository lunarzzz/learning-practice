package com.example.demo.micrometer;

import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import io.micrometer.core.instrument.distribution.HistogramSnapshot;
import io.micrometer.core.instrument.distribution.ValueAtPercentile;
import io.micrometer.core.instrument.dropwizard.DropwizardTimer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import io.micrometer.core.instrument.step.StepCounter;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassNameTest
 * @Description TODO
 * @Author apple
 * @Date 2018/10/20 12:30 AM
 * @Version 1.0
 */


public class Test {


    @org.junit.Test
    public void test() {
//
//        AnnotationUtils.findAnnotation(, String.class);
        MeterRegistry registry = new SimpleMeterRegistry();
        Timer test = Timer.builder("test").publishPercentileHistogram().publishPercentileHistogram(true).publishPercentiles(.5).register(registry);
        IntStream.rangeClosed(1, 100).forEach(a -> test.record(a, TimeUnit.SECONDS));
        double max = test.max(TimeUnit.SECONDS);
        System.out.println("max:" + max);
        double mean = test.mean(TimeUnit.SECONDS);
        System.out.println("mean:" + mean);
        double percentile = test.percentile(.5, TimeUnit.SECONDS);
        System.out.println("50%:" + percentile);
        Timer timer = registry.timer("test");
        System.out.println("************");
        DistributionSummary summary = DistributionSummary.builder("test1").publishPercentileHistogram().publishPercentiles(.5, .75, .95, .99).register(registry);
        IntStream.rangeClosed(1, 1000).forEach(a -> summary.record(a));
        double mean1 = summary.mean();
        System.out.println("mean:" + mean1);
        double max1 = summary.max();
        System.out.println("max:" + max1);
        HistogramSnapshot histogramSnapshot = summary.takeSnapshot();
        ValueAtPercentile valueAtPercentile0 = histogramSnapshot.percentileValues()[0];
        ValueAtPercentile valueAtPercentile1 = histogramSnapshot.percentileValues()[1];
        ValueAtPercentile valueAtPercentile2 = histogramSnapshot.percentileValues()[2];
        double value0 = valueAtPercentile0.value();
        double value1 = valueAtPercentile1.value();
        double value2 = valueAtPercentile2.value();
        System.out.println("5%:" + value0);
        System.out.println("75%:" + value1);
        System.out.println("95%:" + value2);
//        System.out.println("99%:" + value2);
        System.out.println("*********");
    }


    @org.junit.Test
    public void name() {
//        StepCounter stepCounter =
    }
}
