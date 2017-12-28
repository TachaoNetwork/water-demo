package com.zjtachao.fish.water.demo.user.controller;

import com.zjtachao.fish.water.common.base.bean.WaterBootResultBean;
import com.zjtachao.fish.water.common.base.context.WaterBootResultContext;
import com.zjtachao.fish.water.common.base.controller.WaterBootBaseController;
import com.zjtachao.fish.water.common.data.WaterRedis;
import com.zjtachao.fish.water.demo.user.bean.DemoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/test/redis")
public class DemoTestRedisController extends WaterBootBaseController{


    /**
     * 测试redis
     * @param name
     * @return
     */
    @GET
    @Path("/hello/{name}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public WaterBootResultBean<String> hello(@PathParam("name") String name){
        WaterBootResultBean<String> result = new WaterBootResultBean<String>();
        try{
            String val = waterEnv.getProperty("server.port");
            logger.info(val);
            waterRedis.set("aaa",name,20);
            result.setRst("success");
        } catch (Exception e){
            logger.error(e.getMessage() , e);
            result.setCode(WaterBootResultContext.ResultCode.ERROR.getCode());
            result.setMsg("服务器出错");
        }
        return result;
    }

    /**
     * 测试redis
     * @param count
     * @return
     */
    @GET
    @Path("/logs/{count}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public WaterBootResultBean<String> logs(@PathParam("count") Integer count){
        WaterBootResultBean<String> result = new WaterBootResultBean<String>();
        try{
            for(int i=0;i<count;i++){
                logger.warn("测试日志："+ i);
            }
            result.setRst("success");
        } catch (Exception e){
            logger.error(e.getMessage() , e);
            result.setCode(WaterBootResultContext.ResultCode.ERROR.getCode());
            result.setMsg("服务器出错");
        }
        return result;
    }



}
