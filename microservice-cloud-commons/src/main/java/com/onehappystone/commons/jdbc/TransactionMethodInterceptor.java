package com.onehappystone.commons.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * Created by happy on 2017/7/3.
 * 默认走读库优先
 */
@Component
@Slf4j
public class TransactionMethodInterceptor implements MethodInterceptor{
    @Override
    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //获取bean上的事物注解属性
        Transactional beanTransactional = proxy.getClass().getAnnotation(Transactional.class);
        //获取方法上的事物注解属性
        Transactional methodTransactional = method.getAnnotation(Transactional.class);
        Boolean isReadOnly = (methodTransactional != null && methodTransactional.readOnly()) || (beanTransactional != null && beanTransactional.readOnly());
        if (isReadOnly){
            if (log.isDebugEnabled()){
                log.debug("This class is {}, method is {},Transactional is {}!", proxy.getClass().getCanonicalName(), method.getName(), isReadOnly);
            }
            DynamicDataSource.setReadOnly();
        }else{
            if (log.isDebugEnabled()){
                log.debug("This class is {}, method is {},Transactional is {}!", proxy.getClass().getCanonicalName(), method.getName(), isReadOnly);
            }
            DynamicDataSource.setReadWrite();
        }
        try{
            Object object = methodProxy.invoke(proxy, objects);
            return object;
        }finally {
            DynamicDataSource.setReadOnly();
        }
    }
}
