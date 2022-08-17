package org.lxh.dataSource;

/**
 * store currentThread dataSource's name
 * 存储当前线程数据源的名称
 */
public class DynamicDataSourceContextHolder {
    private static ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDataSourceName(String dataSourceName){
        CONTEXT_HOLDER.set(dataSourceName);
    }

    public static String getDataSourceName(){
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSourceName(){
        CONTEXT_HOLDER.remove();
    }


}
