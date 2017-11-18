package com.geforce.security.core.social;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author geforce
 * @date 2017/11/17
 */
public class GeforceMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {


    public GeforceMappingJackson2HttpMessageConverter() {
        super();
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        setSupportedMediaTypes(supportedMediaTypes);
    }

}
