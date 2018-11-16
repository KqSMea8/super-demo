package com.my.web.dao;

import com.my.web.bo.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by lilianga on 2018/11/13.
 */
@Mapper
public interface IUserDao {

    /**
     * 用户数据新增
     */
    @Insert("insert into user(id,name,age) values (#{id},#{name},#{age})")
    void addUser(User user);

    /**
     * 用户数据修改
     */
    @Update("update user set name=#{name},age=#{age} where id=#{id}")
    void updateUser(User user);

    /**
     * 用户数据删除
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(int id);

    /**
     * 根据用户名称查询用户信息
     *
     */
    @Select("SELECT id,name,age FROM user where name=#{userName}")
    User findByName(@Param("userName") String userName);

    /**
     * 根据用户ID查询用户信息
     *
     */
    @Select("SELECT id,name,age FROM user where id=#{userId}")
    User findById(@Param("userId") int userId);


    /**
     * 根据用户age查询用户信息
     */
    @Select("SELECT id,name,age FROM user where age = #{userAge}")
    User findByAge(@Param("userAge") int userAge);
}
