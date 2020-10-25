package serviceimpl;

import Dao.BookDao;
import Dao.UserDao;
import DaoImpl.BookDaoImpl;
import DaoImpl.BorrowDaoImpl;
import DaoImpl.UserDaoImpl;
import entity.Book;
import entity.Borrow;
import entity.User;
import service.BookService;

import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    private BorrowDaoImpl borrowDao = new BorrowDaoImpl();
    Scanner scanner = new Scanner(System.in);

    @Override
    public int add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要添加的书编号");
        Integer c = scanner.nextInt();
        System.out.println("请输入要添加的书名");
        String str1 = scanner.next();
        System.out.println("请输入要添加书的价钱");
        Double a;

        try {
            a = scanner.nextDouble();
        }catch (Exception InputMismatchException){
            System.out.println("输入类型不一致请重新输入");

            a = scanner.nextDouble();
        }
        System.out.println("请输入要添加的类型编号");
        Integer b ;
        try {
            b = scanner.nextInt();
        }catch (Exception InputMismatchException){
            System.out.println("输入类型不一致请重新输入");

             b = scanner.nextInt();
        }
        System.out.println("请输入要添加的书的入库时间");
        String str3 = scanner.next();
        int add = bookDao.add(c,str1, a, b, str3);
        if (add > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }


        return 0;
    }

    @Override
    public int updateprice() {
        System.out.println("请输入书号");
        Integer a = scanner.nextInt();
        System.out.println("输入价格");
        Double b = scanner.nextDouble();
        int add = bookDao.updateprice(b, a);
        if (add > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
        return 0;
    }

    @Override
    public int updatecate() {
        System.out.println("请输入书号");
        Integer a = scanner.nextInt();
        System.out.println("输入类型编号");
        Integer b = scanner.nextInt();


                int add = bookDao.updatecate(b, a);
                if (add > 0) {
                    System.out.println("修改成功");
                } else {
                    System.out.println("修改失败");
                }

        return 0;
    }


    @Override
    public int delete() {
        System.out.println("请输入编号");
        Integer a = scanner.nextInt();

            int add = bookDao.delete(a);
            if (add > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }

        return 0;
    }

    @Override
    public Book find() {

            Book book = null;
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入书号查找");
            Integer a = scanner.nextInt();
            book = bookDao.find(a);
            System.out.println(book);

        return book;
    }

    @Override
    public List<Book> findall() {
        List<Book> list = bookDao.findall();
        for (Book book : list
        ) {
            System.out.println(book);
        }

        return list;
    }

}