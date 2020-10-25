package Dao;

import entity.Student;

import java.util.List;

public interface StudentDao {
    int add( String sname,String classes,String tells);
    int updateclasses(String classes,int sid);
    int updatetell(String tells,int sid);
    int delete(int sid);
    List<Student> findall();
    Student find(int sid);
}
