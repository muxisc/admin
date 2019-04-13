package com.perye.modules.quartz.service;

import com.perye.modules.quartz.entity.QuartzJob;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @Author: Perye
 * @Date: 2019-04-13
 */
@CacheConfig(cacheNames = "quartzJob")
public interface QuartzJobService {

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    QuartzJob create(QuartzJob resources);

    /**
     * update
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    void update(QuartzJob resources);

    /**
     * del
     * @param quartzJob
     */
    @CacheEvict(allEntries = true)
    void delete(QuartzJob quartzJob);

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    QuartzJob findById(Long id);

    /**
     * 更改定时任务状态
     * @param quartzJob
     */
    @CacheEvict(allEntries = true)
    void updateIsPause(QuartzJob quartzJob);

    /**
     * 立即执行定时任务
     * @param quartzJob
     */
    void execution(QuartzJob quartzJob);
}