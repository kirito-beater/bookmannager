package Dao;

import entity.Book;

import java.util.List;

public interface BookDao {
    int add(int bid,String bname,double price,int cid,String storetime);//上架
    int updateprice(double price,int bid);//根据书号修改价格
    int updatecate(int cid,int bid);//根据书号修改分类
    int delete(int bid);//下架
    Book find(int bid);//根据书号查书
    List<Book> findall();//查询所有书

}
