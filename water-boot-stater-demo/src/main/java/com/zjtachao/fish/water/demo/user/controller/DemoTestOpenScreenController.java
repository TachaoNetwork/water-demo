/**************************************************************************
 * Copyright (c) 2016-2017 Zhejiang TaChao Network Technology Co.,Ltd.
 * All rights reserved.
 *
 * 项目名称：浙江踏潮-基础架构
 * 版权说明：本软件属浙江踏潮网络科技有限公司所有，在未获得浙江踏潮网络科技有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.zjtachao.fish.water.demo.user.controller;

import com.zjtachao.fish.water.common.base.bean.WaterBootResultBean;
import com.zjtachao.fish.water.common.base.context.WaterBootResultContext;
import com.zjtachao.fish.water.common.base.controller.WaterBootBaseController;
import com.zjtachao.fish.water.demo.user.bean.DemoCountdown;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 请在此处添加注释
 *
 * @author <a href="mailto:dh@zjtachao.com">duhao</a>
 * @since 2.0
 */
@Path("/test/openscreen")
public class DemoTestOpenScreenController extends WaterBootBaseController {

    /**
     * 查询广告  iPhone 6s / iPhone 6 Plus / iPhone X
     * @return
     */
    @GET
    @Path("/countdown")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public WaterBootResultBean<DemoCountdown> queryAll(@HeaderParam("User-Agent")String userAgent){
        WaterBootResultBean<DemoCountdown> result = new WaterBootResultBean<DemoCountdown>();
        try{
            logger.info("ua:"+userAgent);
            DemoCountdown demoCountdown = new DemoCountdown();
            demoCountdown.setTime(3);
            if(userAgent.contains("iPhone X")){
                demoCountdown.setPath("https://www.zjtachao.com/fish_fw/img/ip.jpg");
            }else {
                demoCountdown.setPath("https://www.zjtachao.com/fish_fw/img/ipx.jpg");
            }
            result.setCode(WaterBootResultContext.ResultCode.SUCCESS.getCode());
            result.setRst(demoCountdown);
        }catch (Exception e){
            logger.error(e.getMessage() , e);
            result.setCode(WaterBootResultContext.ResultCode.ERROR.getCode());
            result.setMsg("服务器出错");
        }
        return result;
    }

}
