package com.perye.modules.system.service.mapper;

import com.perye.mapper.EntityMapper;
import com.perye.modules.system.entity.DictDetail;
import com.perye.modules.system.service.dto.DictDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @Author: Perye
 * @Date: 2019-04-13
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDetailMapper extends EntityMapper<DictDetailDTO, DictDetail> {

}