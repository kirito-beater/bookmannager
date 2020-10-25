package serviceimpl;

import Dao.StudentDao;
import Dao.UserDao;
import DaoImpl.StudentDaoImpl;
import DaoImpl.UserDaoImpl;
import entity.Student;
import entity.User;
import service.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    Scanner  scanner = new Scanner(System.in);
    @Override
    public int add() {
        System.out.println("请输入借阅学生的姓名");
        String  str = scanner.next();
        System.out.println("请输入借阅学生的班级");
        String  str1 = scanner.next();
        System.out.println("请输入借阅学生的电话号码");
        String  str2 = scanner.next();
        int add =  studentDao.add(str,str1,str2);
        if(add>0){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
        return 0;
    }

    @Override
    public int updateclasses() {
        System.out.println("请输入需要查询学生的学号");
        Integer a = scanner.nextInt();
        System.out.println("请输入需要修改的班级号");
        String  str = scanner.next();
        int add = studentDao.updateclasses(str,a);
        if(add>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        return 0;
    }

    @Override
    public int updatetell() {
        System.out.println("请输入需要查询学生的学号");
        Integer a = scanner.nextInt();
        System.out.println("请输入需要修改的班电话号码");
        String  str = scanner.next();
        int add = studentDao.updatetell(str,a);
        if(add>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        return 0;
    }

    @Override
    public int delete() {
        System.out.println("请输入学生编号");
        int a  =scanner.nextInt();
        int add = studentDao.delete(a);
        if(add>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        return 0;
    }

    @Override
    public List<Student> findall() {
        List<Student> list = studentDao.findall();
        for (Student student : list
        ) {
            System.out.println(student);
        }
        return list;
    }

    @Override
    public Student find() {
        Student student = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入查找学生的学号");
        Integer a = scanner.nextInt();
        student= studentDao.find(a);
        System.out.println(student);
        return student;
    }
}
