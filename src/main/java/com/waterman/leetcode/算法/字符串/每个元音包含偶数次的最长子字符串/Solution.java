package com.waterman.leetcode.算法.字符串.每个元音包含偶数次的最长子字符串;

import java.util.Arrays;
import java.util.List;

/**
 * @author tongdong
 * @Date: 2020/5/20
 * @Description: 1371. 每个元音包含偶数次的最长子字符串
 *
 * 示例 1：
 *
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 * 示例 2：
 *
 * 输入：s = "leetcodeisgreat"
 * 输出：5
 * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 * 示例 3：
 *
 * 输入：s = "bcbcbc"
 * 输出：6
 * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 5 x 10^5
 * s 只包含小写英文字母。
 *
 *
 *
 */
public class Solution {

    final static List list = Arrays.asList('a','e' , 'i','o','u');

    public static void main(String[] args) {
//        String s = "eleetminicoworoep";
        String s = "llallllellelll";
        Solution solution = new Solution();
        System.out.println(solution.findTheLongestSubstring(s));
    }

    public int findTheLongestSubstring(String s) {
        int f[] = new int[26];
        f[4] = 1;
        f[8] = 2;
        f[14] = 3;
        f[20] = 4;
        int dp[] = new int[32];
        dp[0] = 1;
        char ss[] = s.toCharArray();
        int len = ss.length;
        int lst = 0;int r =0;int fk = -1;
        for(int i=0;i<len;++i){
            int c = ss[i]-'a';
            if(f[c]>0||c==0){
                if(fk!=i-1){
                    r = Math.max(i+1-dp[lst],r);
                }
                lst ^= 1 << f[c];
                if(dp[lst]!=0){
                    r = Math.max(i+2-dp[lst],r);
                    fk = i;
                }else{
                    dp[lst] = i+2;
                }
            }

        }
        if(dp[lst]!=0){
            r = Math.max(len+1-dp[lst],r);
        }
        return r;
    }


}
