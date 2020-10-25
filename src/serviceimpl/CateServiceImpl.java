package serviceimpl;

import Dao.BookDao;
import Dao.CateDao;
import DaoImpl.BookDaoImpl;
import DaoImpl.CateDaoImpl;
import entity.Book;
import entity.Cate;
import entity.User;
import service.CateService;

import java.util.List;
import java.util.Scanner;

public class CateServiceImpl implements CateService {
    private CateDao cateDao = new CateDaoImpl();
    private BookDaoImpl bookDao =  new BookDaoImpl();
    @Override
    public int add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要添加的类型");
        String  str = scanner.next();
        int add = cateDao.add(str);
        if(add>0){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
        return 0;
    }

    @Override
    public int update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要修改的类型的ID");
        Integer a = scanner.nextInt();
        System.out.println("请输入要修改的类型名");
        String  str = scanner.next();
        int add = cateDao.update(str,a);
        Book id = bookDao.findbook(a);
        if(id!=null) {
            System.out.println("删除失败有书在此类下");
        }else
        {
            if(add>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        }

        return 0;
    }

    @Override
    public int delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的的类型");
        Integer a = scanner.nextInt();
        int add = cateDao.delete(a);
        Book id = bookDao.findbook(a);
        if(id!=null){
            System.out.println("删除失败有书在此类下");
        }else {
            if(add>0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        }

        return 0;
    }

    @Override
    public List<Cate> query() {
        List<Cate> list = cateDao.findAll();
        for (Cate cate : list
        ) {
            System.out.println(cate);
        }

        return list;
    }

    @Override
    public Cate catefind() {
        Cate cate =null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的编号");
        Integer a = scanner.nextInt();

        cate = cateDao.findcate(a);
        System.out.println(cate);
        return  cate;
    }
}
