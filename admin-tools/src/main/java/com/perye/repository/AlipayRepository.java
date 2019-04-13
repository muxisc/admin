package com.perye.repository;

import com.perye.entity.AlipayConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Perye
 * @Date: 2019-04-13
 */
public interface AlipayRepository extends JpaRepository<AlipayConfig,Long> {
}
