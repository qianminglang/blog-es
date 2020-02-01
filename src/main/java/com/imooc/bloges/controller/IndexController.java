package com.imooc.bloges.controller;

import com.imooc.bloges.entity.mysql.MysqlBlog;
import com.imooc.bloges.repository.mysql.MysqlBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author qml
 * @date 2020/2/1 0001 12:31
 */
@Controller
public class IndexController {
    @Autowired
    private MysqlBlogRepository mysqlBlogRepository;
    
    @RequestMapping("/")
    public String index(){
        List<MysqlBlog> all = mysqlBlogRepository.findAll();
        System.out.println(all);
        return "index.html";
    }
}
