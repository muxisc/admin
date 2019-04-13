package com.perye.service;

import com.perye.domain.GenConfig;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @Author: Perye
 * @Date: 2019-04-13
 */
@CacheConfig(cacheNames = "genConfig")
public interface GenConfigService {

    /**
     * find
     * @return
     */
    @Cacheable(key = "'1'")
    GenConfig find();

    /**
     * update
     * @param genConfig
     */
    @CachePut(key = "'1'")
    GenConfig update(GenConfig genConfig);
}
