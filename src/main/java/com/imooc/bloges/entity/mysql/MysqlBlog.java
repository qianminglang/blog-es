package com.imooc.bloges.entity.mysql;

import lombok.Data;

import javax.persistence.*;

/**
 * @author qml
 * @date 2020/2/1 0001 12:21
 * `id`  int(11) NOT NULL COMMENT '自增id' ,
 * `title`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客标题' ,
 * `author`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客作者' ,
 * `content`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '博客内容' ,
 * `create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
 * `update_time`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
 */
@Data
@Table(name = "t_blog")
@Entity
public class MysqlBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    @Column(columnDefinition = "mediumtext")
    private String content;
    private String createTime;
    private String updateTime;
}
