package org.lxh.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.lxh.annotation.MyDataSource;
import org.lxh.dataSource.DynamicDataSourceContextHolder;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class DataSourceAspect {

    /**
     * @annotation(org.lxh.annotation.MyDataSource)
     *  intercept method with @MyDataSource
     *      拦截有DataSource注解的方法
     *  @within(org.lxh.annotation.MyDataSource)
     *      intercept class with @MyDataSource
     */
    @Pointcut("@annotation(org.lxh.annotation.MyDataSource) || @within(org.lxh.annotation.MyDataSource)")
    public void pointCut(){

    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        // get @MyDataSource annotation on class or method
        MyDataSource myDataSource = getDataSourceAnnotation(proceedingJoinPoint);
        if(myDataSource !=null){
            // get myDataSource name
            String value = myDataSource.value();
            DynamicDataSourceContextHolder.setDataSourceName(value);
        }
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }finally {
            DynamicDataSourceContextHolder.clearDataSourceName();
        }
        return null;
    }

    private MyDataSource getDataSourceAnnotation(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature signature = (MethodSignature)proceedingJoinPoint.getSignature();
        MyDataSource annotation = AnnotationUtils.findAnnotation(signature.getMethod(), MyDataSource.class);
        if(annotation != null){
            //find @MyDataSource on method
            return annotation;
        }
        return AnnotationUtils.findAnnotation(signature.getDeclaringType(), MyDataSource.class);//find @MyDataSource On Class
    }

}
