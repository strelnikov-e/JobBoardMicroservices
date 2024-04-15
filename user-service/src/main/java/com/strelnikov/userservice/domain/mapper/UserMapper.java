package com.strelnikov.userservice.domain.mapper;

import com.strelnikov.userservice.domain.dto.UserDto;
import com.strelnikov.userservice.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toUserDto(User user);

    User toUser(UserDto authorDto);
}
