package com.perye.modules.test.service.mapper;

import com.perye.mapper.EntityMapper;
import com.perye.modules.test.domain.Test;
import com.perye.modules.test.service.dto.TestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Perye
* @date 2019-04-16
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TestMapper extends EntityMapper<TestDTO, Test> {

}