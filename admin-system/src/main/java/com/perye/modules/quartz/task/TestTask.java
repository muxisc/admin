package com.perye.modules.quartz.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 测试
 * @Author: Perye
 * @Date: 2019-04-13
 */
@Slf4j
@Component
public class TestTask {

    public void run(){
        log.info("执行成功");
    }

    public void run1(String str){
        log.info("执行成功，参数为： {}" + str);
    }

    public void test(String num) {
        log.info("编号:"+num+"定时任务,每5秒执行一次");
    }
}
