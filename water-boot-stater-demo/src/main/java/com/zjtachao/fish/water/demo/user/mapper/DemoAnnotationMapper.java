/**************************************************************************
 * Copyright (c) 2016-2017 Zhejiang TaChao Network Technology Co.,Ltd.
 * All rights reserved.
 *
 * 项目名称：浙江踏潮-基础架构
 * 版权说明：本软件属浙江踏潮网络科技有限公司所有，在未获得浙江踏潮网络科技有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.zjtachao.fish.water.demo.user.mapper;

import com.zjtachao.fish.water.demo.user.bean.DemoUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 测试接口
 *
 * @author <a href="mailto:dh@zjtachao.com">duhao</a>
 * @since 2.0
 */
@Mapper
public interface DemoAnnotationMapper {

    /**
     * 查询单条数据
     * @param id
     * @return
     */
    @Select("SELECT * FROM demo_user t WHERE 1=1 AND t.id = #{id}")
    @Results({@Result(property = "id" , column = "ID") ,
            @Result(property = "userCode" , column = "USER_CODE") ,
            @Result(property = "userNickName" , column = "USER_NICKNAME") ,
            @Result(property = "userAge" , column = "USER_AGE") ,
            @Result(property = "loginTime" , column = "LOGIN_TIME") ,
            @Result(property = "createTime" , column = "CREATE_TIME") ,
            @Result(property = "createId" , column = "CREATE_ID") ,
            @Result(property = "modifyTime" , column = "MODIFY_TIME") ,
            @Result(property = "modifyId" , column = "MODIFY_ID") ,
            @Result(property = "deleteFlag" , column = "DELETE_FLAG")})
    public DemoUser findById(@Param("id") Long id);

    /**
     * 查询列表数据
     * @return
     */
    @Select("SELECT * FROM demo_user t WHERE 1=1 ")
    @Results({@Result(property = "id" , column = "ID") ,
            @Result(property = "userCode" , column = "USER_CODE") ,
            @Result(property = "userNickName" , column = "USER_NICKNAME") ,
            @Result(property = "userAge" , column = "USER_AGE") ,
            @Result(property = "loginTime" , column = "LOGIN_TIME") ,
            @Result(property = "createTime" , column = "CREATE_TIME") ,
            @Result(property = "createId" , column = "CREATE_ID") ,
            @Result(property = "modifyTime" , column = "MODIFY_TIME") ,
            @Result(property = "modifyId" , column = "MODIFY_ID") ,
            @Result(property = "deleteFlag" , column = "DELETE_FLAG")})
    public List<DemoUser> findAll();


    /**
     * 新增数据
     * @param demoUser
     */
    @Insert("INSERT INTO demo_user(USER_CODE , USER_NICKNAME , USER_AGE , LOGIN_TIME , CREATE_TIME  , MODIFY_TIME , DELETE_FLAG) " +
            "VALUES(#{userCode} , #{userNickName} , #{userAge} , #{loginTime} , #{createTime} , #{modifyTime} , #{deleteFlag})")
    public void insertUser(DemoUser demoUser);


    /**
     * 修改数据
     * @param demoUser
     */
    @Update("UPDATE demo_user SET USER_NICKNAME = #{userNickName} ,  MODIFY_TIME = #{modifyTime} WHERE 1=1 AND id = #{id} ")
    public void updateUserById(DemoUser demoUser);

    /**
     * 删除数据
     * @param id
     */
    @Delete("DELETE FROM demo_user WHERE id = #{id}")
    public void deleteUserById(@Param("id")Long id);

}
