package com.medibidz.dao;

import java.util.List;

import com.medibidz.entity.Registeration;
import com.medibidz.entity.User;
import com.medibidz.entity.Wish;

public interface UserDao 
{
public List<Wish> getNewWishList();
public void addWishList(int uid,String wish);
public List<User> getAllUsers();
public void register(Registeration reg);
public List<Registeration> getNewRegisterations();
public Registeration getNewRegisteration(int regId);
public void verify(int registerationId);
public void delete(int registerationId);
public void updateUserStatus(int userId,int status);
public void deleteUser(int userId);
public User findById(int id);
public User validateLogin(String loginId,String password);
public User getProfileDetails(String loginId,String password);
public String getUserName(String email,String password);
public void editProfile(User user,int userId);
public User getUserDetails(int userId);
}
