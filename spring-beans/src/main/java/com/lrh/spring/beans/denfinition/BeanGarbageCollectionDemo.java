package com.lrh.spring.beans.denfinition;

import com.lrh.spring.beans.factory.DefaultUserFactory2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * spring bean  的垃圾回收
 */
public class BeanGarbageCollectionDemo {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(BeanGarbageCollectionDemo.class);

        annotationConfigApplicationContext.refresh();

        annotationConfigApplicationContext.close();
        System.out.println("Spring 已关闭.....");

//        Thread.sleep(5000);

        //强制GC
        System.gc();

        Thread.sleep(5000);
    }


    @Bean(destroyMethod = "preClose",initMethod = "initUserFactory")
    public DefaultUserFactory2 defaultUserFactory2(){
        return new DefaultUserFactory2();
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("当前对象正在被GC");
        super.finalize();
    }
}
