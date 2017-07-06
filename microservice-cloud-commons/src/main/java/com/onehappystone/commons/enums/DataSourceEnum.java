package com.onehappystone.commons.enums;

/**
 * Created by happy on 2017/7/3.
 */
public enum  DataSourceEnum {
    READ_ONLY("readDataSource"),READ_WRITE("read_writeDataSource");
    String value;

    DataSourceEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
