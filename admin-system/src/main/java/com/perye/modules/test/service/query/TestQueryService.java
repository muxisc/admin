package com.perye.modules.test.service.query;

import com.perye.utils.PageUtil;
import com.perye.modules.test.domain.Test;
import com.perye.modules.test.service.dto.TestDTO;
import com.perye.modules.test.repository.TestRepository;
import com.perye.modules.test.service.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
* @author Perye
* @date 2019-04-16
 */
@Service
@CacheConfig(cacheNames = "test")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TestQueryService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestMapper testMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(TestDTO test, Pageable pageable){
        Page<Test> page = testRepository.findAll(new Spec(test),pageable);
        return PageUtil.toPage(page.map(testMapper::toDto));
    }

    /**
    * 不分页
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(TestDTO test){
        return testMapper.toDto(testRepository.findAll(new Spec(test)));
    }

    class Spec implements Specification<Test> {

        private TestDTO test;

        public Spec(TestDTO test){
            this.test = test;
        }

        @Override
        public Predicate toPredicate(Root<Test> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if(!ObjectUtils.isEmpty(test.getId())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("id").as(Long.class),test.getId()));
            }
            if(!ObjectUtils.isEmpty(test.getName())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("name").as(String.class),"%"+test.getName()+"%"));
            }
            if(!ObjectUtils.isEmpty(test.getJixiao())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("jixiao").as(String.class),"%"+test.getJixiao()+"%"));
            }
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
        }
    }
}