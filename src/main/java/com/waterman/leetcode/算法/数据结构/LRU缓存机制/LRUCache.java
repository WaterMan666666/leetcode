package com.waterman.leetcode.算法.数据结构.LRU缓存机制;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author tongdong
 * @Date: 2020/5/25
 * @Description:
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *  
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *  
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 );
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // 返回  1
        *cache.put(3,3);    // 该操作会使得密钥 2 作废
        *cache.get(2);       // 返回 -1 (未找到)
        *cache.put(4,4);    // 该操作会使得密钥 1 作废
        *cache.get(1);       // 返回 -1 (未找到)
        *cache.get(3);       // 返回  3
        *cache.get(4);       // 返回  4

 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(2,2);
        System.out.println(cache.get(2));
        cache.put(1,1);
        cache.put(4,1);
        System.out.println(cache.get(2));
        new LinkedHashMap(6,0.75F, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 6;
            }
        };
    }


    private int capacity;
    private int count = 0;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);

    }

    public int get(int key) {
        Node node = map.get(key);
        if(node != null){
            moveAndInsertHead(node);
        }
        return node == null ? -1 : node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null){
            node = new Node(key, value);
            if(count >= capacity) {
                removeTail();
            }else{
                count++;
            }
        }else {
            node.val = value;
        }
        map.put(key,node);
        //存在则将该节点移动至队头
        moveAndInsertHead(node);
        if(tail == null){
            tail = node;
        }
    }

    /**
     * 将指定节点移动至 newPre前
     */
    private void moveAndInsertHead(Node target){
        if(head == target){
            return;
        }
        //将节点删除
        Node pre = target.pre;
        Node next = target.next;
        if(pre != null){
            pre.next = next;
            target.pre = null;
        }
        if(next != null){
            next.pre = pre;
            target.next = null;
        }
        //将节点插入到头
        if(target == tail){
            tail = pre;
        }
        if(head != null){
            head.pre = target;
            target.next = head;
            head = head.pre;
        }else{
            head = target;
            tail = target;
        }
    }
    /**
     * 删除尾巴节点
     */
    private void removeTail(){
        Node pre = tail.pre;
        if(pre != null){
            pre.next = null;
        }
        map.remove(tail.key);
        tail = pre;
    }

    class Node {
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int key;
        public int val;
        public Node pre;
        public Node next;
    }

}
