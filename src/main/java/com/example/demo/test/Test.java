package com.example.demo.test;

import com.example.demo.aop.AopTest;
import org.springframework.aop.framework.ProxyFactory;

import org.springframework.http.client.support.ProxyFactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


@Component
public class Test  {

//    private Logger logger = LoggerFactory.getLogger(Test.class);
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        logger.info(bean.toString()+" before");
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        logger.info(bean.toString()+" after");
//        return bean;
//    }

    public String hello(String name){
        return "hello " + name;
    }

    public static void main(String[] args) {
        // 需要被代理的对象传入到proxyFactory
         // Test --》 joinpoint
//        ProxyFactory proxyFactory = new ProxyFactory(new Test());
//        proxyFactory.addAdvice(new AopTest());
//        Test proxy = (Test)proxyFactory.getProxy();
//        System.out.println(proxy.hello("zjw"));

        // AopProxy 的实现类 实现了真正的Jdk和CGlib动态代理
        // 如何判断  本身是接口或者本身已经是动态代理生成的对象
        AddTwoNumber o = (AddTwoNumber)Proxy.newProxyInstance(AddTwoNumber.class.getClassLoader(), new Class<?> []{AddTwoNumber.class}, new ProxyHandler1());
        o.get();
    }
}

interface AddTwoNumber{
    void get();
}

class AddTwoNumberImpl implements AddTwoNumber{


    @Override
    public void get() {
        System.out.println("get");
    }
}

class ProxyHandler1 implements InvocationHandler{

    private AddTwoNumber addTwoNumber = new AddTwoNumberImpl();
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = method.invoke(addTwoNumber, args);
        System.out.println("after");
        return invoke;
    }
}



