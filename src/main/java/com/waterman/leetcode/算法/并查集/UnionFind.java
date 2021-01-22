package com.waterman.leetcode.算法.并查集;

import java.util.LinkedList;

/**
 * @author tongdong
 * @Date: 2021/1/18
 * @Description:
 */
public class UnionFind {

    int[] parent;

    public UnionFind(int size){
        parent = new int[size];
        for(int i = 0 ; i < size; i++ ){
            parent[i] = i;
        }
    }

    public void union(int i, int j){
        parent[find(i)] = find(j);
    }

    public int find(int i){
        if(parent[i] != i){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
}
