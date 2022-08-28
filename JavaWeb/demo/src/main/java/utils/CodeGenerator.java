package utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author John.Cena
 * @date 2022/8/28 9:46
 * @Description:
 */
public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatis_plus?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8", "root", "lishuang001219")
                .globalConfig(builder -> {
                    builder.author("John.Cena") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式，这里开启的是对swagger2的支持
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(".\\src\\main\\java"); // 指定输出到项目路径下
                })
                .packageConfig(builder -> {
                    builder.parent("com") // 设置父包名
                            .moduleName("generator"); // 设置父包模块名
//                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("tb_user") // 设置需要生成的表名
                            .addTablePrefix("tb_", "c_"); // 设置过滤表前缀
                })
                //使用freemark引擎要引入freemark的依赖
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
