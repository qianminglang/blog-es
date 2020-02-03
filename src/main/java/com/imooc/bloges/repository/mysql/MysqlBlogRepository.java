package com.imooc.bloges.repository.mysql;

import com.imooc.bloges.entity.mysql.MysqlBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author qml
 * @date 2020/2/1 0001 12:29
 */
public interface MysqlBlogRepository extends JpaRepository<MysqlBlog,Integer> {
    @Query("select e from MysqlBlog e order by e.createTime desc ")
    List<MysqlBlog> queryAll();

    @Query("select e from MysqlBlog e where e.content like concat('%',:keyword,'%') or e.title " +
            "like concat('%',:keyword,'%') ")
    List<MysqlBlog> queryBlogs(@Param("keyword")String keyword);
}
