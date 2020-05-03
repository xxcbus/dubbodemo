package protocal.dubbo;

import framework.Invocation;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import register.LocalRegister;

import java.lang.reflect.Method;

/**
 * @author LGS
 * @className protocal.dubbo.NettyServerHandler.java
 * @createTime 2019/8/23 10:22
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Invocation invocation = (Invocation) msg;
        Class implClass = LocalRegister.get(invocation.getInterfaceName());
        Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
        String invoke = (String) method.invoke(implClass.newInstance(), invocation.getParams());
        System.out.println("Netty===============" + invoke);
        ctx.writeAndFlush("Netty: " + invoke);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
