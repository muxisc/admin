package com.perye.modules.system.repository;

import com.perye.modules.system.entity.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: Perye
 * @Date: 2019-04-13
 */
public interface DictRepository extends JpaRepository<Dict, Long>, JpaSpecificationExecutor {
}
