import org.apache.commons.dbutils.QueryRunner;
import utiles.JDBCUtiles02;

import java.sql.SQLException;

/**
 * BDUtils实现增删改
 *
 */
public class Test07 {
    public static void main(String[] args) {
        QueryRunner queryRunner = new QueryRunner(JDBCUtiles02.getDataSource());

        //添加
//        try {
//            queryRunner.update("insert into admin values (?,?)","你爸爸是我","123456");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

        //删除
//        try {
//            queryRunner.update("delete from admin where userName = ?","你爸爸是我");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

        //修改
        try {
            queryRunner.update("update admin set password = ? where userName = ?","123","19604076");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
