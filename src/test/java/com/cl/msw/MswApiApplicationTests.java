package com.cl.msw;

import com.cl.msw.component.constant.system.DeleteStateEnum;
import com.cl.msw.component.constant.system.EnableStateEnum;
import com.cl.msw.module.system.user.mapper.MswUserMapper;
import com.cl.msw.module.system.user.pojo.dto.MswUserDTO;
import com.cl.msw.module.system.user.pojo.po.MswUser;
import com.cl.msw.module.system.user.pojo.vo.MswUserDetailVO;
import com.cl.msw.module.system.user.service.MswUserService;
import com.cl.msw.util.common.MswEnumUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sun.security.provider.MD5;

import javax.annotation.Resource;

/**
 * Msw-单元测试-Tests
 *
 * @author chengliang
 * @date 2020/7/1 10:35
 */
@SpringBootTest
public class MswApiApplicationTests {

    @Resource
    JdbcTemplate jdbcTemplate;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Resource
    MswUserMapper mswUserMapper;

    @Resource
    MswUserService mswUserService;

    @Test
    void context() {
        System.out.println("my junit test");
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
            System.out.println(MswEnumUtils.desc(DeleteStateEnum.class, 1));
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
    }

    @Test
    void saveCopyTest() {
        MswUserDTO mswUserDTO = MswUserDTO.builder()
                .id(2L)
                .username("测试账号")
                .account("test")
                .password("123456")
                .email("714552682@qq.com")
                .phone("15079292031")
                .enableState(EnableStateEnum.ENABLE.getValue())
                .build();
        MswUserDetailVO mswUserDetailVO = mswUserService.save(null);
        try {
            String s = new ObjectMapper().writeValueAsString(mswUserDetailVO);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    void redisTest() {
        stringRedisTemplate.opsForValue().set("cl-msw", "test01");
        System.out.println(stringRedisTemplate.opsForValue().get("cl-msw"));
    }

    @Test
    void aa() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String admin = bCryptPasswordEncoder.encode("admin");
        System.out.println(admin);
        boolean b = bCryptPasswordEncoder.matches("admin", bCryptPasswordEncoder.encode("admin"));
        System.out.println(b);

    }

}
