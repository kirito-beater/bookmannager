package service;

import entity.Borrow;

import java.util.List;

public interface BorrowService {
    int addBorrow();

    //根据学号查询学生借阅记录
    void findBorrowBySid();

    //查询所有借阅记录
    void findAllBorrow();

    //根据学号删除学生借阅记录
    int deleteBorrowBySid();

    //根据学号书号修改借阅记录状态
    int updateBorrow();

}
