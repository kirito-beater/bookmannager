package util;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;


    public class JDBCUtils {
        private Connection conn = null;//连接数据库

        private PreparedStatement ps = null;//预编译

        private ResultSet rs = null;//结果集
        //写一个静态代码块，注册驱动(加载驱动)
        static {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //使用驱动管理器连接数据库
        private Connection getConn() {
            try {
                conn = DriverManager.getConnection("jdbc:mysql:///bookmanager", "root", "123456");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return conn;
        }

        //查询所有信息
        public <T> List<T> executeQuery(String sql, Object[] params, Class<T> clazz) {
            List<T> list = new ArrayList<T>();//写一个集合
            try {
                conn = getConn();//获取连接
                ps = conn.prepareStatement(sql);//通过连接创建PreparedStatement对象
                if (params != null) {//判断参数?不为空
                    for (int i = 0; i < params.length; i++) {
                        ps.setObject(i + 1, params[i]);//给参数？赋值
                    }
                }
                rs = ps.executeQuery();//通过 PreparedStatement对象执行SQL语句并返回结果集
                ResultSetMetaData metaData = rs.getMetaData();//获取ResultSet中的编号、类型和属性
                int count = metaData.getColumnCount();//获取列的数量
                T t = null;//写一个变量
                //遍历
                while (rs.next()) {//遍历
                    t = clazz.newInstance();//获取一个新的实例，就是对象
                    for (int i = 1; i <= count; i++) {
                        BeanUtils.copyProperty(t, metaData.getColumnLabel(i), rs.getObject(i));//给t对象赋值
                    }
                    list.add(t);//把对象存放到集合中
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                getClose(rs, ps, conn);
            }
            return list;
        }

        //条件查询
        public <T> T executeQueryOne(String sql, Object[] params, Class<T> clazz) {
            List<T> list = executeQuery(sql, params, clazz);
            if (list != null && list.size() > 0) {
                return list.get(0);
            }
            return null;
        }

        //增删改操作
        public int executeUpdate(String sql, Object[] params) {
            try {
                conn = getConn();//获取连接
                ps = conn.prepareStatement(sql);//通过连接创建PreparedStatement对象
                if (params != null) {//判断参数?不为空
                    for (int i = 0; i < params.length; i++) {
                        ps.setObject(i + 1, params[i]);//给参数？赋值
                    }
                }
                return ps.executeUpdate();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                getClose(rs, ps, conn);
            }
            return 0;
        }

        //获取数据的数量
        public int getCount(String sql, Object[] params) {
            conn = getConn();//获取连接
            try {
                ps = conn.prepareStatement(sql);//通过连接创建PreparedStatement对象
                if (params != null) {//判断参数?不为空
                    for (int i = 0; i < params.length; i++) {
                        ps.setObject(i + 1, params[i]);//给参数？赋值
                    }
                }
                rs = ps.executeQuery();//通过 PreparedStatement对象执行SQL语句并返回结果集
                while (rs.next()) {
                    return rs.getInt(1);//返回的表中数据的数量
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                getClose(rs, ps, conn);
            }
            return 0;
        }

        //释放资源
        public void getClose(ResultSet rs, PreparedStatement ps, Connection conn) {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }

                } catch (Exception e2) {
                    // TODO: handle exception
                } finally {
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (Exception e3) {
                        // TODO: handle exception
                    }
                }
            }
        }
    }

