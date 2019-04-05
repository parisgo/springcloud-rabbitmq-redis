package org.paris8.sctestapp.mapper;
import org.apache.ibatis.annotations.*;
import org.paris8.sctestapp.model.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user(id, name,age) VALUES(#{id},#{name},#{age})")
    public void add(User user);

    @Update("UPDATE user SET name=#{name},age=#{age} WHERE id=#{id}")
    public void update(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    public void delete(Long id);

    @Select("SELECT * FROM user WHERE id=#{id}")
    public User getById(Long id);

    @Select("SELECT * FROM user")
    public List<User> getAll();
}
