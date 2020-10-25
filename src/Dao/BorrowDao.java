package Dao;

import entity.Book;
import entity.Borrow;
import entity.Student;

import java.util.List;

public interface BorrowDao {
    int addBorrow(Borrow borrow);

    //查询所有借阅记录
    List<Borrow> findAllBorrow();

    //根据学号查询学生借阅记录
    List<Borrow> findBorrowBySid(Student student);

    //根据学号删除学生借阅记录
    int deleteBorrowBySid(Borrow borrow);

    //根据学号书号修改借阅记录状态
    int updateBorrow(Borrow borrow);

    //根据书号查询借阅记录
    List<Borrow> findBorrowByBid(Book book);
}
