package com.ashin.service.utils;/**
 * Created by Administrator on 2019/9/7.
 */


import com.ashin.service.dto.PersonDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * java8中强大的stream api,让集合操作更高效
 * @Author:debug (SteadyJack)
 * @Date: 2019/9/7 22:26
 **/
public class Java8Util {

    private static List<PersonDto> list;

    //初始化对象集合
    static {
        list= Lists.newLinkedList();
        PersonDto dto1=new PersonDto(1,21,"赵六");
        PersonDto dto2=new PersonDto(2,20,"张三");
        PersonDto dto3=new PersonDto(3,22,"李四");
        PersonDto dto4=new PersonDto(4,20,"王五");

        list.add(dto1);
        list.add(dto2);
        list.add(dto3);
        list.add(dto4);
    }

    //筛选功能:filter 结合 collect方法 使用
    public static void method1(){
        //筛选年龄大于20的小伙子
        if (list!=null && !list.isEmpty()){
            System.out.println("\n--filter筛选功能1，结果：");

            List<PersonDto> resList=list.stream().filter(p -> p.getAge() > 20).collect(Collectors.toList());
            System.out.println(resList);
        }

        //筛选名字为 王五 的小伙子
        if (list!=null && !list.isEmpty()){
            System.out.println("\n--filter筛选功能2，结果：");

            List<PersonDto> resList=list.stream().filter(p -> "王五".equals(p.getName())).collect(Collectors.toList());
            System.out.println(resList);
        }
    }

    //转换map~按照指定的字段/元素属性进行转换：结合 collect 方法使用
    public static void method2(){
        if (list!=null && !list.isEmpty()){
            System.out.println("\n--转换map~按照指定的字段/元素属性进行转换，结果：");

            Set<String> nameSet=list.stream().map(PersonDto::getName).collect(Collectors.toSet());
            System.out.println(nameSet);
        }
    }

    //去重distinct ~ 配合对象的 equals() 和 hashCode()方法
    public static void method3(){
        //TODO：对象去重 - 对象需要实现equals hashCode方法
        list.add(new PersonDto(4,20,"王五"));
        System.out.println("去重以前："+list);
        List<PersonDto> resList=list.stream().distinct().collect(Collectors.toList());
        System.out.println("\n去重以后："+resList);
    }

    //排序sorted
    public static void method4(){
        //按照年龄排序、再按照id排序
        list.add(new PersonDto(0,20,"郑六"));
        if (list!=null && !list.isEmpty()){
            List<PersonDto> resList=list.stream()
                    .sorted(Comparator.comparingInt(PersonDto::getAge).thenComparing(Comparator.comparing(PersonDto::getId)))
                    .collect(Collectors.toList());
            System.out.println("按照年龄排序、再按照id排序-顺序：\n"+resList);
        }

        //按照年龄排序、再按照id排序 ~ 也可以将最终结果倒序来
        //list.add(new PersonDto(0,20,"郑六"));
        if (list!=null && !list.isEmpty()){
            List<PersonDto> resList=list.stream()
                    .sorted(Comparator.comparingInt(PersonDto::getAge).thenComparing(Comparator.comparing(PersonDto::getId)).reversed())
                    .collect(Collectors.toList());
            System.out.println("\n按照年龄排序、再按照id排序-最终倒序：\n"+resList);
        }

    }

    //最小min、最大max
    public static void method5(){
        if (list!=null && !list.isEmpty()){
            PersonDto p=list.stream()
                    .min(Comparator.comparingInt(PersonDto::getId))
                    .get();
            System.out.println("\nid最小："+p);
        }

        if (list!=null && !list.isEmpty()){
            PersonDto p=list.stream()
                    .max(Comparator.comparingInt(PersonDto::getAge))
                    .get();
            System.out.println("\n年龄最大："+p);
        }
    }


    //测试
    @Data
    public class Entity implements Serializable{
        private Integer id;
        private String tag2;
    }

    public void method6() throws Exception{
        String str="[{\"id\": 55, \"tag2\": \"创业\"}, {\"id\": 60, \"tag2\": \"新上架\"}, {\"id\": 9, \"tag2\": \"社会学\"}, {\"id\": 12, \"tag2\": \"外国文学\"}, {\"id\": 14, \"tag2\": \"诗歌词曲\"}, {\"id\": 16, \"tag2\": \"纪实\"}, {\"id\": 45, \"tag2\": \"个人成长\"}, {\"id\": 46, \"tag2\": \"管理艺术\"}, {\"id\": 19, \"tag2\": \"英文原版\"}, {\"id\": 20, \"tag2\": \"精选绘本\"}, {\"id\": 58, \"tag2\": \"牛友推荐\"}, {\"id\": 28, \"tag2\": \"艺术\"}, {\"id\": 50, \"tag2\": \"名人励志\"}, {\"id\": 44, \"tag2\": \"推理悬疑\"}, {\"id\": 32, \"tag2\": \"绘画\"}]";
        List<Map<String,Object>> list=new ObjectMapper().readValue(str,List.class);
        //System.out.println(list);

        /*List<Entity> arr=Lists.newLinkedList();
        Entity entity;
        for (Map<String,Object> map:list){
            entity=new Entity();
            entity.setId(Integer.valueOf(map.get("id").toString()));
            entity.setTag2(map.get("tag2").toString());
            arr.add(entity);

        }
        System.out.println(arr);*/

        List<Object> ids=Lists.newLinkedList();
        list.stream().forEach(map -> ids.add(map.get("id")));
        System.out.println(ids);
    }


    public static void main(String[] args) throws Exception{
        System.out.println("--java8 stream api强大的操作--");

        //method1();
        //method2();
        //method3();
        //method4();
        //method5();

        new Java8Util().method6();

        /*Logger log= LoggerFactory.getLogger(Java8Util.class);
        Object str="1a";
        try {
            Integer num= (Integer) str;

        }catch (Exception e){
            e.printStackTrace();
            log.error("--结果：{}--",str,e.fillInStackTrace());
        }*/


    }

}





































