package com.perye.modules.system.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Perye
 * @Date: 2019-04-13
 */
@Data
public class DictDTO implements Serializable {

    private Long id;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 描述
     */
    private String remark;
}
