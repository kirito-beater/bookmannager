package DaoImpl;

import Dao.StudentDao;
import entity.Student;
import entity.User;
import util.JDBCUtils;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    //添加
        public int add( String sname,String classes,String tells) {
        String sql = "insert into tb_student (sname,classes,tells) values(?,?,?)";
        Object[] params = {sname, classes, tells};
        return new JDBCUtils().executeUpdate(sql, params);

    }

    @Override
    public int updateclasses(String classes,int sid) { //根据学号修改班级
        String sql = "update  tb_student set classes=? where sid =?";
        Object[] params = { classes, sid};
        return new JDBCUtils().executeUpdate(sql, params);
    }

    @Override
    public int updatetell(String tells,int sid) { //根据学号修改电话
        String sql = "update  tb_student set tells=? where sid =?";
        Object[] params = { tells, sid};
        return new JDBCUtils().executeUpdate(sql, params);
    }

    @Override
    public int delete(int sid) {
        String sql = "delete from tb_student where sid=?";//删除
        Object[] params = {sid};
        return new JDBCUtils().executeUpdate(sql, params);

    }

    @Override
    public List<Student> findall() { // 查询所有学生
        String sql = "select * from tb_student";
        Object[] params = {};
        return new JDBCUtils().executeQuery(sql, params, Student.class);
    }

    @Override
    public Student find(int sid) {  // 根据学号查询学生
        String sql = "select * from tb_student where sid = ?";
        Object[] params = {sid};
        return new JDBCUtils().executeQueryOne(sql, params, Student.class);
    }
}
