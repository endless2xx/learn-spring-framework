/*
 * @class BeanFactoryTest
 * @package com.endlexx.bean
 * @date 2019/9/18 21:53
 * Copyright (c) 2019 Endlexx
 */
package com.endlexx.bean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * @author Endlexx 2019/9/18 21:53
 * @version V1.0
 * modifyTime           author              description
 * -------------------------------------------------------------------
 */
public class BeanFactoryTest {

    @Test
    public void testSimpleLoad() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("application.xml"));
        MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");

        assertEquals("testStr", bean.getTestStr());
    }

    @Test
    public void readFile() {
        Resource resource = new FileSystemResource("E:\\endless2xx.github.com\\Java-Learn\\learn-spring-framework\\spring-bean\\pom.xml");

        try {
            InputStream inputStream = resource.getInputStream();

            System.out.println(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
