package com.cl.msw;

import com.cl.msw.component.constant.system.DeletedEnum;
import com.cl.msw.component.constant.system.EnableEnum;
import com.cl.msw.module.system.user.mapper.MswUserMapper;
import com.cl.msw.module.system.user.pojo.dto.MswUserDTO;
import com.cl.msw.module.system.user.pojo.po.MswUser;
import com.cl.msw.module.system.user.pojo.vo.MswUserDetailVO;
import com.cl.msw.module.system.user.service.MswUserService;
import com.cl.msw.module.system.user.service.impl.MswUserServiceImpl;
import com.cl.msw.util.common.MswEnumUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

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
            System.out.println(MswEnumUtils.desc(DeletedEnum.class, 1));
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
                .enable(EnableEnum.ENABLE.getValue())
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

    public static void main(String[] args) {

        MswUserService mswUserService = new MswUserServiceImpl();

        MswUserService mswUserServiceProxy = (MswUserService) Proxy.newProxyInstance(MswUserServiceImpl.class.getClassLoader(), MswUserServiceImpl.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始事务");
                Object invoke = method.invoke(mswUserService, args);
                System.out.println("提交事务");
                return invoke;
            }
        });
    }

}
