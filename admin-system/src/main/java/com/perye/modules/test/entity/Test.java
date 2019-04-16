package com.perye.modules.test.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
* @author Perye
* @date 2019-04-16
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
     * 姓名
     */
    @Column(name = "name",nullable = false)
    private String name;

    /**
     * 绩效
     */
    @Column(name = "jixiao",nullable = false)
    private String jixiao;
}