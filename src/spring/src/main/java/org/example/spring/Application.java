package org.example.spring;

import org.example.spring.annotationconfig.BikeConstructor;
import org.example.spring.annotationconfig.BikeSetter;
import org.example.spring.xmlconfig.CarConstructor;
import org.example.spring.xmlconfig.CarSetter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Application {

    public static void main(String[] args) {

//        XML configuration
        ApplicationContext context1 = new ClassPathXmlApplicationContext("xmlconfig/XmlAppConfig.xml");

        System.out.println("XML configuration");
        CarConstructor carConstructor =  context1.getBean("carConstructor", CarConstructor.class);
        carConstructor.showEngine();
        CarSetter carSetter = context1.getBean("carSetter", CarSetter.class);
        carSetter.showEngine();

        //Annonation configuration
        System.out.println("\nAnnotation configuration");
        ApplicationContext context2 = new AnnotationConfigApplicationContext("org.example.spring.annotationconfig");
        context2.getBean(BikeConstructor.class).showCog();
        context2.getBean(BikeSetter.class).showCog();
    }

}
