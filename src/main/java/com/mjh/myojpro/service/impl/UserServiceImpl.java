package com.mjh.myojpro.service.impl;

import cn.hutool.Hutool;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.mjh.myojpro.enums.StatusCodeEnum;
import com.mjh.myojpro.exception.BusinessException;
import com.mjh.myojpro.model.pojo.User;
import com.mjh.myojpro.service.UserService;
import com.mjh.myojpro.mapper.UserMapper;
import com.mjh.myojpro.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.HashMap;
import java.util.List;


/**
* @author Ma Jiahui
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2025-03-10 17:03:36
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{


    @Override
    public boolean register(User user) {
        if(user==null||user.getUserName()==null||user.getUserName().equals("")||
                user.getPassword()==null||user.getPassword().equals("")){
            log.info("接收参数不全");
            throw new BusinessException(StatusCodeEnum.PARAMS_ERROR,"参数错误");
        }
        //检查是否参数是否合法
        if(user.getUserName().length()<=0||user.getUserName().length()>20||user.getPassword().length()<=0||user.getPassword().length()>=20||user.getPassword().length()>10){
            log.info("参数格式不正确，请按照要求填写");
            throw new BusinessException(StatusCodeEnum.PARAMS_ERROR,"参数格式不正确，请按照要求填写");
        }
        List<User> list = this.baseMapper.selectList(new QueryWrapper<User>().eq("user_name", user.getUserName()));
        if(list!=null&&list.size()>0){
            throw new BusinessException(StatusCodeEnum.PARAMS_ERROR,"当前用户已存在，请直接登录");
        }


        //将用户权限设置为启用
        user.setStatus(true);
        //将密码加密
        user.setPassword(DigestUtil.md5Hex(user.getPassword())) ;

        int insert = this.baseMapper.insert(user);
        System.out.println(insert);
        return true;
    }

    @Override
    public String login(User user) throws BusinessException ,RuntimeException{
        //逻辑
        /*
        拿到用户的信息，按照用户名查询是否存在这个用户，如果存在，再去比较密码是否一致，如果不一致，登录失败，一致则登录成功
         */
        if(user==null||user.getUserName()==null||user.getUserName().equals("")||user.getPassword()==null||user.getPassword().equals("")){
            log.info("接收参数不全");
            throw new BusinessException(StatusCodeEnum.PARAMS_ERROR,"参数错误");
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",user.getUserName());
        User selectedUser = this.baseMapper.selectOne(queryWrapper);
        if(selectedUser==null){
            log.info("当前用户不存在");
            throw new BusinessException(StatusCodeEnum.PARAMS_ERROR,"当前用户不存在,请您注册账号");
        }
        if(!DigestUtil.md5Hex(user.getPassword()).equals(selectedUser.getPassword())){
            log.info("当前用户存在，但是密码不正确");
            throw new BusinessException(StatusCodeEnum.PARAMS_ERROR,"当前用户存在，但是密码错误");
        }
        log.info(selectedUser.getUserName()+"登录成功");
        HashMap<String,String> claims = new HashMap<>();
        claims.put("userId",selectedUser.getUserId().toString());
        claims.put("userName",selectedUser.getUserName());
        String token = JWTUtils.getToken(claims);
        return token;
    }
}




