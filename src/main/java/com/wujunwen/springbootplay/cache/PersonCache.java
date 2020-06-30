package com.wujunwen.springbootplay.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * person缓存
 */
public class PersonCache {
    //todo 多实例情况下的缓存同步?

    public static ConcurrentHashMap<Integer,Person> personHashMap=new ConcurrentHashMap<Integer,Person>();

    public static ConcurrentHashMap<Integer,Long> useRecord= new ConcurrentHashMap<Integer,Long>();
}
