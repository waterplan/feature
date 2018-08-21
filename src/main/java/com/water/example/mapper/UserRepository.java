package com.water.example.mapper;

import com.water.example.donain.User;
import org.apache.ibatis.annotations.Param;

public interface UserRepository {

    User findUserById(@Param("id") Long id);
}
