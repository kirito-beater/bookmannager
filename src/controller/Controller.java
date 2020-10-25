package controller;

import entity.Borrow;
import entity.User;
import service.*;
import serviceimpl.*;
import utilmenu.Menu;

import java.net.SecureCacheResponse;
import java.util.Scanner;

public class Controller {
    private Menu  mulu =  new Menu();
    private StudentService studentService = new StudentServiceImpl();
    private UserService userService = new UserServiceImpl();
    private BookService bookService = new BookServiceImpl();
    private CateService cateService = new CateServiceImpl();
    private BorrowService borrowService = new BorrowServiceImpl();
    public void start() {
            mulu.startMenu();
            Scanner scanner = new Scanner(System.in);
        System.out.println("请选择");
            int num = scanner.nextInt();
            if(num==1||num==2) {
         switch (num){



                 case 1:

                     User user = userService.find();

                     if (user.getPower() == 1) {
                         mulu.superUserMenu();
                         superadminlogin();
                         //超级管理员界面

                     } else if (user.getPower() == 0) {

                         bookManagerMenulogin();
                     } else {
                         System.out.println("输入错误");
                     }
                     break;
                 case 2:
                     System.exit(0);
             }
            }else{
                System.out.println("你输入的格式不正确请重新输入");
                start();
            }

    }
    public void superadminlogin(){//超级管理员管理界面
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择");
        int a = scanner.nextInt();
        switch (a){
            case 1:
                superadmin();//进入管理图书管理员界面
                break;
            case 2:
                userService.update();//修改密码
                superadminlogin();
                break;
            case 3://退出系统
                System.exit(0);
        }
    }
        public  void superadmin(){ //超级管理员管理图书管理员界面
            mulu.superManagerBookAdminMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请选择");
            int a = scanner.nextInt();
            switch (a){
                case 1:
                    System.out.println("添加图书管理员");
                    userService.add();//添加图书管理员
                    superadmin();

                case 2:
                    System.out.println("修改图书管理员");
                    userService.upadteadmin();//修改图书管理员
                    superadmin();

                case 3:
                     System.out.println("通过员工编号删除管理员");
                     userService.deleteadmin();//通过员工编号删除管理员
                     superadmin();
                case 4:
                      System.out.println("通过身份证号删除");
                      userService.deletepersonid();//通过身份证号删除
                      superadmin();
                case 5:
                      System.out.println("通过用户名删除 ");
                      userService.deleteacount();//通过用户名删除
                      superadmin();
                case 6:
                       System.out.println("查询所有图书管理员");
                       userService.findAll();//查询所有图书管理员
                       superadmin();
                case 7:
                       System.out.println("通过编号查询图书管理员");
                       userService.findid();//通过编号查询图书管理员
                       superadmin();
                case 8:
                       System.out.println("通过身份证号查询图书管理员");
                       userService.findpersonid();//通过身份证号查询图书管理员
                       superadmin();
                case 9:
                       start();
            }

        }
    public  void bookManagerMenulogin(){
        mulu.bookManagerMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择");
         int  a  = scanner.nextInt();
         switch (a){
             case 1://图书分类管理
                 bookcategory();
                 case 2://图书信息管理
                 book();
             case 3:
                 studentlogin();
                 //学生信息管理
             case 4:
                 borrow();//借阅信息管理
             case 5:
                 Systemfind();//系统查询
             case 6://退出系统
                 System.exit(0);
         }
    }
    public void bookcategory(){
        mulu.bookcategorymenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择");
        int a = scanner.nextInt();
        switch (a){
            case 1:
                cateService.add();
                bookcategory();
            case 2:
               cateService.update();
                bookcategory();
            case 3:
                cateService.delete();
                bookcategory();
            case 4:
                System.out.println("全部查找");
                cateService.query();
                bookcategory();
                case 5:
                    System.out.println("根据编号查找");
                    cateService.catefind();
                    bookcategory();


            case 6:
                bookManagerMenulogin();

        }
    }
public  void studentlogin(){
        mulu.studentmenu();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        switch (num){
            case 1:
                System.out.println("添加学生信息");
                studentService.add();
                studentlogin();
            case 2:
                System.out.println("根据学号修改学生班级");
                studentService.updateclasses();
                studentlogin();
            case 3:
                System.out.println("根据学号修改电话");
                studentService.updatetell();
                studentlogin();
            case 4:
                System.out.println("删除学生信息");
                studentService.delete();
                studentlogin();
            case 5:
                System.out.println("查询所有学生信息");
                studentService.findall();
                studentlogin();
            case 6:
                System.out.println("根据学号查询学生信息");
                studentService.find();
                studentlogin();
            case 7:
                System.out.println("返回上一级");
                bookManagerMenulogin();

        }

}
public  void book(){
    mulu.bookmenu();
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    switch (num){
        case 1:
            System.out.println("添加图书分类信息");
            bookService.add();
           book();
        case 2:
            System.out.println("根据书号修改图书价格");
            bookService.updateprice();
            book();
        case 3:
            System.out.println("根据书号修改图书分类");
            bookService.updatecate();
            book();
        case 4:
            System.out.println("图书下架");
            bookService.delete();
            book();
        case 5:
            System.out.println("根据书号查书");
            bookService.find();
            book();
        case 6:
            System.out.println("查询所有书");
            bookService.findall();
            book();
            case 7:
                System.out.println("返回上一级");
                bookManagerMenulogin();

    }

}
public  void Systemfind(){
        mulu.Sytemmune();
        Scanner scanner = new Scanner(System.in);
        int num =  scanner.nextInt();
        switch (num){
            case 1:
                System.out.println("图书分类查询");
                cateService.query();
                Systemfind();
            case 2:
                System.out.println("图书信息查询");
                bookService.findall();
                Systemfind();
            case 3:
                System.out.println("学生信息查询");
                studentService.findall();
                Systemfind();
            case 4:
                System.out.println("借阅信息查询");
                borrowService.findAllBorrow();
                Systemfind();
            case 5:
                System.out.println("返回上一级");
                bookManagerMenulogin();

        }

}
public  void  borrow(){
    mulu.borrowmenu();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        switch (num){
            case 1:
                borrowService.addBorrow();
                borrow();
            case 2:
                borrowService.deleteBorrowBySid();
                borrow();
            case 3:
                borrowService.updateBorrow();
                borrow();
            case 4:
                borrowService.findAllBorrow();
                borrow();
            case 5:
                borrowService.findBorrowBySid();
                borrow();

            case 6:
                bookManagerMenulogin();;

        }
}
}


