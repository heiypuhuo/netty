package com.xfz.netty.protobuftest;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @describe
 * @Author: xfz
 * @Date: 2019/3/25 17:31
 */
public class TestClient {
    public static void main(String[] args)throws Exception {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class)
                    .handler(new TestClientinitalizer());
            Channel localhost = bootstrap.connect("localhost", 8080).sync().channel();
            localhost.closeFuture().sync();
        }finally {
            eventExecutors.shutdownGracefully();
        }

    }
}
