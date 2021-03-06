/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.redkale.test.http;

import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;
import java.util.function.BiConsumer;
import org.redkale.convert.json.*;
import org.redkale.net.http.*;

/**
 *
 * @author zhangjx
 */
public interface HttpResponseDesc {

    //增加Cookie值
    public HttpResponse addCookie(HttpCookie... cookies);

    //增加Cookie值
    public HttpResponse addCookie(Collection<HttpCookie> cookies);

    //设置状态码
    public void setStatus(int status);

    //获取状态码
    public int getStatus();

    //获取 ContentType
    public String getContentType();

    //设置 ContentType
    public HttpResponse setContentType(String contentType);

    //获取内容长度
    public long getContentLength();

    //设置内容长度
    public HttpResponse setContentLength(long contentLength);

    //设置Header值
    public HttpResponse setHeader(String name, Object value);

    //添加Header值
    public HttpResponse addHeader(String name, Object value);

    //添加Header值
    public HttpResponse addHeader(Map<String, ?> map);

    //跳过header的输出
    //通常应用场景是，调用者的输出内容里已经包含了HTTP的响应头信息，因此需要调用此方法避免重复输出HTTP响应头信息。
    public HttpResponse skipHeader();

    //异步输出指定内容
    public <A> void sendBody(ByteBuffer buffer, A attachment, CompletionHandler<Integer, A> handler);

    //关闭HTTP连接，如果是keep-alive则不强制关闭
    public void finish();

    //强制关闭HTTP连接
    public void finish(boolean kill);

    //将对象以JSON格式输出
    public void finishJson(Object obj);

    //将对象以JSON格式输出
    public void finishJson(JsonConvert convert, Object obj);

    //将对象以JSON格式输出
    public void finishJson(Type type, Object obj);

    //将对象以JSON格式输出
    public void finishJson(final JsonConvert convert, final Type type, final Object obj);

    //将对象以JSON格式输出
    public void finishJson(final Object... objs);

    //将RetResult对象以JSON格式输出
    public void finishJson(final org.redkale.service.RetResult ret);

    //将RetResult对象以JSON格式输出
    public void finishJson(final JsonConvert convert, final org.redkale.service.RetResult ret);

    //将对象以JavaScript格式输出
    public void finishJsResult(String var, Object result);

    //将对象以JavaScript格式输出
    public void finishJsResult(JsonConvert jsonConvert, String var, Object result);

    //将指定字符串以响应结果输出
    public void finish(String obj);

    //以指定响应码附带内容输出, message 可以为null
    public void finish(int status, String message);

    //以304状态码输出
    public void finish304();

    //以404状态码输出
    public void finish404();

    //将指定ByteBuffer按响应结果输出
    public void finish(ByteBuffer buffer);

    //将指定ByteBuffer按响应结果输出
    //kill   输出后是否强制关闭连接
    public void finish(boolean kill, ByteBuffer buffer);

    //将指定ByteBuffer数组按响应结果输出
    public void finish(ByteBuffer... buffers);

    //将指定ByteBuffer数组按响应结果输出
    //kill   输出后是否强制关闭连接
    public void finish(boolean kill, ByteBuffer... buffers);

    //将指定文件按响应结果输出
    public void finish(File file) throws IOException;

    //将文件按指定文件名输出
    public void finish(final String filename, File file) throws IOException;

    //HttpResponse回收时回调的监听方法
    public void setRecycleListener(BiConsumer<HttpRequest, HttpResponse> recycleListener);

}
