package com.perye.modules.test.repository;

import com.perye.modules.test.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author Perye
* @date 2019-04-16
*/
public interface TestRepository extends JpaRepository<Test, Long>, JpaSpecificationExecutor {
}