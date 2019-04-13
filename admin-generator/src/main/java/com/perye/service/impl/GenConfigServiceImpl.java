package com.perye.service.impl;

import com.perye.domain.GenConfig;
import com.perye.repository.GenConfigRepository;
import com.perye.service.GenConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: Perye
 * @Date: 2019-04-13
 */
@Service
public class GenConfigServiceImpl implements GenConfigService {

    @Autowired
    private GenConfigRepository genConfigRepository;

    @Override
    public GenConfig find() {
        Optional<GenConfig> genConfig = genConfigRepository.findById(1L);
        if(genConfig.isPresent()){
            return genConfig.get();
        } else {
            return new GenConfig();
        }
    }

    @Override
    public GenConfig update(GenConfig genConfig) {
        genConfig.setId(1L);
        return genConfigRepository.save(genConfig);
    }
}
