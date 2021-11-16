package util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

//mybatis—plus基本代码生成
public class MyCode {
    public static void main(String[] args) {
        //创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //配置策略
        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String s = System.getProperty("user.dir");//获取当前用户路径
        gc.setOutputDir(s+"/src/main/java");//生成目录
        gc.setAuthor("yuan点");//作者名字
        gc.setOpen(false);//是否打开工作
        gc.setFileOverride(true);//是否覆盖生成
        gc.setServiceImplName("%sService");//去Service的I前缀
        gc.setIdType(IdType.AUTO);//主键自增
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/zxjy?serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //3、包的配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("huadi");
        pc.setParent("cn.com");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("collect");
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//下划线转驼峰
        strategy.setEntityLombokModel(true);//自动Lombok
        mpg.setStrategy(strategy);



        mpg.execute();
    }
}
