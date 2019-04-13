package com.perye.modules.system.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Perye
 * @Date: 2019-04-13
 */
@Data
public class DictDetailDTO implements Serializable {

    private Long id;

    /**
     * 字典标签
     */
    private String label;

    /**
     * 字典值
     */
    private String value;

    /**
     * 排序
     */
    private String sort;

    /**
     * 字典id
     */
    private String dictName;
}
