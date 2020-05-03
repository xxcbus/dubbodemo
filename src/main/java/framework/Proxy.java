package framework;

import register.RemoteRegister;

/**
 * @author LGS
 * @className framework.Proxy.java
 * @createTime 2019/8/22 15:28
 */
public class Proxy {

    public static <T> T getProxy(Class<T> interfaceClass){
        return (T) java.lang.reflect.Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class[]{interfaceClass},
                (proxy, method, args) -> {
                    Protocal client= ProtocalFactory.getProtocal();
                    Invocation invocation = new Invocation(interfaceClass.getName(),
                            method.getName(),
                            method.getParameterTypes(),
                            args);
                    URL url = RemoteRegister.getRandom(interfaceClass.getName());
                    String result = client.send(url,invocation);
                    return result;
                });
    }
}
