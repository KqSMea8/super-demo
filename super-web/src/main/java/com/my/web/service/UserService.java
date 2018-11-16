package com.my.web.service;


import com.my.web.bo.User;
import com.my.web.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lilianga on 2018/11/13.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;


    @Override
    public boolean addUser(User user) {
        boolean flag=false;
        try{
            userDao.addUser(user);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateUser(User user) {
        boolean flag=false;
        try{
            userDao.updateUser(user);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean flag=false;
        try{
            userDao.deleteUser(id);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public User findUserByName(String userName) {
        return userDao.findByName(userName);
    }

    @Override
    public User findUserById(int userId) {
        return userDao.findById(userId);
    }

    @Override
    public User findUserByAge(int userAge) {
        return userDao.findByAge(userAge);
    }
}
