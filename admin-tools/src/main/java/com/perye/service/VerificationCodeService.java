package com.perye.service;

import com.perye.domain.VerificationCode;
import com.perye.domain.vo.EmailVo;

/**
 * @Author: Perye
 * @Date: 2019-04-13
 */
public interface VerificationCodeService {

    /**
     * 发送邮件验证码
     * @param code
     */
    EmailVo sendEmail(VerificationCode code);

    /**
     * 验证
     * @param code
     */
    void validated(VerificationCode code);
}
