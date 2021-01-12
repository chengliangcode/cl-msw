package com.cl.code.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chengliang
 * @date 2021/1/5 14:46
 */
@SpringBootApplication
public class SecurityMain {

    public static void main(String[] args) {
        SpringApplication.run(SecurityMain.class, args);
/*        ArrayList<URL> u = new ArrayList<>();
        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("META-INF/spring.factories");
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                u.add(url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<URL> collect = u.stream().sorted(Comparator.comparing(URL::getPath)).collect(Collectors.toList());
        collect.forEach(System.out::println);*/

/*        List<String> strings = SpringFactoriesLoader.loadFactoryNames(ApplicationListener.class, null);
        strings.sort(String::compareTo);
        strings.forEach(System.out::println);*/

    }
}