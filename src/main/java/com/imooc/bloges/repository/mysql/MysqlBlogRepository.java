package com.imooc.bloges.repository.mysql;

import com.imooc.bloges.entity.mysql.MysqlBlog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author qml
 * @date 2020/2/1 0001 12:29
 */
public interface MysqlBlogRepository extends JpaRepository<MysqlBlog,Integer> {

}
