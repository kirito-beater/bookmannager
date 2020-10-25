package DaoImpl;

import Dao.CateDao;
import entity.Cate;


import entity.User;
import util.JDBCUtils;

import java.util.List;

public class CateDaoImpl implements CateDao {
    @Override
    public int add(String cname) {
        String sql = "insert into tb_category (cname) values(?)";
        Object[] params = { cname };
        return new JDBCUtils().executeUpdate(sql, params);

    }

    @Override
    public int update(String cname,int cid) {
        String sql = "update  tb_category set cname = ? where cid=?";
        Object[] params = { cname,cid };
        return new JDBCUtils().executeUpdate(sql, params);
    }

    @Override
    public int delete(int cid) {
        String sql = "delete from tb_category where cid = ?";
        Object[] params = { cid };

        return   new JDBCUtils().executeUpdate(sql, params);
    }

    @Override
        public   List<Cate> findAll(){//查找所有
        String sql = "select * from tb_category";
        Object[] params = {};
        return new JDBCUtils().executeQuery(sql, params, Cate.class);
    }

    @Override
    public Cate findcate(int cid) {//根据编号查找
        String sql = "select * from tb_category where cid = ?";
        Object[] params = {cid};
        return new JDBCUtils().executeQueryOne(sql, params, Cate.class);
    }
}
