package com.xkz.leetcode.solution.simple;

/**
 * 53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例 1:
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 示例 2:
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3:
 * 输入：nums = [0]
 * 输出：0
 *
 * 示例 4:
 * 输入：nums = [-1]
 * 输出：-1
 *
 * 示例 5:
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 */
public class Index53 {

    public static void main(String[] args) {
        System.out.println(searchInsert3(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public static int searchInsert1(int[] nums) {
        int cur_num = 0;
        int max_num = nums[0];
        for(int num : nums){
            cur_num = Math.max(num,cur_num+num);
            max_num = Math.max(cur_num,max_num);
        }
        return max_num;
    }

    /**
     * 暴力解法
     * @param nums
     * @return
     */
    public static int searchInsert2(int[] nums) {
       int min_num = Integer.MIN_VALUE;
       int size = nums.length;
       for (int i=0; i<size; i++){
           int sum = 0;
           for(int j=i; j<size; j++){
               sum += nums[j];
               if (sum > min_num){
                   min_num = sum;
               }
           }
       }
       return min_num;
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static int searchInsert3(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max_result = dp[0];
        for (int i=1; i<length; i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max_result = Math.max(max_result,dp[i]);
        }
        return max_result;
    }


    /**
     * 分治法，后期完成
     * @param nums
     * @return
     */
    public static int searchInsert4(int[] nums) {
        return 1;
    }


}
