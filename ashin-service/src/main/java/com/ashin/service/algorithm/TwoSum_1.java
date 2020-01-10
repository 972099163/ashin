package com.ashin.service.algorithm;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum_1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i]))
            {
                return new int[]{map.get(nums[i]),i};
            }else {
                map.put(target-nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 暴力法
     * @param nums
     * @param target
     * @return
     * 时间复杂度 O(n^2)
     */
    public static int[] twoSum1(int[] nums, int target) {
     for(int i=0;i<nums.length;i++)
         for(int j=i+1;j<nums.length;j++)
         {
             if(nums[i]+nums[j]==target)
             {
                 return new int[]{i,j};
             }
         }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        int []nums = new int[]{2, 7, 11, 15};
       System.out.println(twoSum1(nums,9).toString());
    }
}
