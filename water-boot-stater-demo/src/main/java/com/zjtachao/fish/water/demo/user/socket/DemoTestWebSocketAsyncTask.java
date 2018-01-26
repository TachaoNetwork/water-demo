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
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 异步任务
 *
 * @author <a href="mailto:dh@zjtachao.com">duhao</a>
 * @since 2.0
 */
@Component
public class DemoTestWebSocketAsyncTask {

    /** 日志 **/
    public static final Logger logger = LoggerFactory.getLogger(DemoTestWebSocketAsyncTask.class);

    /**
     * 保持心跳
     */
    @Async
    public void heartBeat(){
        while (true){
            List<DemoTestWebSocket> list = DemoTestWebSocketMap.getAll();
            if(null != list && !list.isEmpty()){
                for(DemoTestWebSocket socket : list){
                    try{
                        if(null != socket){
                            socket.sendMessage("Heart Beat!");
                        }
                    }catch (Exception ex){
                        logger.error("发送心跳失败"+ex.getMessage() , ex);
                    }
                }
            }
            try{
                TimeUnit.SECONDS.sleep(30l);
            }catch (Exception ex){
                logger.error("休眠30秒错误" , ex);
            }
        }
    }

}
