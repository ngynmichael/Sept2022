package com.saran;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.saran.model.Employee;
import com.saran.model.Product;

public class App 
{
    public static void main( String[] args )
    {
    	//Resource object represents the information of spring.xml files
   /*     Resource r=new ClassPathResource("spring.xml");
        //BeanFactory is an IOC Cotainer & its repsonsbile to inject the dependencies
        BeanFactory factory=new XmlBeanFactory(r);*/
        //ApplicationCtx is the one we can able to get the spring java object by loading our spring.xml
    	ApplicationContext factory=new  ClassPathXmlApplicationContext("spring.xml");
        //getBean() returns the object of the Product class
        
        Product p=(Product)factory.getBean("prd");
        p.getProductDetails();
        
        Employee e=(Employee)factory.getBean("emp");
        e.setEmpId(123);
        System.out.println(e);
        
    }
}
