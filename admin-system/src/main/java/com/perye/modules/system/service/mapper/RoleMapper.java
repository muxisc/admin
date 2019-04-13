package com.perye.modules.system.service.mapper;

import com.perye.mapper.EntityMapper;
import com.perye.modules.system.entity.Role;
import com.perye.modules.system.service.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @Author: Perye
 * @Date: 2019-04-13
 */
@Mapper(componentModel = "spring", uses = {PermissionMapper.class, MenuMapper.class, DeptMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends EntityMapper<RoleDTO, Role> {

}
