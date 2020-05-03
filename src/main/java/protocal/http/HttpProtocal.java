package protocal.http;

import framework.Invocation;
import framework.Protocal;
import framework.URL;

public class HttpProtocal implements Protocal {
    @Override
    public void start(URL url) {
        new HttpServer().start(url.getHostname(),url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        return new HttpClient().send(url.getHostname(),url.getPort(),invocation);
    }
}
