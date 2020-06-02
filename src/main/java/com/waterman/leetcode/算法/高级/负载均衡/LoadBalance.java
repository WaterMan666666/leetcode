package com.waterman.leetcode.算法.高级.负载均衡;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author tongdong
 * @Date: 2020/5/21
 * @Description: 负载均衡类
 */
public class LoadBalance {

    private final List<IpAndWeight> list ;
    private final int weightAll ;
    private final int[] weightDynamic  ;

    public static void main(String[] args) {
        LoadBalance loadBalance = new LoadBalance(Arrays.asList(new IpAndWeight("192.168.9.0",50000000),
                new IpAndWeight("192.168.9.1",10),
                new IpAndWeight("192.168.9.2",10)));
        for (int i = 0; i < 7; i++) {
            System.out.println(loadBalance.roundRobin());
        }
    }



    public LoadBalance(List<IpAndWeight> list){
        this.list = new ArrayList<>(list);
        weightAll = list.stream().map(item -> item.weight).reduce((w1, w2) -> w1 + w2).orElse(0);
        weightDynamic = new int[list.size()];
    }

    /**
     * @Description: 随机获取
     * @Author tongdong
     * @Date  2020/5/22
     */
    public String random(){
        int randomInt = ThreadLocalRandom.current().nextInt(weightAll);
        if(list != null){
            for (int i = 0; i < list.size(); i++) {
                IpAndWeight ipAndWeight = list.get(i);
                if(randomInt > ipAndWeight.weight){
                    randomInt -= ipAndWeight.weight;
                }else {
                    return ipAndWeight.ip;
                }
            }
        }
        return null;
    }

    /**
     * @Description: 平滑加权轮询
     * @Author tongdong
     */
    public String roundRobin(){
//        weightDynamic
        //加入所有权重取最大
        IpAndWeight maxIp = list.get(0);
        for (int i = 0; i < weightDynamic.length; i++) {
            weightDynamic[i] += list.get(i).weight;
        }
        int max = 0;
        for (int i = 1; i < weightDynamic.length; i++) {
           if(weightDynamic[max] < weightDynamic[i]){
               max = i;
               maxIp = list.get(i);
           }
        }
        weightDynamic[max] -= weightAll;
        return maxIp.ip;
    }

    /**最少活跃调用数*/
    /**一致性哈希负载均衡*/
}
