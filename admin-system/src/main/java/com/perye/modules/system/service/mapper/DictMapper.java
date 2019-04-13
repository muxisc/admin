package com.perye.modules.system.service.mapper;

import com.perye.mapper.EntityMapper;
import com.perye.modules.system.entity.Dict;
import com.perye.modules.system.service.dto.DictDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @Author: Perye
 * @Date: 2019-04-13
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends EntityMapper<DictDTO, Dict> {

}