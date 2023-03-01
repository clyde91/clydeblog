package com.clyde.blog.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author clyde
 */
@Configuration
public class MybatisConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //分页器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

//        //动态表名
//        DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor = new DynamicTableNameInnerInterceptor();
//        HashMap<String, TableNameHandler> map = new HashMap<>();
//        // 对于user2表，进行动态表名设置
//        map.put("user2", (sql, tableName) -> {
//            String _ = "_";
//            int random = new Random().nextInt(2) + 1;
//            return tableName + _ + random; // 若返回null, 则不会进行动态表名替换, 还是会使用user2
//        });
//        dynamicTableNameInnerInterceptor.setTableNameHandlerMap(map);
//        interceptor.addInnerInterceptor(dynamicTableNameInnerInterceptor);
//




        return interceptor;
    }
}
