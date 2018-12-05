package com.example.demo.config;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.Marker;

/**
 * @ClassNameLogFilter
 * @Description TODO
 * @Author apple
 * @Date 2018/11/30 8:50 AM
 * @Version 1.0
 */
public class LogFilter extends TurboFilter {

//    @Override
//    public FilterReply decide(ILoggingEvent iLoggingEvent) {
//        System.out.println("filter");
//        return FilterReply.ACCEPT;
//    }

    @Override
    public FilterReply decide(Marker marker, Logger logger, Level level, String s, Object[] objects, Throwable throwable) {
        System.out.println("turbo filter hello");

        return FilterReply.ACCEPT;
    }
}
