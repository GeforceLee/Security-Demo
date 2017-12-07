package com.geforce.security.app.social;

import com.geforce.security.core.properties.SecurityConstants;
import com.geforce.security.core.social.support.GeforceSpringSocialConfigurer;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author geforce
 * @date 2017/12/5
 */
@Component
public class SpringSocialConfigurerPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (StringUtils.equals(beanName,"geforceSocialSecurityConfig")) {
            GeforceSpringSocialConfigurer configurer = (GeforceSpringSocialConfigurer) bean;
            configurer.signupUrl(SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL);
            return configurer;
        }
        return bean;
    }
}
