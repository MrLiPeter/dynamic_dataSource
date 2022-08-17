package org.lxh.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class DynamicDataSource extends AbstractRoutingDataSource {

    public DynamicDataSource(LoadDataSource loadDataSource){
        //1.set all dataSource
        Map<String, DataSource> allDataSource = loadDataSource.loadAllDataSource();
        super.setTargetDataSources(new HashMap<>(allDataSource));
        //2.set default dataSource
        //if no @MyDataSource on method,need to set a default dataSource
        super.setDefaultTargetDataSource(allDataSource.get(DataSourceName.DEFAULT_DS_NAME));
        super.afterPropertiesSet();
    }

    /**
     * this method use to return dataSource's name ,
     * when system need dataSource,will auto call this method
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceName();
    }
}
