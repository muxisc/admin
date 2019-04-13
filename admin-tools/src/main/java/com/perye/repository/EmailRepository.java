package com.perye.repository;

import com.perye.domain.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Perye
 * @Date: 2019-04-13
 */
public interface EmailRepository extends JpaRepository<EmailConfig,Long> {
}
