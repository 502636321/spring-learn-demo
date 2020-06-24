package com.example.spring.learn.demo;

import com.example.spring.learn.demo.entity.AnimalFactory;
import com.example.spring.learn.demo.entity.Monkey;
import com.example.spring.learn.demo.entity.Zoo;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.*;
import javax.xml.parsers.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//@SpringBootApplication
public class SpringLearnDemoApplication {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, ClassNotFoundException {
//        springapplication.run(springlearndemoapplication.class, args);
        String filename = "bean.xml";
//        ApplicationContext context = new GenericXmlApplicationContext(filename);
//
//        Zoo zoo = context.getBean(Zoo.class);
//        System.out.println(context.getBean(Monkey.class));
//        System.out.println(zoo.getMonkey());
//
//        ClassPathResource resource = new ClassPathResource(filename);
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
//        reader.loadBeanDefinitions(resource);
//
//        System.out.println(reader);
//        AnimalFactory animalFactory = context.getBean(AnimalFactory.class);
//
//        System.out.println(context.getBean("tiger"));
//        System.out.println(animalFactory.getAnimal());
        //自定义

        // XML文件读取

        Map<String, Class> beanDefinitionMap = new HashMap<>();
        Map<String, Object> beanInstanceMap = new HashMap<>();

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        Document document = builder.parse(ClassLoader.getSystemResourceAsStream(filename));


        NodeList beans = document.getElementsByTagName("bean");

        for (int i = 0; i < beans.getLength(); i++) {
            Element bean = (Element) beans.item(i);

            String id = bean.getAttribute("id");
            String clazz = bean.getAttribute("class");

            beanDefinitionMap.put(id, Class.forName(clazz));
        }
        // 生成 BEAN 实例

        beanDefinitionMap.forEach((k, v) -> {
            try {
                beanInstanceMap.put(k, v.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        beanInstanceMap.forEach((s, o) -> {
            System.out.printf("%s - %s %n", s, o);
        });
    }

}
