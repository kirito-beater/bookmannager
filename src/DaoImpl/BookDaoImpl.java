package DaoImpl;

import Dao.BookDao;
import entity.Book;
import entity.Cate;
import util.JDBCUtils;

import java.util.List;

public class BookDaoImpl  implements BookDao {
    @Override
    public int add(int bid,String bname, double price, int cid, String storetime) {
        String sql = "insert into tb_book (bid,bname,price,cid,storetime)values (?,?,?,?,?)";
        Object[] params = {bid,bname, price, cid, storetime};
        return new JDBCUtils().executeUpdate(sql, params);
    }

    @Override
    public int updateprice(double price, int bid) {//根据书号修改价格
        String sql = "update tb_book set price=? where bid=?";
        Object[] params = {price, bid};
        return new JDBCUtils().executeUpdate(sql, params);

    }

    @Override
    public int updatecate(int cid, int bid) {
        String sql = "update tb_book set cid=? where bid=?";
        Object[] params = {cid, bid};
        return new JDBCUtils().executeUpdate(sql, params);
    }


    @Override
    public int delete(int bid) {
        String sql = "delete from tb_book  where bid=?";
        Object[] params = {bid};
        return new JDBCUtils().executeUpdate(sql, params);

    }

    @Override
    public Book find(int bid) {
        String sql = "select * from tb_book where bid = ?";
        Object[] params = {bid};
        return new JDBCUtils().executeQueryOne(sql, params, Book.class);
    }
public Book findbook(int cid){              //获取的方法
    String sql = "select * from tb_book where cid = ?";
    Object[] params = {cid};
    return new JDBCUtils().executeQueryOne(sql, params, Book.class);

}
    @Override
    public List<Book> findall() {
        String sql = "select * from tb_book";
        Object[] params = {};
        return new JDBCUtils().executeQuery(sql, params, Book.class);
    }

}
