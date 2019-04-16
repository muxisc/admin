package com.perye.modules.test.service.dto;

import lombok.Data;
import java.io.Serializable;

/**
* @author Perye
* @date 2019-04-16
*/
@Data
public class TestDTO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 绩效
     */
    private String jixiao;
}