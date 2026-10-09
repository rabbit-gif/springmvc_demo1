package com.experiment.mybatisdemo.mapper;

import com.experiment.mybatisdemo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE user_id = #{userId}")
    User findById(Long userId);

    @Select("SELECT * FROM users")
    List<User> findAll();

    @Insert("INSERT INTO users(user_name, password, email, birth_date) VALUES(#{userName}, #{password}, #{email}, #{birthDate})")
    int insert(User user);

    @Update("UPDATE users SET user_name=#{userName}, email=#{email} WHERE user_id=#{userId}")
    int update(User user);

    @Delete("DELETE FROM users WHERE user_id=#{userId}")
    int delete(Long userId);
}
