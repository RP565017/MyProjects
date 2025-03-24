package com.javalife.microservices.product.model;

import org.springframework.stereotype.Component;

@Component
public class ErrorResponse {

    private static final String DEFAULT_TYPE_MESSAGE_CODE = "error.default.type";
    private static final String DEFAULT_TITLE_MESSAGE_CODE = "error.default.title";
    private static final String DEFAULT_DETAIL_MESSAGE_CODE = "error.default.detail";

    public enum TypeEnum {
        ERROR("error"),
        WARNING("warning"),
        INFO("info");

        private final String value;

        TypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }

        public static TypeEnum fromValue(String value) {
            for (TypeEnum errorCode : TypeEnum.values()) {
                if (errorCode.getValue().equals(value)) {
                    return errorCode;
                }
            }
            return null;
        }
    }
}
