package com.ashin.service.algorithm;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Set;

/**
 * 给定一些字符串单词wordList，然后分别查找出这些字符串单词在给定的“文本串”中出现的次数。
 * 比如给定的“文本串”内容words为：
 *
 * debug认为jvm虚拟机在进行优化，第一时间想到应该都是配置堆内存的大小，
 * 其次就是java垃圾收集器了。java垃圾收集器的配置对于jvm优化来说是一个很重要的选择，
 * 选择合适的垃圾收集器可以让jvm的性能有一个很大的提升。截止Jdk 1.8，一共有7款不同的垃圾收集器。
 * 每一款不同的垃圾收集器都有不同的特点，在具体使用的时候，需debug要根据具体的情况选用不同的垃圾收集器debug
 *
 * 同时给定的待查找的字符串单词列表为：jvm,垃圾,debug,java
 *
 * 则每个字符串单词出现的次数分别为：jvm=3，垃圾=6，debug=3，java=2
 */
public class CharacterOperation {
    private static final String str="debug认为jvm虚拟机在进行优化，第一时间想到应该都是配置堆内存的大小，其次就是java垃圾收集器了。java垃圾收集器的配置对于jvm优化来说是一个很重要的选择，选择合适的垃圾收集器可以让jvm的性能有一个很大的提升。截止Jdk 1.8，一共有7款不同的垃圾收集器。每一款不同的垃圾收集器都有不同的特点，在具体使用的时候，需debug要根据具体的情况选用不同的垃圾收集器debug";
    private static final Set<String> set= Sets.newHashSet("jvm","垃圾","debug","java","mysql");

    public static Map<String,Integer> method1()
    {
        Map<String,Integer>map= Maps.newHashMap();
        set.parallelStream().forEach(s -> map.put(s,0));
        set.parallelStream().forEach(s -> {
            String tempStr=str.intern();
            Integer total=0;

            while (StringUtils.isNotBlank(tempStr) && tempStr.contains(s)){
                total += 1;
                tempStr=tempStr.substring(tempStr.indexOf(s)+s.length());
            }
            map.put(s,total);
        });

    return map;
    }

    public static void main(String[] args) {
        System.out.println(method1());
    }
}
