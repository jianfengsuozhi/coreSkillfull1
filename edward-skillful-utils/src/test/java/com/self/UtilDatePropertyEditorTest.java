package com.self;

import com.test.Bean1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Edward on 2016/9/26.
 */
public class UtilDatePropertyEditorTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-Utis.xml");
        Bean1 bean1 = ctx.getBean("bean1", Bean1.class);
        System.out.println(bean1.getDate());
    }
}
