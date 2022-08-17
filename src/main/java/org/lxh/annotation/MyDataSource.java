package org.lxh.annotation;

import org.lxh.dataSource.DataSourceName;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @MyDataSource annotation can be added to a Service layer method or class,indicate datasource by value
 * 此注解用在service类或者方法，通过value属性指定数据源
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface MyDataSource {
    String value() default DataSourceName.DEFAULT_DS_NAME;
}
