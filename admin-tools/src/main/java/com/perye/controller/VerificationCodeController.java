package com.perye.controller;

import com.perye.domain.VerificationCode;
import com.perye.domain.vo.EmailVo;
import com.perye.service.EmailService;
import com.perye.service.VerificationCodeService;
import com.perye.utils.AdminConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Perye
 * @Date: 2019-04-13
 */
@RestController
@RequestMapping("api")
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/code/resetEmail")
    public ResponseEntity resetEmail(@RequestBody VerificationCode code) throws Exception {
        code.setScenes(AdminConstant.RESET_MAIL);
        EmailVo emailVo = verificationCodeService.sendEmail(code);
        emailService.send(emailVo,emailService.find());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/code/email/resetPass")
    public ResponseEntity resetPass(@RequestParam String email) throws Exception {
        VerificationCode code = new VerificationCode();
        code.setType("email");
        code.setValue(email);
        code.setScenes(AdminConstant.RESET_MAIL);
        EmailVo emailVo = verificationCodeService.sendEmail(code);
        emailService.send(emailVo,emailService.find());
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/code/validated")
    public ResponseEntity validated(VerificationCode code){
        verificationCodeService.validated(code);
        return new ResponseEntity(HttpStatus.OK);
    }
}

