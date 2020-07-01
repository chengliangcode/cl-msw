package com.cl.msw;

import com.cl.msw.module.system.user.mapper.MswUserMapper;
import com.cl.msw.module.system.user.pojo.po.MswUser;
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

}
