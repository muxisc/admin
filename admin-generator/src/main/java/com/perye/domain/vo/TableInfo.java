package com.perye.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表的数据信息
 *
 * @Author: Perye
 * @Date: 2019-04-13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableInfo {

    /**
     * 表名称
     **/
    private Object tableName;

    /**
     * 创建日期
     **/
    private Object createTime;
}


