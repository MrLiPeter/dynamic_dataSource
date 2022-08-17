package org.lxh.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.lxh.dataSource.DataSourceName;
import org.lxh.dataSource.DynamicDataSource;
import org.lxh.dataSource.DynamicDataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
@Aspect
@Order(11)
public class GlobalDataSourceAspect {

    @Autowired
    HttpSession session;

    @Pointcut("execution(* org.lxh.service.*.*(..))")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp){
        DynamicDataSourceContextHolder.setDataSourceName((String)session.getAttribute(DataSourceName.DS_SESSION_KEY));
        try {
            return pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }finally {
            DynamicDataSourceContextHolder.clearDataSourceName();
        }
        return null;
    }

}
