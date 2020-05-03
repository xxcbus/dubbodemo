package framework;

/**
 * @author LGS
 */
public interface Protocal {
    void start(URL url);
    String send(URL url, Invocation invocation);
}
