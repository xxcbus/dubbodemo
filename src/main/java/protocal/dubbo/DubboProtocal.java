package protocal.dubbo;

import framework.Invocation;
import framework.Protocal;
import framework.URL;

public class DubboProtocal implements Protocal {
    @Override
    public void start(URL url) {
        new NettyServer().start(url.getHostname(),url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        return new NettyClient<>().send(url.getHostname(),url.getPort(),invocation);
    }
}
