package com.imooc.bloges.repository.es;

import com.imooc.bloges.entity.es.EsBlog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author qml
 * @date 2020/2/1 0001 15:04
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,Integer> {
}
