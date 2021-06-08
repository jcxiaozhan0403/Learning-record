package cn.com.scitc.webapp1.utils;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.*;
@Component
public class SqlHelper
{
    //定义变量
    private static Connection ct = null;
    //大多数情况下用preparedstatement替代statement
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    //连接数据库的参数
    private static String url = null;
    private static String username =null;
    private static String driver =null;
    private static String passwd =null;

    private static CallableStatement cs = null;
    public static CallableStatement getCs()
    {
        return cs;
    }
    private static Properties pp = null;
    private static InputStream fis = null;
    //加载驱动，只需要一次，用静态代码块
    static
    {
        try
        {
            //从dbinfo.properties
            pp = new Properties();
            url = "jdbc:mysql://localhost:3306/webapp1901";
            driver = "com.mysql.jdbc.Driver";
            username = "root";
            passwd = "lishuang001219";

            Class.forName(driver);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {

        }

    }
    //得到连接
    public static Connection getConnection()
    {
        try
        {ct = DriverManager.getConnection(url,username,passwd);}
        catch(Exception e) {e.printStackTrace();}
        return ct;
    }


    //*************callPro1存储过程函数1*************
    public static CallableStatement callPro1(String sql,String[] parameters)
    {
        try{
            ct = getConnection();
            cs = ct.prepareCall(sql);
            if(parameters!=null){
                for(int i=0;i<parameters.length;i++){
                    cs.setObject(i+1,parameters[i]);
                }
            }
            cs.execute();
        }
        catch(Exception e) { e.printStackTrace(); throw new RuntimeException(e.getMessage());}
        finally
        { close(rs,cs,ct);}
        return cs;
    }

    //*******************callpro2存储过程2************************
    public static CallableStatement callPro2(String sql,String[] inparameters,
                                             Integer[] outparameters)
    {
        try
        {
            ct = getConnection();
            cs = ct.prepareCall(sql);
            if(inparameters!=null)
            {
                for(int i=0;i<inparameters.length;i++)
                {
                    cs.setObject(i+1,inparameters[i]);
                }
            }
            //cs.registerOutparameter(2,oracle.jdbc.OracleTypes.CURSOR);
            if(outparameters!=null)
            {
                for(int i=0;i<outparameters.length;i++)
                {
                    cs.registerOutParameter(inparameters.length+1+i,outparameters[i]);
                }
            }
            cs.execute();
        }
        catch(Exception e) {
            e.printStackTrace(); throw new RuntimeException(e.getMessage());
        }
        finally
        {

        }
        return cs;
    }

    /**
     *
     * @param sql
     * @param parameters
     * @return
     * @author Cally
     * @date 2017-8-27 上午10:32:00
     * @Description
     * @return ResultSet
     */
    public static ArrayList<Object[]> executeQuery(String sql,String[] parameters)
    {
        ArrayList<Object[]> list = null;
        try
        {
            ct=getConnection();
            ps=ct.prepareStatement(sql);
            if(parameters!=null)
            {
                for(int i=0;i<parameters.length;i++)
                {
                    ps.setString(i+1,parameters[i]);
                }
            }
            rs = ps.executeQuery();

            //得到结果集（rs）的结构
            ResultSetMetaData rsmd = rs.getMetaData();


//            if(rs.getRow()!=0)
            list=new ArrayList<Object[]>();

            //通过rsmd可以得到该结果集有多少列
            int columnNum = rsmd.getColumnCount();

            //从rs中取出数据，并且封装到ArrayList中
            while (rs.next()) {

                Object []objects = new Object[columnNum];
                for(int i = 0; i < objects.length; i++) {
                    objects[i] = rs.getObject(i + 1);
                }

                list.add(objects);
            }
            return list;

        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        finally
        {
            close(rs, ps, ct);
        }
    }



    public static Connection getCt()
    {
        return ct;
    }
    public static PreparedStatement getPs()
    {
        return ps;
    }
    public static ResultSet getRs()
    {
        return rs;
    }


    public static void executeUpdate2(String[] sql,String[][] parameters)
    {
        try
        {
            ct = getConnection();
            ct.setAutoCommit(false);

            for(int i=0;i<sql.length;i++)
            {

                if(null!=parameters[i])
                {
                    ps = ct.prepareStatement(sql[i]);
                    for(int j=0;j<parameters[i].length;j++)
                    {
                        ps.setString(j+1,parameters[i][j]);
                    }
                    ps.executeUpdate();
                }

            }


            ct.commit();


        }catch (Exception e)
        {
            e.printStackTrace();
            try
            {
                ct.rollback();
            }
            catch (SQLException e1)
            {
                e1.printStackTrace();
            }
            throw  new RuntimeException(e.getMessage());
        }finally
        {
            close(rs,ps,ct);
        }

    }

    //先写一个update、delete、insert
    //sql格式：update 表名 set 字段名 =？where 字段=？
    //parameter神应该是（”abc“,23）
    public static void executeUpdate(String sql,String[] parameters)
    {
        try
        {
            ct=getConnection();
            ps = ct.prepareStatement(sql);
            if(parameters!=null)
            {
                for(int i=0;i<parameters.length;i++)
                {
                    ps.setString(i+1,parameters[i]);
                }

            }
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();//开发阶段
            //抛出异常
            //可以处理，也可以不处理
            throw new RuntimeException(e.getMessage());
        }
        finally
        {
            close(rs,ps,ct);
        }
    }

    public static void close(ResultSet rs,Statement ps,Connection ct)
    {
        //关闭资源(先开后关)
        if(rs!=null)
        {
            try
            {
                rs.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            rs=null;
        }
        if(ps!=null)
        {
            try
            {
                ps.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            ps=null;
        }
        if(null!=ct)
        {
            try
            {
                ct.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            ct=null;
        }
    }

    public static  List<Object> resultSetToList(ResultSet rs) throws java.sql.SQLException {
        if (rs == null)
            return Collections.emptyList();
        ResultSet md = (ResultSet) rs.getMetaData(); //得到结果集(rs)的结构信息，比如字段数、字段名等
        int columnCount = ((ResultSetMetaData) md).getColumnCount(); //返回此 ResultSet 对象中的列数
        List<Object> list = new ArrayList<Object>();
        Map<Object, Object> rowData = new HashMap<Object, Object>();
        while (rs.next()) {
            rowData = new HashMap<Object, Object>(columnCount);
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(((ResultSetMetaData) md).getColumnName(i), rs.getObject(i));
            }
            list.add(rowData);
        }
        return list;
    }
}
