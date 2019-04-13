package com.perye.modules.monitor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Perye
 * @Date: 2019-04-13
 */
@Data
@AllArgsConstructor
public class LogMessage {

    private String body;
    private String timestamp;
    private String threadName;
    private String className;
    private String level;
}
