package com.ashin.service.algorithm;

import com.google.common.collect.Sets;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *5 5 4
 * abkcdeacfrglopre
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring3 {

//abkcdeacfrglopre
    public static int lengthOfLongestSubstring2(String s)
    {

        int n=s.length();
        int i=0,j=0,max=0;

       Set chSet= Sets.newHashSet();
        while( i<n && j<n)
        {
            if(!chSet.contains(s.charAt(j)))
            {
                chSet.add(s.charAt(j++));
                max=Math.max(max,j-i);

            }else
            {
                chSet.remove(s.charAt(i++));
            }
        }
        return max;
    }
    /**
     * 暴力法
     * @param s
     * 时间复杂度：O(n^3)O(n
     * 3
     *  )
     * @param num
     * @return
     */

    public static int lengthOfLongestSubstring(String s) {
        StringBuffer sb=new StringBuffer(s);
        int max=0;
        for(int i=s.length();i>=1;i--)
        {
          // 根据i，返回 String s 的 String 数组
            //判断String是否有重复字符
          List<String>stringList=  getString(s,i);
            for (String s1 : stringList) {
                int result=getUniqueCharLength(s1);
                if(result>0)
                {
                    return result;
                }
            }
        }
        return 0;

    }



    private static  List<String> getString(String s, int num)
    {
        List<String> stringList=new ArrayList<>();
        for(int i=0;i<s.length()-num+1;i++)
        {
            stringList.add(s.substring(i,num+i));

        }
        return stringList;
    }

    private static int getUniqueCharLength(String s)
    {
        Set chSet=new TreeSet();
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            chSet.add(ch[i]);
        }
        return chSet.size()==ch.length?ch.length:0;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("bbbbb"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }
}
