package com.ashin.service.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {
    /**
     * 暴力法
     * @param nums
     * @return
     * 时间复杂度 O（n的三次）
     */

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
            for(int i=0;i<nums.length;i++)
                for(int j=i+1;j<nums.length;j++)
                    for(int k=j+1;k<nums.length;k++)
                    {
                        if(nums[i]+nums[k]+nums[j]==0)
                        {

                            list.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                        }
                    }
            return list;

    }

    public static void main(String[] args) {

        System.out.println(threeSum1(new int[]{-1, 0, 1, 2, -1, -4}).toString());
    }
}
