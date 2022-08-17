package org.lxh.dataSource;



import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
@EnableConfigurationProperties(DsProperties.class)
public class LoadDataSource {
    @Autowired
    DsProperties dsProperties;

    public Map<String, DataSource> loadAllDataSource(){
        Map<String,DataSource> map = new HashMap<>();
        Map<String, Map<String, String>> ds = dsProperties.getDs();
        try {
            Set<String> keySet = ds.keySet();
            for (String key : keySet) {
                map.put(key, dsProperties.generateDataSource((DruidDataSource) DruidDataSourceFactory.createDataSource(ds.get(key))));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

}
