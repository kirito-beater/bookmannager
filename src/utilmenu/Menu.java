package utilmenu;

public class Menu {
    public void startMenu() {
        System.out.println("**************************");
        System.out.println("图书管理系统");
        System.out.println("1.登录；");
        System.out.println("2.退出；");
        System.out.println("**************************");
        System.out.println("请选择(输入1-2整数):");
    }

    //超级管理员管理菜单
    public void superUserMenu() {
        System.out.println("**************************");
        System.out.println("图书管理系统->超级管理员管理");
        System.out.println("1.管理图书管理员；");
        System.out.println("2.修改自己密码；");
        System.out.println("3.退出系统；");
        System.out.println("**************************");
        System.out.println("请选择(输入1-3整数):");
    }

    //超级管理员管理图书管理员菜单
    public void superManagerBookAdminMenu() {
        System.out.println("**************************");
        System.out.println("图书管理系统->超级管理员管理图书管理员");
        System.out.println("1.添加图书管理员；");
        System.out.println("2.修改图书管理员；");
        System.out.println("3.通过员工编号删除管理员");
        System.out.println("4.通过身份证号删除");
        System.out.println("5.通过用户名删除");
        System.out.println("6.查询所有图书管理员");
        System.out.println("7.通过编号查询图书管理员");
        System.out.println("8.通过身份证号查询图书管理员");
        System.out.println("9.返回上一级");
        System.out.println("**************************");
        System.out.println("请选择(输入1-9整数):");
    }

    //进入图书管理员菜单
    public void bookManagerMenu() {
        System.out.println("**************************");
        System.out.println("图书管理系统->图书管理员管理");
        System.out.println("1.图书分类管理；");
        System.out.println("2.图书信息管理；");
        System.out.println("3.学生信息管理；");
        System.out.println("4.借阅记录管理；");
        System.out.println("5.系统查询；");
        System.out.println("6.退出系统；");
        System.out.println("**************************");
        System.out.println("请选择(输入1-6整数):");
    }
    public  void bookcategorymenu(){
        System.out.println("**************************");
        System.out.println("图书分类管理");
        System.out.println("1.添加图书分类信息");
        System.out.println("2.修改图书分类信息");
        System.out.println("3.删除图书分类信息");
        System.out.println("4.查询图书全部分类信息");
        System.out.println("5.根据编号查找图书分类信息");
        System.out.println("6.返回上一级");
        System.out.println("**************************");
        System.out.println("请选择(输入1-6整数):");
    }
    public  void studentmenu(){
        System.out.println("**************************");
        System.out.println("学生信息管理界面");
        System.out.println("1.添加学生信息");
        System.out.println("2.根据学号修改学生班级");
        System.out.println("3.根据学号修改电话");
        System.out.println("4.删除学生信息");
        System.out.println("5.查询所有学生信息");
        System.out.println("6.根据学号查询学生信息");
        System.out.println("7.返回上一级");
        System.out.println("**************************");
        System.out.println("请选择(输入1-7整数):");
    }
    public void bookmenu(){
        System.out.println("**************************");
        System.out.println("图书分类管理界面");
        System.out.println("1.添加图书分类信息");
        System.out.println("2.根据书号修改图书价格");
        System.out.println("3.根据书号修改图书分类");
        System.out.println("4.图书下架");
        System.out.println("5.根据书号查书");
        System.out.println("6.查询所有书");
        System.out.println("7.返回上一级");
        System.out.println("**************************");
        System.out.println("请选择(输入1-7整数):");
    }
    public void Sytemmune(){
        System.out.println("**************************");
        System.out.println("系统查询界面");
        System.out.println("1.图书分类查询");
        System.out.println("2.图书信息查询");
        System.out.println("3.学生信息查询");
        System.out.println("4.借阅信息查询");
        System.out.println("5.返回上一级");
        System.out.println("**************************");
        System.out.println("请选择(输入1-5整数):");

    }
    public void borrowmenu(){
        System.out.println("**************************");
        System.out.println("借阅记录管理界面");
        System.out.println("1.借书");
        System.out.println("2.删除借阅记录");
        System.out.println("3.修改借书状态和还书时间");
        System.out.println("4.查询所有借阅记录");
        System.out.println("5.根据学号和书号查询借阅记录");
        System.out.println("6.返回上一级");
        System.out.println("**************************");
        System.out.println("请选择(输入1-6整数):");
    }
}

