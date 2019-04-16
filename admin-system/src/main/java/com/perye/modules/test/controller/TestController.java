package com.perye.modules.test.rest;

import com.perye.aop.log.Log;
import com.perye.exception.BadRequestException;
import com.perye.modules.test.domain.Test;
import com.perye.modules.test.service.TestService;
import com.perye.modules.test.service.dto.TestDTO;
import com.perye.modules.test.service.query.TestQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* @author Perye
* @date 2019-04-16
*/
@RestController
@RequestMapping("api")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private TestQueryService testQueryService;

    private static final String ENTITY_NAME = "test";

    @Log("查询Test")
    @GetMapping(value = "/test")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getTests(TestDTO resources, Pageable pageable){
        return new ResponseEntity(testQueryService.queryAll(resources,pageable),HttpStatus.OK);
    }

    @Log("新增Test")
    @PostMapping(value = "/test")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody Test resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(testService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改Test")
    @PutMapping(value = "/test")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody Test resources){
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME +" ID Can not be empty");
        }
        testService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Test")
    @DeleteMapping(value = "/test/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id){
        testService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}