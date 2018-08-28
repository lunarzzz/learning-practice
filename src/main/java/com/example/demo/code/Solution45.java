package com.example.demo.code;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-28 17:41
 **/
public class Solution45 {
    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     *
     * 示例:
     *
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     */
//    public int jump(int[] nums) {
//        int len = nums.length;
//        int count[] = new int[len];
//        if (nums[0] >= len-1){
//            return 1;
//        }
//        for (int i = 0; i < len-1; i++) {
//            count[i] = len;
//        }
//        for (int i = len-2; i >= 0; i--) {
//            int temp = len;
//            if (nums[i] >= len-i-1){
//                count[i] = 1;
//                continue;
//            }
//            for (int j = i+1; j <= i + nums[i] && j<len; j++) {
//                if (count[j] < temp){
//                    temp = count[j];
//                }
//            }
//            count[i] = temp + 1;
//        }
//        return count[0];
//    }

    public int jump2(int[] nums) {
        int len = nums.length;

        // 贪心算法
        // 最有子结构 贪心选择性质
        // 不要去关注跳那个位置
        // 如果你调到此位置能都跳到更远，那你就跳
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 當前能跳最远的位置
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                // 当前位置
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    @Test
    public void test(){
        int jump = jump2(new int[]{2, 3, 1, 1, 4});
        Assert.assertEquals(2, jump);
    }
    @Test
    public void test_2(){
        int jump = jump2(new int[]{2, 3});
        Assert.assertEquals(1, jump);
    }
    @Test
    public void test_3(){
        int jump = jump2(new int[]{2});
        Assert.assertEquals(0, jump);
    }

    @Test
    public void test_4(){
        int jump = jump2(new int[]{2,3,0,1,4});
        Assert.assertEquals(2, jump);
    }


}
