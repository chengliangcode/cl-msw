package com.cl.msw.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * MybatisPlus的生成器
 *
 * @author chengliang
 * @date 2020/7/1 16:13
 */
public class MswAutoGenerator {

    public static void main(String[] args) {
        String module = "system.user2";
        String table = "msw_user";
        String author = "chengliang";
        MswAutoGenerator.generator(module, table, author);
    }

    public static void generator(String module, String table, String author) {
        MswAutoGenerator msw = new MswAutoGenerator();
        AutoGenerator generator = new AutoGenerator()
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .setCfg(msw.injectionConfig(module))
                .setTemplate(msw.templateConfig())
                .setGlobalConfig(msw.globalConfig(author))
                .setDataSource(msw.dataSourceConfig())
                .setPackageInfo(msw.packageConfig(module))
                .setStrategy(msw.strategyConfig(table));
        generator.execute();
        List<TableInfo> tableInfoList = generator.getConfig().getTableInfoList();
        System.out.println(tableInfoList.toString());
    }

    private StrategyConfig strategyConfig(String table) {
        StrategyConfig s = new StrategyConfig();
        //【实体】是否生成字段常量（默认 false）
        s.setEntityColumnConstant(true);
        //【实体】是否为lombok模型（默认 false）
        s.setEntityLombokModel(true);
        //【实体】是否为构建者模型（默认 false）
        s.setEntityBuilderModel(false);
        //生成 @RestController 控制器
        s.setRestControllerStyle(true);
        //Boolean类型字段是否移除is前缀（默认 false）
        s.setEntityTableFieldAnnotationEnable(true);
        //数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        s.setColumnNaming(NamingStrategy.underline_to_camel);
        //数据库表映射到实体的命名策略
        s.setNaming(NamingStrategy.underline_to_camel);
        //表前缀
        String[] split = table.split(",");
        if (split.length > 1) {
            s.setInclude(split);
        } else {
            s.setInclude(table);
        }
        return s;
    }

    private GlobalConfig globalConfig(String author) {
        GlobalConfig g = new GlobalConfig();
        g.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        g.setAuthor(author);
        //是否打开输出目录
        g.setOpen(false);
        g.setSwagger2(false);
        //是否覆盖已有文件
        g.setFileOverride(false);
        //时间类型对应策略
        g.setDateType(DateType.TIME_PACK);
        g.setIdType(IdType.UUID);
        g.setServiceName("%sService");
        g.setMapperName("%sMapper");
        g.setBaseResultMap(false);
        g.setBaseColumnList(false);
        return g;
    }

    private DataSourceConfig dataSourceConfig() {
        DataSourceConfig d = new DataSourceConfig();
        d.setUrl("jdbc:mysql://cl-mysql.mysql.rds.aliyuncs.com:3306/msw_dev");
        d.setDriverName("com.mysql.cj.jdbc.Driver");
        d.setUsername("msw_dev1");
        d.setPassword("msw_dev1");
        d.setDbType(DbType.MYSQL);
        d.setDbQuery(new MySqlQuery());
        d.setTypeConvert(new MySqlTypeConvert());
        return d;
    }

    private PackageConfig packageConfig(String module) {
        PackageConfig p = new PackageConfig();
        p.setParent("com.cl.msw.module".concat(".").concat(module));
        p.setController(p.getController());
        p.setServiceImpl(p.getServiceImpl());
        p.setService(p.getService());
        p.setEntity("pojo.po");
        p.setMapper("mapper");
        p.setXml(null);
        return p;
    }

    private InjectionConfig injectionConfig(String module) {
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return System.getProperty("user.dir") + "/src/main/resources/mapper/" + module.replace(".", "/")
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    private TemplateConfig templateConfig() {
        TemplateConfig t = new TemplateConfig();
        t.setXml(null);
//        t.setController(null);
//        t.setServiceImpl(null);
//        t.setService(null);
        return t;
    }
}
