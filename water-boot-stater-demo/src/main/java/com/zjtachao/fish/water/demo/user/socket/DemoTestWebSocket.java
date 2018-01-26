/**************************************************************************
 * Copyright (c) 2016-2017 Zhejiang TaChao Network Technology Co.,Ltd.
 * All rights reserved.
 *
 * 项目名称：浙江踏潮-基础架构
 * 版权说明：本软件属浙江踏潮网络科技有限公司所有，在未获得浙江踏潮网络科技有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.zjtachao.fish.water.demo.user.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * websocket服务
 *
 * @author <a href="mailto:dh@zjtachao.com">duhao</a>
 * @since 2.0
 */
@Controller
@ServerEndpoint(value = "/websocket")
public class DemoTestWebSocket {

    /** 日志 **/
    private static final Logger logger = LoggerFactory.getLogger(DemoTestWebSocket.class);

    /** 客户端会话 **/
    private Session session;


    /**
     * 新连接
     * @param session
     */
    @OnOpen
    public void onOpen(Session session){
        try{
            this.session = session;
            DemoTestWebSocketMap.add(session.getId() , this);
            logger.info("连接开启，id:"+session.getId());
        }catch (Exception ex){
            logger.error("连接出错" , ex);
        }
    }

    /**
     * 接收客户端消息
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message , Session session){
        try {
            logger.info("接收到消息："+message);
            this.sendMessage("request:"+message);
        }catch (Exception ex){
            logger.error("接收客户端消息" , ex);
        }
    }

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage(String message){
        try {
            this.session.getBasicRemote().sendText(message);
        }catch (Exception ex){
            logger.error("发送消息错误" , ex);
        }
    }

    /**
     * 关闭连接
     */
    @OnClose
    public void onClose(){
        try {
            DemoTestWebSocketMap.remove(session.getId());
            logger.info("连接关闭，id:"+session.getId());
        }catch (Exception ex){
            logger.error("关闭连接出错" , ex);
        }
    }


}
