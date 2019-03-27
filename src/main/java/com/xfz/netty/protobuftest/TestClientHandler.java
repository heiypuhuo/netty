package com.xfz.netty.protobuftest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @describe
 * @Author: xfz
 * @Date: 2019/3/25 17:48
 */
public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MyDataInfo.Person person) throws Exception {
        System.out.println(person.getName());
        System.out.println(person.getAddress());
        System.out.println(person.getAge());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("发送");
        MyDataInfo.Person build = MyDataInfo.Person.newBuilder().setName("照照").setAddress("深圳").setAge(22).build();
        ctx.channel().writeAndFlush(build);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        System.out.println("关闭");
        ctx.close();
    }
}
