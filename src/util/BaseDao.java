package util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDao {





        private static String driver = null;
        private static String url = null;
        private static String user = null;
        private static  String password = null;
        public static void init(){
            Properties properties = new Properties();
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("dp.properties");
            try {
                properties.load(inputStream);
                driver = properties.getProperty("driver");
                url = properties.getProperty("url");
                user = properties.getProperty("user");
                password = properties.getProperty("password");
                try {
                    Class.forName(driver);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
        static {
            init();
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }



        }
        public  static  Connection getConnection() {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url,user,password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return connection;
        }

    }

