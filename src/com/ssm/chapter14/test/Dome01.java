package com.ssm.chapter14.test;

import redis.clients.jedis.Jedis;

public class Dome01 {
    public static void main(String args[]){
        Jedis jedis = new Jedis("localhost",6379);
        int i = 0;
        try{
            long start = System.currentTimeMillis();
            while(true)
            {
                long end = System.currentTimeMillis();
                if (end - start >= 1000)
                {
                    break;
                }
                i++;
                jedis.set("test"+i,i+"");
            }
        }finally {
            jedis.close();
        }
        System.out.println("redis每秒操作："+i+"次");
    }
}
