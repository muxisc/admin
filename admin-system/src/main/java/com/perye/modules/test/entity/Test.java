package com.perye.modules.test.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
* @author Perye
* @date 2019-04-14
*/
@Entity
@Data
@Table(name="test")
public class Test implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 测试列1
     */
    @Column(name = "col1",nullable = false)
    private String col1;

    /**
     * 测试列2
     */
    @Column(name = "col2")
    private String col2;

    /**
     * 测试列3
     */
    @Column(name = "col3")
    private String col3;

    /**
     * 测试列4
     */
    @Column(name = "col4",nullable = false)
    private String col4;

    /**
     * 测试列5
     */
    @Column(name = "col5")
    private String col5;

    /**
     * 测试列6
     */
    @Column(name = "col6",nullable = false)
    private String col6;

    /**
     * 测试列7
     */
    @Column(name = "col7",nullable = false)
    private String col7;
}