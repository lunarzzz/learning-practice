package com.example.demo.code;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-28 17:19
 **/
public class Solution55 {
    /**
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
     */
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int len = nums.length;
        int curr = nums[0];
        // 用于标志位置是否可以跳到终点，1 true ；0：false
        int flag[] = new int[len];
        flag[len-1] = 1;
        for (int i = len-2; i >= 0; i--) {
            for (int j = i; j <= i + nums[i]; j++) {
                if (flag[j] == 1){
                    flag[i] = 1;
                    break;
                }
            }
        }
        if (flag[0] == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int a[] = new int[]{0,1};
        boolean b = canJump(a);
        System.out.println(b);
    }
}
