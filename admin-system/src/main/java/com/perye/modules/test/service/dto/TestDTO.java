package com.perye.modules.test.service.dto;

import lombok.Data;
import java.io.Serializable;

/**
* @author Perye
* @date 2019-04-14
*/
@Data
public class TestDTO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 测试列1
     */
    private String col1;

    /**
     * 测试列2
     */
    private String col2;

    /**
     * 测试列3
     */
    private String col3;

    /**
     * 测试列4
     */
    private String col4;

    /**
     * 测试列5
     */
    private String col5;

    /**
     * 测试列6
     */
    private String col6;

    /**
     * 测试列7
     */
    private String col7;
}