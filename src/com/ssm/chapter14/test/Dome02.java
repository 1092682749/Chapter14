package com.ssm.chapter14.test;

import com.ssm.chapter14.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

public class Dome02 {

    public static void main(String args[])
    {
//        System.out.println(Class.class.getClass().getResource("/").getPath() );

//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("WEB-INF/applicationContext.xml");
////        ct.getBean(RedisTemplate.class);
//        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
        RedisTemplate redisTemplate = new RedisTemplate();

        Role role = new Role();
        role.setId(1L);
        role.setRoleName("name_1");
        role.setNote("note_1");
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("role_1","111");
    }
    public static void test(ContextRefreshedEvent event){
        ApplicationContext applicationContext = event.getApplicationContext();
        WebApplicationContext webApplicationContext = (WebApplicationContext)applicationContext;
        ServletContext servletContext = webApplicationContext.getServletContext();
        String path0 = servletContext.getRealPath("/WEB-INF");
    }
}
