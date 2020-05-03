package protocal.dubbo;

import framework.Invocation;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * @author tanghf
 * @className protocal.dubbo.NettyClientHandler.java
 * @createTime 2019/8/23 10:22
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private Invocation invocation;
    ChannelHandlerContext ctx;

    private String result;

    public Invocation getInvocation() {
        return invocation;
    }

    public void setInvocation(Invocation invocation) {
        this.invocation = invocation;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }


    /**
     * 收到服务端数据，唤醒等待线程
     */
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) {
        result = msg.toString();
        notify();
    }

    /**
     * 写出数据，开始等待唤醒
     */
    @Override
    public synchronized Object call() throws InterruptedException {
        ctx.writeAndFlush(invocation);
        wait();
        return result;
    }
}
