package com.example.spring.learn.demo;

import com.example.spring.learn.demo.entity.AnimalFactory;
import com.example.spring.learn.demo.entity.Monkey;
import com.example.spring.learn.demo.entity.Zoo;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class SpringLearnDemoApplication {

    public static void main(String[] args) {
//        springapplication.run(springlearndemoapplication.class, args);
        String filename = "bean.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(filename);

        Zoo zoo = context.getBean(Zoo.class);
        System.out.println(context.getBean(Monkey.class));
        System.out.println(zoo.getMonkey());

//        AnimalFactory animalFactory = context.getBean(AnimalFactory.class);
//
//        System.out.println(context.getBean("tiger"));
//        System.out.println(animalFactory.getAnimal());
        //自定义

    }

}
