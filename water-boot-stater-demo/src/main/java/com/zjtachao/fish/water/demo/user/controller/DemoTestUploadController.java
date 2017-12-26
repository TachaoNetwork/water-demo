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
import com.zjtachao.fish.water.common.tool.WaterUploadUtil;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

/**
 * 请在此处添加注释
 *
 * @author <a href="mailto:dh@zjtachao.com">duhao</a>
 * @since 2.0
 */
@Path("/test/upload")
public class DemoTestUploadController extends WaterBootBaseController {

    /**
     *
     * 文件上传
     * @param uploadedInputStream
     * @param fileDetail
     * @return
     */
    @POST
    @Path("/handler")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public WaterBootResultBean<String> uploadWaterFile(@FormDataParam("file") InputStream uploadedInputStream,
                                                       @FormDataParam("file") FormDataContentDisposition fileDetail){
        WaterBootResultBean<String> rest = new WaterBootResultBean<String>();
        try{
            //获取本地路径
            String localPath = "/demo/data/";
            String filePath = "";
            if((null != uploadedInputStream) && (null != fileDetail) && !fileDetail.getFileName().equals("")){
                String fileName = fileDetail.getFileName();

                // 上传图片之后的相对路径
                filePath = WaterUploadUtil.uploadImage(localPath, uploadedInputStream, fileName);
                String imgUrlPrefix = "http://127.0.0.1:8080/";
                String meterialPath = localPath + filePath;

                if(null != filePath){
                    rest.setCode(WaterBootResultContext.ResultCode.SUCCESS.getCode());
                    rest.setMsg("文件上传成功！");
                    meterialPath = imgUrlPrefix + filePath;
                    rest.setRst(meterialPath);
                }



            }else {
                rest.setMsg("传递的信息出错");
            }
        }catch(Exception ex){
            this.logger.error("服务器出错", ex);
            rest.setCode(WaterBootResultContext.ResultCode.ERROR.getCode());
            rest.setMsg("服务器出错");
        }
        return rest;
    }

}
