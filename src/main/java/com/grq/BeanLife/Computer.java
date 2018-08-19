package com.grq.BeanLife;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Computer implements BeanFactoryAware, BeanNameAware,
        InitializingBean, DisposableBean {

    private String name;
    private String brand;
    private String serial;

    private BeanFactory beanFactory;
    private String beanName;

    public Computer() {
        System.out.println("【构造器】调用 Computer 的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【注入属性】注入属性name");
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("【注入属性】注入属性 brand");
        this.brand = brand;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        System.out.println("【注入属性】注入属性 serial");
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }

    // 这是BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        System.out.println("【BeanFactoryAware接口】Computer 调用 BeanFactoryAware.setBeanFactory()");
        this.beanFactory = arg0;
    }

    // 这是BeanNameAware接口方法
    @Override
    public void setBeanName(String arg0) {
        System.out.println("【BeanNameAware接口】Computer 调用BeanNameAware.setBeanName()");
        this.beanName = arg0;
    }

    // 这是InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】Computer 调用InitializingBean.afterPropertiesSet()");
    }

    // 这是DiposibleBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】Computer 调用DiposibleBean.destory()");
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("【init-method】Computer 调用<bean>的init-method属性指定的初始化方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestory() {
        System.out.println("【destroy-method】Computer 调用<bean>的destroy-method属性指定的初始化方法");
    }
}