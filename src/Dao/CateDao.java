package Dao;

import entity.Cate;


import java.util.List;

public interface CateDao {
    int add(String cname);
    int update(String cname,int cid);
    int delete(int cid);
    List<Cate> findAll();
    Cate findcate(int cid);
}
