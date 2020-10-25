package DaoImpl;

import Dao.BorrowDao;
import entity.Book;
import entity.Borrow;
import entity.Student;
import util.JDBCUtils;

import java.util.List;

public class BorrowDaoImpl implements BorrowDao {
    public int addBorrow(Borrow borrow) {
        String sql = "insert into tb_borrow(bwid,bid,bname,sid,sname,bwdate,expectdate,bwstatus) values(?,?,?,?,?,?,?,?)";
        Object[] obj = {borrow.getBwid(), borrow.getBid(), borrow.getBname(), borrow.getSid(), borrow.getSname(),
                borrow.getBwdate(), borrow.getExpectdate(), borrow.getBwstatus()};
        return new JDBCUtils().executeUpdate(sql, obj);
    }


    @Override
    public List<Borrow> findAllBorrow() {
        String sql = "select * from tb_borrow";
        Object[] obj = {};
        return new JDBCUtils().executeQuery(sql, obj, Borrow.class);
    }


    @Override
    public List<Borrow> findBorrowBySid(Student student) {
        String sql = "select * from tb_borrow where sid=?";
        Object[] obj = {student.getSid()};
        return new JDBCUtils().executeQuery(sql, obj, Borrow.class);
    }


    @Override
    public int deleteBorrowBySid(Borrow borrow) {
        String sql = "delete from tb_borrow where sid=?";
        Object[] obj = {borrow.getSid()};
        return new JDBCUtils().executeUpdate(sql, obj);
    }


    @Override
    public int updateBorrow(Borrow borrow) {
        String sql = "update tb_borrow set expectdate=?,bwstatus=? where sid=? and bid=?";
        Object[] obj = {borrow.getExpectdate(), borrow.getBwstatus(), borrow.getSid(), borrow.getBid()};
        return new JDBCUtils().executeUpdate(sql, obj);
    }


    @Override
    public List<Borrow> findBorrowByBid(Book book) {
        String sql = "select * from tb_borrow where bid=?";
        Object[] obj = {book.getBid()};
        return new JDBCUtils().executeQuery(sql, obj, Borrow.class);
    }
}