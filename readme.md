# 学习模拟若依实现多数据源切换
实现思路:
1. 自定义一个注解 @DataSource，将来可以将该注解加在 service 层方法或者类上面，表示方法或者类中的所有方法都使用某一个数据源。
2. 对于第一步，如果某个方法上面有 @DataSource 注解，那么就将该方法需要使用的数据源名称存入到 ThreadLocal。
3. 自定义切面，在切面中解析 @DataSource 注解，当一个方法或者类上面有 @DataSource 注解的时候，将 @DataSource 注解所标记的数据源存入到 ThreadLocal 中。
4. 最后，当 Mapper 执行的时候，需要 DataSource，他会自动去 AbstractRoutingDataSource 类中查找需要的数据源，我们只需要在 AbstractRoutingDataSource 中返回 ThreadLocal  中的值即可。

# learn to realize multiple data source switch
ideas:
1.A custom @datasource annotation can be added to a Service layer method or class in the future to indicate that all methods in the method or class use a DataSource.
2.For the first step, if a method has the @datasource annotation on it, store the DataSource name that the method needs to use in a ThreadLocal.
3.To customize the section, parse the @datasource annotation in the section, and store the DataSource marked by the @datasource annotation in a ThreadLocal whenever 
the @datasource annotation is on a method or class。
4.Finally, when the Mapper implementation, need a DataSource, 
he will automatically go AbstractRoutingDataSource class finds the need of data sources, 
We need only returns the value of the ThreadLocal in AbstractRoutingDataSource.