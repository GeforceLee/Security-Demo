package com.geforce.security.core.validate.code;

import com.geforce.security.core.properties.SecurityConstants;

/**
 * @author geforce
 * @date 2017/11/14
 */
public enum ValidateCodeType {

    SMS {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },

    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };


    public abstract String getParamNameOnValidate();
}
