package com.xfz.netty.simpleness;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @describe
 * @Author: xfz
 * @Date: 2019/3/23 15:56
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject httpObject) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
         if (httpObject instanceof HttpRequest){
            ByteBuf byteBuf = Unpooled.copiedBuffer("hello World", CharsetUtil.UTF_8);
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
            response.headers().set(HttpHeaderNames.CONNECTION, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LANGUAGE, byteBuf.readableBytes());
            ctx.channel().writeAndFlush(response);
            ctx.channel().close();
        }
    }
}
