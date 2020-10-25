package DaoImpl;

import Dao.UserDao;
import entity.User;
import util.JDBCUtils;

import java.util.List;

public  class UserDaoImpl  implements UserDao{
    @Override
    public List<User> findAll() {
        String sql = "select * from tb_user";
        Object[] params = {};
        return new JDBCUtils().executeQuery(sql, params, User.class);
    }


    public  int update(String acount){
        String sql="update tb_user set password=? where uid=1";
        Object[] params = {acount};
        return  new JDBCUtils().executeUpdate(sql, params);
    }


    @Override
    public User find(String user, String password) {
        String sql = "select * from tb_user where account = ?and password=?";
        Object[] params = { user,password  };
        return new JDBCUtils().executeQueryOne(sql, params, User.class);
    }




    public int add(String account, String password, String realname, String personid, String tell, String address) {
        String sql = "insert into tb_user(account,password,realname,personid,tell,address) values(?,?,?,?,?,?)";
        Object[] params = { account,password,realname,personid,tell,address };
        return new JDBCUtils().executeUpdate(sql, params);

    }

    @Override
    public int updateadmin(String account, String password, String realname, String personid, String tell, String address,int id) {
        String sql="update tb_user set account=?,password=?,realname=?,personid=?,tell=?,address=?where uid = ?";
        Object[] params = { account,password,realname,personid,tell,address,id };
        return new JDBCUtils().executeUpdate(sql, params);
    }

    @Override
    public int deleteadmin( int id) {
        String sql="delete  from tb_user where uid = ?";
        Object[] params = { id };
        return new JDBCUtils().executeUpdate(sql, params);
    }

    @Override
    public int deletepersonid(String personid) {//通过员工身份证号删除
        String sql="delete  from tb_user where personid = ?";
        Object[] params = { personid };
        return new JDBCUtils().executeUpdate(sql, params);
    }

    @Override
    public int deleteacount(String account) {//通过员工账号删除
        String sql="delete from  tb_user where account = ?";
        Object[] params = { account };
        return new JDBCUtils().executeUpdate(sql, params);
    }

    @Override
    public User findid(int uid) {
        String sql = "select * from tb_user where uid=?";
        Object[] params = { uid };
        return new JDBCUtils().executeQueryOne(sql, params, User.class);
    }

    @Override
    public User findpersonid(String personid) {
        String sql = "select * from tb_user where personid=?";
        Object[] params = {personid };
        return new JDBCUtils().executeQueryOne(sql, params, User.class);
    }
}
