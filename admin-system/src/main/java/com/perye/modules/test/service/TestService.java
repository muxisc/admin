package com.perye.modules.test.service;

import com.perye.modules.test.domain.Test;
import com.perye.modules.test.service.dto.TestDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
* @author Perye
* @date 2019-04-14
*/
@CacheConfig(cacheNames = "test")
public interface TestService {

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    TestDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    TestDTO create(Test resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(Test resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}