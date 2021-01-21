import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import utiles.JDBCUtiles02;
import utiles.domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用DBUtils工具类进行查询(自行封装结果集)
 */
public class Test08 {
    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtiles02.getDataSource());

        //查询一条记录
        Account account = queryRunner.query("select * from admin where userName = ?", new ResultSetHandler<Account>() {
            @Override
            public Account handle(ResultSet rs) throws SQLException {
                Account account = new Account();
                while (rs.next()){
                    account.setUserName(rs.getString("userName"));
                    account.setPassword(rs.getString("password"));
                }
                return account;
            }
        },"19604076");

        System.out.println(account.toString());

//        //查询多条记录
//        List<Account> list = queryRunner.query("select * from admin", new ResultSetHandler<List<Account>>() {
//            @Override
//            public List<Account> handle(ResultSet rs) throws SQLException {
//                List<Account> list = new ArrayList<Account>();
//
//                while (rs.next()){
//                    Account account = new Account();
//                    account.setUserName(rs.getString("userName"));
//                    account.setPassword(rs.getString("password"));
//                    list.add(account);
//                }
//                return list;
//            }
//        });
//
//        for (Account account : list){
//            System.out.println(account);
//        }
    }
}
