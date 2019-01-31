package com.fish.consumer.irule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 自定义负载均衡算法
 * @Author: 周大伟
 * @Date: 2019/1/31 17:10
 */
public class CustomRule implements IRule {

    private ILoadBalancer lb;

    // 要排除的提供者端口号集合
    private List<Integer> excludePorts;

    public CustomRule() {
    }

    public CustomRule(List<Integer> excludePorts) {
        this.excludePorts = excludePorts;
    }

    @Override
    public Server choose(Object o) {
        // 获取所有可用的提供者
        List<Server> servers = lb.getReachableServers();

        List<Server> availableServers = this.getAvailableServers(servers);

        return this.getAvailableRandomServers(availableServers);
    }

    // 获取所有排除了指定端口号的提供者
    private List<Server> getAvailableServers(List<Server> servers) {
        //若不存在要排除的server,则直接将所有的可用的server返回
        if(excludePorts == null || excludePorts.size() == 0){
            return servers;
        }
        // 定义一个集合，用于存放排除了指定端口号的Server
        List<Server> aserves = new ArrayList<>();
        for (Server server : servers) {
            boolean flag = true;
            for (Integer port : excludePorts) {
                if (server.getPort() == port){
                    flag = false;
                    break;
                }
            }
            //若flag为flase,说明上面的for循环执行了break，说明当前遍历的server是要排除的的server
            if (flag){
                aserves.add(server);
            }

        }
        return aserves;
    }

    // 从剩余的提供者中随机获取可用的提供者
    private Server getAvailableRandomServers(List<Server> availableServers) {
        //获取一个[0,availableServers.size())的随机整数
        int index = new Random().nextInt(availableServers.size());
        return availableServers.get(index);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.lb = iLoadBalancer;
    }


    @Override
    public ILoadBalancer getLoadBalancer() {
        return lb;
    }
}
