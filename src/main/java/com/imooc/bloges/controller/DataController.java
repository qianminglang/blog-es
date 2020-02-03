package com.imooc.bloges.controller;

import com.imooc.bloges.entity.es.EsBlog;
import com.imooc.bloges.entity.mysql.MysqlBlog;
import com.imooc.bloges.repository.es.EsBlogRepository;
import com.imooc.bloges.repository.mysql.MysqlBlogRepository;
import lombok.Data;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author qml
 * @date 2020/2/1 0001 15:16
 */
@RestController
public class DataController {
    @Autowired
    MysqlBlogRepository mysqlBlogRepository;

    @Autowired
    EsBlogRepository esBlogRepository;

    @GetMapping("/blogs")
    public Object blogList(){
        List<MysqlBlog> mysqlBlogs = mysqlBlogRepository.queryAll();
        return mysqlBlogs;
    }

    @PostMapping
    public Object search(@RequestParam Param param){
        Map map =new HashMap();
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        String type = param.getType();
        if (type.equalsIgnoreCase("mysql")){
            mysqlBlogRepository.queryBlogs(param.getKeyWord());
        }else if(type.equalsIgnoreCase("es")){
            BoolQueryBuilder builder = QueryBuilders.boolQuery();
            builder.should(QueryBuilders.matchPhraseQuery("title", param.getKeyWord()));
            builder.should(QueryBuilders.matchPhraseQuery("content", param.getKeyWord()));
            String s = builder.toString();
            System.out.println(s);
            Page<EsBlog> search = (Page<EsBlog>) esBlogRepository.search(builder);
            List<EsBlog> content = search.getContent();
            map.put("list", content);
        }else {
            return "i do not understand";
        }
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        map.put("duration", totalTimeMillis);
        return map;
    }

    @GetMapping("/blog/{id}")
    public Object blog(@PathVariable Integer id){
        Optional<MysqlBlog> byId = mysqlBlogRepository.findById(id);
        return byId.get();
    }

    @Data
    public static class Param{
        private String type;
        private String keyWord;
    }
}



