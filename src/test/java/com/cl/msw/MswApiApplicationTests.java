package com.cl.msw;

import com.cl.msw.component.constant.DeletedEnum;
import com.cl.msw.module.system.user.mapper.MswUserMapper;
import com.cl.msw.module.system.user.pojo.po.MswUser;
import com.cl.msw.util.common.MswEnumUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 单元测试
 *
 * @author chengliang
 * @date 2020/7/1 10:35
 */
@SpringBootTest
public class MswApiApplicationTests {

    @Resource
    JdbcTemplate jdbcTemplate;

    @Resource
    MswUserMapper mswUserMapper;

    @Test
    void context() {
        System.out.println("my junit test");
    }

    @Test
    void datasourceTest() {
        String sql = " select * from msw_user where id = 1";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql);
        System.out.println(stringObjectMap.toString());
    }

    @Test
    void mapperTest() {
        MswUser mswUser = mswUserMapper.selectByPrimaryKey("1");
        System.out.println(mswUser.toString());
    }

    @Test
    void enumTest() {
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        for (int i = 0; i < 100; i++) {
            System.out.println(MswEnumUtil.desc(DeletedEnum.class, 1));
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
    }

}
