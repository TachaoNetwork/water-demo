package com.zjtachao.fish.water.demo.user.controller;

import com.alibaba.fastjson.JSON;
import com.zjtachao.fish.water.common.base.bean.WaterBootResultBean;
import com.zjtachao.fish.water.common.base.context.WaterBootResultContext;
import com.zjtachao.fish.water.common.base.controller.WaterBootBaseController;
import com.zjtachao.fish.water.demo.user.bean.DemoUser;
import com.zjtachao.fish.water.demo.user.mapper.DemoXmlMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

@Path("/test/xml")
public class DemoTestXmlController extends WaterBootBaseController{



    @Autowired
    private DemoXmlMapper demoXmlMapper;

    /**
     * 查询所有
     * @return
     */
    @GET
    @Path("/queryall")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public WaterBootResultBean<DemoUser> queryAll(){
        WaterBootResultBean<DemoUser> result = new WaterBootResultBean<DemoUser>();
        try{
            List<DemoUser> list = demoXmlMapper.findAll();
            result.setCode(WaterBootResultContext.ResultCode.SUCCESS.getCode());
            result.setRst(list);
        }catch (Exception e){
            logger.error(e.getMessage() , e);
            result.setCode(WaterBootResultContext.ResultCode.ERROR.getCode());
            result.setMsg("服务器出错");
        }
        return result;
    }


    /**
     * 查询单条
     * @param id
     * @return
     */
    @GET
    @Path("/queryid/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public WaterBootResultBean<DemoUser>  queryById(@PathParam("id") Long id){
        WaterBootResultBean<DemoUser> result = new WaterBootResultBean<DemoUser>();
        try{
            DemoUser user = demoXmlMapper.findById(id);
            result.setCode(WaterBootResultContext.ResultCode.SUCCESS.getCode());
            result.setRst(user);
        }catch (Exception e){
            logger.error(e.getMessage() , e);
            result.setCode(WaterBootResultContext.ResultCode.ERROR.getCode());
            result.setMsg("服务器出错");
        }
        return result;
    }

    /**
     * 新增数据
     * @return
     */
    @Path("/save")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public WaterBootResultBean<DemoUser> save(String jsonStr){
        WaterBootResultBean<DemoUser> result = new WaterBootResultBean<DemoUser>();
        try{
            DemoUser user = JSON.parseObject(jsonStr , DemoUser.class);
            Date now = new Date();
            user.setLoginTime(now);
            user.setCreateTime(now);
            user.setModifyTime(now);
            demoXmlMapper.insertUser(user);
            result.setCode(WaterBootResultContext.ResultCode.SUCCESS.getCode());
            result.setMsg("success");
        }catch (Exception e){
            logger.error(e.getMessage() , e);
            result.setCode(WaterBootResultContext.ResultCode.ERROR.getCode());
            result.setMsg("服务器出错");
        }
        return result;
    }

    /**
     * 修改数据
     * @return
     */
    @Path("/update")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public WaterBootResultBean<DemoUser> update(String jsonStr){
        WaterBootResultBean<DemoUser> result = new WaterBootResultBean<DemoUser>();
        try{
            DemoUser user = JSON.parseObject(jsonStr , DemoUser.class);
            Date now = new Date();
            user.setModifyTime(now);
            demoXmlMapper.updateUserById(user);
            result.setCode(WaterBootResultContext.ResultCode.SUCCESS.getCode());
            result.setMsg("success");
        }catch (Exception e){
            logger.error(e.getMessage() , e);
            result.setCode(WaterBootResultContext.ResultCode.ERROR.getCode());
            result.setMsg("服务器出错");
        }
        return result;
    }

    /**
     * 删除数据
     * @return
     */
    @Path("/delete/{id}")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public WaterBootResultBean<DemoUser> delete(@PathParam("id") Long id){
        WaterBootResultBean<DemoUser> result = new WaterBootResultBean<DemoUser>();
        try{
            demoXmlMapper.deleteUserById(id);
            result.setCode(WaterBootResultContext.ResultCode.SUCCESS.getCode());
            result.setMsg("success");
        }catch (Exception e){
            logger.error(e.getMessage() , e);
            result.setCode(WaterBootResultContext.ResultCode.ERROR.getCode());
            result.setMsg("服务器出错");
        }
        return result;
    }

}
