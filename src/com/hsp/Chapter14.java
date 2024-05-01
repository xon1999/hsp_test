/*
 * Copyright (c) 2024. All rights reserved.
 */

package com.hsp;

import java.util.*;

/**
 * @Author： zangaiyao
 * @Date： 2024/4/30 22:28
 * @Describe：
 */
public class Chapter14 {
    @SuppressWarnings("all")
    void testP601(){
        // ArrayList是List接口的实现类，由数组存储数据，线程不安全，多线程不使用。
        //扩容原理：无参构造器初始size为0，第一次扩容改为10，再次扩容1.5倍，往后如此。
        //指定大小扩容器，直接按照1.5倍扩容。
        //Vector 与 ArrayList 相比，2倍扩容。线程安全，但是效率不高。
        ArrayList arrayList = new ArrayList();
        arrayList.add("jack");
        arrayList.add("queen");
        arrayList.add(10);

        HashMap hashMap = new HashMap();
        hashMap.put("NO1","BJC");
        hashMap.put("NO2","SH");

        List list = new ArrayList();
        list.add("jimmy");
        list.add(12);
        list.add(true);
        list.remove(1);
        System.out.println(list.contains("jimmy"));
        System.out.println(list.size());
        list.addAll(arrayList);
        List listCopy;
        listCopy =List.copyOf(list);
        list.removeAll(arrayList);
//        listCopy.removeAll(listCopy); 报错UnsupportedOperationException
        System.out.println(list);
        System.out.println(listCopy);
        // 迭代器 next() hasNext() remove()
        Iterator iterator = listCopy.iterator();
        //快捷键 itit
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //for循环遍历可迭代对象
        for (Object o:listCopy) {
            System.out.println(o);
        }
        /**
         * 以Set接口的实现类 HashSet 讲解 Set 接口的方法
         * 不能存放重复的元素，存放数据是无序的,因此无索引
         * 取出的顺序不是添加的顺序，但是是固定的
         */

        Set set = new HashSet();
        set.add("ava");
        set.add("Bella");
        set.add("Diana");
        set.add("Eileen");
        set.add(null);
        Iterator iterator1 = set.iterator();
        while (iterator1.hasNext()) {
            Object next =  iterator1.next();
            System.out.println(next);
        }
        for (Object o : set) {
            System.out.println(o);
        }
    }
}
