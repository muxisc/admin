package com.perye.modules.system.service.mapper;

import com.perye.mapper.EntityMapper;
import com.perye.modules.system.entity.Permission;
import com.perye.modules.system.service.dto.PermissionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @Author: Perye
 * @Date: 2019-04-13
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionMapper extends EntityMapper<PermissionDTO, Permission> {

}
