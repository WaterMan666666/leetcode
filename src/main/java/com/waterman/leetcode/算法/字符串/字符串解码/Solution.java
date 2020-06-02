package com.waterman.leetcode.算法.字符串.字符串解码;

/**
 * @author tongdong
 * @Date: 2020/5/28
 * @Description:
 *
 * 394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class Solution {

    public static void main(String[] args) {
        String str = "3[a]2[b4[F]c]";
        Solution solution = new Solution();
        System.out.println(solution.decodeString(str));
    }


    public String decodeString(String s) {
        if(s.length() == 0){
            return s;
        }
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        while(end <= chars.length){
            //数字
            if(Character.isDigit(chars[start])){
                //重复次数
                while(end < chars.length && Character.isDigit(chars[end])){
                    end++;
                }
                Integer count = Integer.valueOf(new String(chars, start, end - start));
                //获取值
                start = end;
                end = start + 1;
                int tempCount = 1;
                //此处应该记录中括号
                while(chars[end] != ']' || tempCount != 1){
                    if(chars[end] == '['){
                        tempCount++;
                    }else if(chars[end] == ']'){
                        tempCount--;
                    }
                    end++;
                }
                String string = new String(chars, start + 1, end - start - 1);
                String s1 = decodeString(string);
                for (int i = 0; i < count; i++) {
                    sb.append(s1);
                }
                //字母
            }else if(Character.isLetter(chars[start])){
                while(end < chars.length && Character.isLetter(chars[end]) ){
                    end++;
                }
                sb.append(chars, start, end - start);
            }
            start = end;
            end = start + 1;
        }

        return sb.toString();
    }
}
