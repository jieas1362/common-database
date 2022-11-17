package com.future.database.ioc;

import com.future.database.api.conf.DataAccessConf;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

import static com.future.database.api.generator.ProDataAccessGenerator.*;


/**
 * data access components configuration
 *
 * @author liuyunfei
 */
@AutoConfiguration
public class ProDataAccessConfiguration {

    private final DataAccessConf dataAccessConf;

    public ProDataAccessConfiguration(DataAccessConf dataAccessConf) {
        this.dataAccessConf = dataAccessConf;
    }

    @Bean
    DataSource dataSource() {
        return generateDataSource(dataAccessConf);
    }

    @Bean
    SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
        return generateSqlSessionFactory(dataSource, dataAccessConf);
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return generateSqlSessionTemplate(sqlSessionFactory, dataAccessConf);
    }

    @Bean
    TransactionManager txManager(DataSource dataSource) {
        return generateTxManager(dataSource);
    }

}
