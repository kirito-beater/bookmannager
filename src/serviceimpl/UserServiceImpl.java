package serviceimpl;

import Dao.UserDao;
import DaoImpl.UserDaoImpl;
import entity.User;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    public User find() {       //三次登录
        User use = null;

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名");
            String str1 = scanner.next();
            System.out.println("请输入密码");
            String str2 = scanner.next();
            use = userDao.find(str1, str2);
            if (use != null) {
                break;
            }
            if (i == 3) {
                System.out.println("输入次数过多退出系统");
                System.exit(0);
            } else {
                System.out.println("输入有误，重新输入");
            }

        }
        return use;
    }

    @Override
    public List findAll() {
        List<User> list = userDao.findAll();
        for (User user : list
        ) {
            System.out.println(user);
        }

        return list;
    }

    @Override
    public int add() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("用户名");
        String str1 = scanner.next();
        System.out.println("密码");
        String str2 = scanner.next();
        System.out.println("姓名");
        String str3 = scanner.next();
        System.out.println("身份证号");
        String str4 = scanner.next();
        System.out.println("电话号码");
        String str5 = scanner.next();
        System.out.println("地址");
        String str6 = scanner.next();
        int use = userDao.add(str1, str2, str3, str4, str5, str6);
        if (use > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
        return 0;
    }

    @Override
    public int update() {
        User use = null;
        Scanner scanner = new Scanner(System.in);



                System.out.println("请输入新密码");
                String str = scanner.next();
                int a =  userDao.update( str);
                if(a>0){
                    System.out.println("修改密码成功");
                }else{
                    System.out.println("修改密码失败");
                }



            return  0;
    }

    @Override
    public int upadteadmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择要修改的管理员编号");
        Integer a = scanner.nextInt();
        System.out.println("用户名");
        String str1 = scanner.next();
        System.out.println("密码");
        String str2 = scanner.next();
        System.out.println("姓名");
        String str3 = scanner.next();
        System.out.println("身份证号");
        String str4 = scanner.next();
        System.out.println("电话号码");
        String str5 = scanner.next();
        System.out.println("地址");
        String str6 = scanner.next();
        int update = userDao.updateadmin(str1, str2, str3, str4, str5, str6,a);
        if(update>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        return  0;
    }

    @Override
    public int deleteadmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择要删除的管理员编号");
        Integer a = scanner.nextInt();
        int delete = userDao.deleteadmin(a);
        if(delete>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }

        return 0;
    }

    @Override
    public int deletepersonid() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入删除管理员的身份证号");
        String a = scanner.next();
        int delete = userDao.deletepersonid(a);
        if(delete>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        return 0;
    }

    @Override
    public int deleteacount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入删除管理员的用户名");
        String str = scanner.next();
        int delete = userDao.deleteacount(str);
        if(delete>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        return  0;
    }

    @Override
    public User findid() {
        User user = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入查找管理员的id");
        Integer a = scanner.nextInt();
        user = userDao.findid(a);
        System.out.println(user);
        return user;
    }

    @Override
    public User findpersonid() {
        User user = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入查找管理员的身份证号");
        String a = scanner.next();
        user = userDao.findpersonid(a);
        System.out.println(user);
        return user;
    }


}
