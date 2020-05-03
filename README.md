# rpcStudy
简易的rpc架构原理实现，搭建一个简单的duboo框架
# **使用技术**
netty，java反射，动态代理，简单工厂模式，synchronized，wait()，notify()，HashMap，
自定义线程池ThreadPoolExecutor

# 支持协议
dubbo，http，默认为dubbo

# 目录说明
provider：生产者，以main方法启动，默认启动的协议是dubbo，
           可在启动时加上vm options参数来修改协议为http： -DprotocalName=http（也可以换成-DprotocalName=dubbo，用的是dubbo协议）
           
consumer：消费者，以main方法启动，默认启动的协议是dubbo，
          可在启动时加上vm options参数来修改协议为http： -DprotocalName=http（也可以换成-DprotocalName=dubbo，用的是dubbo协议）

framework：获取动态代理类，及封装url，要调用的Invocation

protocal：协议的实现，有两种dubbo，http

register：注册中心，有本地注册和远程注册，项目中用HashMap模拟