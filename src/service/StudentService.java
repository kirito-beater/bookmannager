package service;

import entity.Student;

import java.util.List;

public interface StudentService {
    int add( );
    int updateclasses();
    int updatetell();
    int delete();
    List<Student> findall();
    Student find();
}
