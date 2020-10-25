package serviceimpl;

import Dao.BookDao;
import Dao.BorrowDao;
import Dao.StudentDao;
import DaoImpl.BookDaoImpl;
import DaoImpl.BorrowDaoImpl;
import DaoImpl.StudentDaoImpl;
import entity.Book;
import entity.Borrow;
import entity.Student;
import service.BookService;
import service.BorrowService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BorrowServiceImpl implements BorrowService {
    Scanner scanner =  new Scanner(System.in);
    private BorrowDao borrowDao = new BorrowDaoImpl();

    //写一个StudentDao实现类对象
    private StudentDao studentDao = new StudentDaoImpl();

    //写一个BookDao实现类对象
    private BookDao bookDao = new BookDaoImpl();
    public int addBorrow() {
        System.out.println("请输入学号:");
        int sid = scanner.nextInt();
        //根据学号查询学生信息
        Student student = studentDao.find(sid);
        if (student == null) {
            System.out.println("查无此人");
            return 0;
        } else {
            System.out.println("请输入书号:");
            int bid = scanner.nextInt();
            //根据书号查询图书信息
            Book book = bookDao.find(bid);
            if (book == null) {
                System.out.println("查无此书");
                return 0;
            } else {
                //获取所有借阅记录
                List<Borrow> findBorrowByBid = borrowDao.findBorrowByBid(book);
                if (findBorrowByBid.size() > 0) {
                    //写一个变量
                    int find = -1;
                    for (Borrow borrow : findBorrowByBid) {
                        if (borrow.getBwstatus().equals("借阅中")) {
                            find = 1;
                            break;
                        }
                    }
                    if (find == -1) {
                        System.out.println("请输入多少天后还书:");
                        int day = scanner.nextInt();
                        //调用借阅对象
                        return borrowDao.addBorrow(dealAddBorrow(student, book, day));
                    } else {
                        System.out.println("借阅中");
                        return 0;
                    }
                } else {
                    System.out.println("请输入多少天后还书:");
                    int day = scanner.nextInt();
                    //调用借阅对象
                    return borrowDao.addBorrow(dealAddBorrow(student, book, day));
                }
            }
        }
    }

    private Borrow dealAddBorrow(Student student, Book book, int day) {
        //生成借书流水号
        //写一个Date对象
        Date date = new Date();
        //写一个日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sdf.format(date);
        //借书日期
        SimpleDateFormat bsdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String bwdate = bsdf.format(date);
        //还书日期
        SimpleDateFormat esdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date.setDate(date.getDate() + day);//多少天后还书
        String edate = bsdf.format(date);
        //写一个Borrow对象
        return new Borrow(format, book.getBid(), book.getBname(), student.getSid(), student.getSname(), bwdate,
                edate, "借阅中");
    }


    @Override
    public void findBorrowBySid() {
        System.out.println("请输入学号:");
        int sid = scanner.nextInt();
        List<Borrow> findBorrowByBid = borrowDao.findBorrowBySid(new Student(sid));
        for (Borrow borrow : findBorrowByBid) {
            System.out.println(borrow);
        }
    }


    @Override
    public void findAllBorrow() {
        List<Borrow> findAllBorrow = borrowDao.findAllBorrow();
        for (Borrow borrow : findAllBorrow) {
            System.out.println(borrow);
        }
    }


    @Override
    public int deleteBorrowBySid() {
        System.out.println("请输入学号:");
        int sid = scanner.nextInt();
        List<Borrow> findBorrowByBid = borrowDao.findBorrowBySid(new Student(sid));
        if (findBorrowByBid.size() > 0) {
            //写一个变量
            List<Borrow> list = new ArrayList<Borrow>();
            for (Borrow borrow : findBorrowByBid) {
                if (borrow.getBwstatus().equals("借阅中")) {
                    list.add(borrow);
                }
            }
            if (list.size() > 0) {
                System.out.println("该学生还有书在借阅状态，不能删除!");
                return 0;
            } else {
                return borrowDao.deleteBorrowBySid(new Borrow(sid));
            }
        } else {
            System.out.println("学号不存在");
            return 0;
        }
    }


    @Override
    public int updateBorrow() {
        System.out.println("请输入学号:");
        int sid = scanner.nextInt();
        System.out.println("请输入书号:");
        int bid = scanner.nextInt();
        System.out.println("请输入已经借书多少天:");
        int day = scanner.nextInt();
        //写一个Date对象
        Date date = new Date();
        //写一个日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date.setDate(date.getDate() + day);
        String format = sdf.format(date);
        return borrowDao.updateBorrow(new Borrow(sid, bid, format, "已还"));
    }

}
