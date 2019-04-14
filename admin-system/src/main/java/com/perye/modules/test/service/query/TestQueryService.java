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
* @date 2019-04-14
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
            if(!ObjectUtils.isEmpty(test.getCol1())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("col1").as(String.class),"%"+test.getCol1()+"%"));
            }
            if(!ObjectUtils.isEmpty(test.getCol2())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("col2").as(String.class),"%"+test.getCol2()+"%"));
            }
            if(!ObjectUtils.isEmpty(test.getCol3())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("col3").as(String.class),"%"+test.getCol3()+"%"));
            }
            if(!ObjectUtils.isEmpty(test.getCol4())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("col4").as(String.class),"%"+test.getCol4()+"%"));
            }
            if(!ObjectUtils.isEmpty(test.getCol5())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("col5").as(String.class),"%"+test.getCol5()+"%"));
            }
            if(!ObjectUtils.isEmpty(test.getCol6())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("col6").as(String.class),"%"+test.getCol6()+"%"));
            }
            if(!ObjectUtils.isEmpty(test.getCol7())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("col7").as(String.class),"%"+test.getCol7()+"%"));
            }
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
        }
    }
}