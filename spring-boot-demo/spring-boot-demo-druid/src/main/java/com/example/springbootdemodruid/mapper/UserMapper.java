package com.example.springbootdemodruid.mapper;

import com.example.springbootdemodruid.data.User;
import org.apache.ibatis.annotations.*;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserMapper
 * @Description: usermapper
 * @Author: zhangdi
 * @Date: 2020年04月23日 10:27
 **/
@Mapper
public interface UserMapper {

    @Select("SELECT USERID,USERNAME,PASSWORD,BIRTH FROM USER WHERE USERID=#{userId}")
    User findById(@Param("userId") String userId);

    @Insert("INSERT INTO USER(USERID, USERNAME,PASSWORD,BIRTH) VALUES(#{userId}, #{userName},#{password},#{birth})")
    int insert(User user);

    @Update("UPDATE user SET username=#{userName},password=#{password},birth=#{birth} WHERE userid=#{userid}")
    int update(User user);

    @Delete("DELETE FROM user WHERE userId =#{userId}")
    int delete(String userId);
}

