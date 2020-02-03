package com.imooc.bloges;

import com.imooc.bloges.entity.es.EsBlog;
import com.imooc.bloges.repository.es.EsBlogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;

@SpringBootTest
class BlogEsApplicationTests {
    
    @Autowired
    EsBlogRepository esBlogRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void esTest(){
        Iterable<EsBlog> all = esBlogRepository.findAll();
        Iterator<EsBlog> iterator = all.iterator();
        EsBlog next = iterator.next();
        System.out.println(next);
    }
}
