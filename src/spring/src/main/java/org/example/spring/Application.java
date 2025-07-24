package org.example.spring;

import org.example.spring.annotationconfig.BikeConstructor;
import org.example.spring.annotationconfig.BikeSetter;
import org.example.spring.scopeDemo.PrototypeService;
import org.example.spring.scopeDemo.SingletonService;
import org.example.spring.xmlconfig.CarConstructor;
import org.example.spring.xmlconfig.CarSetter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Application {

    public static void main(String[] args) {

        //XML configuration
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

        //Scope
        System.out.println("\nScope demo");
        ApplicationContext context3 = new AnnotationConfigApplicationContext("org.example.spring.scopeDemo");

        //Singleton
        SingletonService singletonService1 = context3.getBean(SingletonService.class);
        SingletonService singletonService2 = context3.getBean(SingletonService.class);
        assert singletonService1 == singletonService2 : "Service is not singleton";

        if (singletonService1 == singletonService2) {
            System.out.println("SingletonService: PASSED (cùng instance)");
        } else {
            System.out.println("SingletonService: FAILED (không cùng instance)");
        }
        //Prototype
        PrototypeService prototypeService1 = context3.getBean(PrototypeService.class);
        PrototypeService prototypeService2 = context3.getBean(PrototypeService.class);
        assert prototypeService1 != prototypeService2 : "Service is not prototype";

        if (prototypeService1 != prototypeService2) {
            System.out.println("PrototypeService: PASSED (khác instance)");
        } else {
            System.out.println("PrototypeService: FAILED (cùng instance)");
        }
    }

}
