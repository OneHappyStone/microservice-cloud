package com.onehappystone.commons.jdbc;

import com.onehappystone.commons.enums.DataSourceEnum;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by happy on 2017/7/3.
 */
public class DynamicDataSource extends AbstractRoutingDataSource{

    private static final ThreadLocal<String> DATASOURCE_KEY_HOLDER = new ThreadLocal<>();

    public static void setReadOnly(){
        DATASOURCE_KEY_HOLDER.set(DataSourceEnum.READ_ONLY.getValue());
    }

    public static void setReadWrite(){
        DATASOURCE_KEY_HOLDER.set(DataSourceEnum.READ_WRITE.getValue());
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DATASOURCE_KEY_HOLDER.get();
    }
}
