package Dao;

import entity.User;

import java.util.List;

public interface UserDao {
        int update(String account);//修改密码
        User find( String user,String password);//三次登录
        List<User> findAll();//查找所有图书馆管理员
        int add(String account, String password, String realname, String personid, String tell, String address);//添加图书馆理员
        int updateadmin(String account, String password, String realname, String personid, String tell, String address,int id);
        int deleteadmin(int id);//通过员工编号删除
        int deletepersonid(String personid);//通过员工身份证号删除
        int deleteacount(String account);//通过员工账号删除
        User findid(int uid);//通过员工编号查询
        User findpersonid(String personid);//通过身份证查询
}

