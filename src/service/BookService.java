package service;

import entity.Book;

import java.util.List;

public interface BookService {
    int add();//上架
    int updateprice();//根据书号修改价格
    int updatecate();//根据书号修改分类
    int delete();//下架
    Book find();//根据书号查书
    List<Book> findall();//查询所有书
}
