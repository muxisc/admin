package com.perye.modules.test.service.impl;

import com.perye.modules.test.domain.Test;
import com.perye.utils.ValidationUtil;
import com.perye.modules.test.repository.TestRepository;
import com.perye.modules.test.service.TestService;
import com.perye.modules.test.service.dto.TestDTO;
import com.perye.modules.test.service.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
* @author Perye
* @date 2019-04-14
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestMapper testMapper;

    @Override
    public TestDTO findById(Long id) {
        Optional<Test> test = testRepository.findById(id);
        ValidationUtil.isNull(test,"Test","id",id);
        return testMapper.toDto(test.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TestDTO create(Test resources) {
        return testMapper.toDto(testRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Test resources) {
        Optional<Test> optionalTest = testRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalTest,"Test","id",resources.getId());

        Test test = optionalTest.get();
        // 此处需自己修改
        resources.setId(test.getId());
        testRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        testRepository.deleteById(id);
    }
}