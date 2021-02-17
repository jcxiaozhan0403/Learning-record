import jdk.swing.interop.SwingInterOpUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import utiles.JDBCUtiles02;
import utiles.domain.Account;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 使用DBUtils工具类进行查询(使用ResultSetHandler的实现类)
 *
 */
public class Test09 {
    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtiles02.getDataSource());

        //ArrayHandler：将一条记录封装到一个Object数组中
//        Object[] objs = queryRunner.query("select * from admin where userName = ?",new ArrayHandler(),"19604076");
//        System.out.println(Arrays.toString(objs));

        //ArrayListHandler：将多条记录封装到一个装有Object数组的List集合中
        //一条记录装进一个Object对象中
//        List<Object[]> list = queryRunner.query("select * from admin",new ArrayListHandler());
//        for (Object[] objects : list){
//            System.out.println(Arrays.toString(objects));
//        }

        //BeanHandler(开发常用)：将一条记录封装到一个JavaBean中
//        Account account = queryRunner.query("select * from admin where userName = ?",new BeanHandler<Account>(Account.class),"19604076");
//        System.out.println(account);

        //BeanListHandler(开发常用)：将多条记录封装到一个装有JavaBean的List集合中
        //一条记录装进一个JavaBean对象中
//        List<Account> list = queryRunner.query("select * from admin",new BeanListHandler<Account>(Account.class));
//        for (Account account : list){
//            System.out.println(account);
//        }

        //MapHandler：将一条记录封装到一个Map集合中，Map的key是列名，Map的value是列对应的记录值
//        Map<String,Object> map = queryRunner.query("select * from admin where userName = ?",new MapHandler(),"19604076");
//        System.out.println(map);

        //MapListHandler：将多条记录封装到一个装有Map的List集合中
//        List<Map<String,Object>> list = queryRunner.query("select * from admin",new MapListHandler());
//        for (Map<String,Object> map : list){
//            System.out.println(map);
//        }

        //ColumnListHandler：将某列的值封装到List集合中
//        List<Object> list = queryRunner.query("select userName from admin",new ColumnListHandler("userName"));
//        for (Object object : list){
//            System.out.println(object);
//        }

        //ScalarHandler：单值封装
//        Object obj = queryRunner.query("select count(*) from admin",new ScalarHandler());
//        System.out.println(obj);

        //KeyedHandler(不常用，了解即可)：将一条记录装入一个Map集合中，将多个Map集合装入一个新Map集合中，新Map集合的Key可指定
        Map<Object,Map<String,Object>> map = queryRunner.query("select * from admin",new KeyedHandler("userName"));
        for (Object key : map.keySet()){
            System.out.println(key + "" + map.get(key));
        }

    }
}
