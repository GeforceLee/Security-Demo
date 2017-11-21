package com.geforce.security.core.validate.code;

import com.geforce.security.core.properties.SecurityProperties;
import com.geforce.security.core.validate.code.image.ImageCodeGenerator;
import com.geforce.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.geforce.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 验证码相关的扩展点配置.配置在这里的Bean,业务系统都可通过声明同类型的Bean来覆盖安全模块
 * 默认的配置
 *
 *
 * @author geforce
 * @date 2017/11/10
 */
@Configuration
public class ValidateCodeBeanConfig {
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 图片验证码图片生成器
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }


    /**
     * 图片验证码发送器
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender(){
        return new DefaultSmsCodeSender();
    }

}
