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
public interface DemoXmlMapper {

    /**
     * 查询单条数据
     * @param id
     * @return
     */
    public DemoUser findById(Long id);

    /**
     * 查询列表数据
     * @return
     */
    public List<DemoUser> findAll();


    /**
     * 新增数据
     * @param demoUser
     */
     public void insertUser(DemoUser demoUser);


    /**
     * 修改数据
     * @param demoUser
     */
    public void updateUserById(DemoUser demoUser);

    /**
     * 删除数据
     * @param id
     */
    public void deleteUserById(Long id);

}
