package com.xfz.netty.protobuftest;

import com.xfz.netty.protobuf.MyDataInfo;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @describe
 * @Author: xfz
 * @Date: 2019/3/25 17:24
 */
public class TestServerHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MyDataInfo.Person person) throws Exception {
        System.out.println(person.getName());
        System.out.println(person.getAddress());
        System.out.println(person.getAge());;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.Person2 build = MyDataInfo.Person2.newBuilder().setName("娟娟").setAddress("深圳").setAge(22).build();
        ctx.channel().writeAndFlush(build);
        System.out.println("服务端发送");
    }
}
