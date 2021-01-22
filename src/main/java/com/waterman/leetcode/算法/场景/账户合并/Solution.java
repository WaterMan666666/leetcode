package com.waterman.leetcode.算法.场景.账户合并;

import com.waterman.leetcode.算法.并查集.UnionFind;

import java.util.*;

/**
 * @author tongdong
 * @Date: 2020/6/2
 * @Description:
 *  
 * 721. 账户合并
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 *
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 *
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。

 */
public class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, String> account_name = new HashMap<>();
        Map<String, Integer> account_index = new HashMap<>();
        Integer index = 0;
        for(List<String> account : accounts){
            String name = account.get(0);
            for(int i = 1 ; i < account.size(); i ++){
                String email = account.get(i);
                if (!account_index.containsKey(email)) {
                    account_name.put(email, name);
                    account_index.put(email, index++);
                }
            }
        }
        UnionFind unionFind = new UnionFind(account_index.size());
        //构建并查集
        for(List<String> account : accounts){
            String firest = account.get(1);
            for(int i = 2 ; i < account.size(); i ++){
                unionFind.union(account_index.get(firest), account_index.get(account.get(i)));
            }
        }
        Map<Integer, List<String>> index_account = new HashMap<>();
        for (String email : account_index.keySet()) {
            int idx = unionFind.find(account_index.get(email));
            List<String> account = index_account.getOrDefault(idx, new ArrayList<>());
            account.add(email);
            index_account.put(idx, account);
        }
        List<List<String>> merged = new ArrayList<>();
        for (List<String> emails : index_account.values()) {
            Collections.sort(emails);
            String name = account_name.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;



    }


}

