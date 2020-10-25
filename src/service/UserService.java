package service;

import entity.User;

import java.util.List;

public interface UserService {
    User find ();
   List findAll();
    int  add();
    int update();
    int upadteadmin();
    int deleteadmin();
    int deletepersonid();//通过员工身份证号删除
    int deleteacount();//通过员工账号删除
    User findid();//通过员工编号查询
    User findpersonid();//通过身份证查询

}
