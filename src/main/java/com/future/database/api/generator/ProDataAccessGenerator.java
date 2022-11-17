package com.future.database.api.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.future.database.api.conf.DataAccessConf;
import com.future.database.api.conf.DatabaseAttr;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.util.function.Function;

import static com.future.base.util.base.ProChecker.isNull;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.ibatis.session.ExecutorType.BATCH;

/**
 * data access component generator
 *
 * @author liuyunfei
 */
@SuppressWarnings({"JavaDoc", "PlaceholderCountMatchesArgumentCount", "AliControlFlowStatementWithoutBraces", "SpellCheckingInspection", "DuplicatedCode"})
public final class ProDataAccessGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProDataAccessGenerator.class);

    /**
     * datasource generator
     */
    private static final Function<DatabaseAttr, DataSource> DATA_SOURCE_GENERATOR = attr -> {
        HikariConfig hikariConfig = new HikariConfig();

        String driverClassName = attr.getDriverClassName();
        if (isBlank(driverClassName))
            throw new RuntimeException("driverClassName can't be blank");

        String url = attr.getUrl();
        if (isBlank(url))
            throw new RuntimeException("url can't be blank");

        String username = attr.getUsername();
        if (isBlank(username))
            throw new RuntimeException("username can't be blank");

        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setJdbcUrl(url + ofNullable(attr.getDataBaseConf()).map(c -> "?" + c).orElse(""));
        hikariConfig.setUsername(username);
        ofNullable(attr.getPassword()).ifPresent(hikariConfig::setPassword);

        ofNullable(attr.getReadOnly()).ifPresent(hikariConfig::setReadOnly);
        ofNullable(attr.getConnectionTimeout()).ifPresent(hikariConfig::setConnectionTimeout);
        ofNullable(attr.getMaxLifetime()).ifPresent(hikariConfig::setMaxLifetime);
        ofNullable(attr.getMaximumPoolSize()).ifPresent(hikariConfig::setMaximumPoolSize);
        ofNullable(attr.getMinimumIdle()).ifPresent(hikariConfig::setMinimumIdle);
        ofNullable(attr.getTestQuery()).ifPresent(hikariConfig::setConnectionTestQuery);

        return new HikariDataSource(hikariConfig);
    };

    /**
     * generate datasource
     *
     * @param dataAccessConf
     * @return
     */
    public static DataSource generateDataSource(DataAccessConf dataAccessConf) {
        LOGGER.info("static DataSource generateDataSource(DataAccessConf dataAccessConf), dataAccessConf = {}",
                dataAccessConf);

        if (isNull(dataAccessConf))
            throw new RuntimeException("dataAccessConf can't be null");

        try {
            return DATA_SOURCE_GENERATOR.apply(dataAccessConf.getDatabase());
        } catch (Exception e) {
            LOGGER.error("static DataSource generateDataSource(DataAccessConf dataAccessConf) failed, dataAccessConf = {}, e = {}",
                    dataAccessConf, e);
            throw new RuntimeException("static DataSource generateDataSource(DataAccessConf dataAccessConf) failed, e = " + e);
        }
    }

    /**
     * generate transaction manager
     *
     * @param dataSource
     * @return
     */
    public static TransactionManager generateTxManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * generate sqlsession factory
     *
     * @param dataSource
     * @param dataAccessConf
     * @return
     */
    public static SqlSessionFactory generateSqlSessionFactory(DataSource dataSource, DataAccessConf dataAccessConf) {
        LOGGER.info("static SqlSessionFactory generateSqlSessionFactory(DataSource dataSource, DataAccessConf dataAccessConf), dataSource = {}, dataAccessConf = {}",
                dataSource, dataAccessConf);

        MybatisConfiguration configuration = new MybatisConfiguration();

        ofNullable(dataAccessConf.getSafeRowBoundsEnabled()).ifPresent(configuration::setSafeRowBoundsEnabled);
        ofNullable(dataAccessConf.getSafeResultHandlerEnabled()).ifPresent(configuration::setSafeResultHandlerEnabled);
        ofNullable(dataAccessConf.getMapUnderscoreToCamelCase()).ifPresent(configuration::setMapUnderscoreToCamelCase);
        ofNullable(dataAccessConf.getAggressiveLazyLoading()).ifPresent(configuration::setAggressiveLazyLoading);
        ofNullable(dataAccessConf.getMultipleResultSetsEnabled()).ifPresent(configuration::setMultipleResultSetsEnabled);
        ofNullable(dataAccessConf.getUseGeneratedKeys()).ifPresent(configuration::setUseGeneratedKeys);
        ofNullable(dataAccessConf.getUseColumnLabel()).ifPresent(configuration::setUseColumnLabel);
        ofNullable(dataAccessConf.getCacheEnabled()).ifPresent(configuration::setCacheEnabled);
        ofNullable(dataAccessConf.getCallSettersOnNulls()).ifPresent(configuration::setCallSettersOnNulls);
        ofNullable(dataAccessConf.getUseActualParamName()).ifPresent(configuration::setUseActualParamName);
        ofNullable(dataAccessConf.getReturnInstanceForEmptyRow()).ifPresent(configuration::setReturnInstanceForEmptyRow);
        ofNullable(dataAccessConf.getShrinkWhitespacesInSql()).ifPresent(configuration::setShrinkWhitespacesInSql);
        ofNullable(dataAccessConf.getNullableOnForEach()).ifPresent(configuration::setNullableOnForEach);
        ofNullable(dataAccessConf.getLocalCacheScope()).ifPresent(configuration::setLocalCacheScope);
        ofNullable(dataAccessConf.getJdbcTypeForNull()).ifPresent(configuration::setJdbcTypeForNull);
        ofNullable(dataAccessConf.getDefaultStatementTimeout()).ifPresent(configuration::setDefaultStatementTimeout);
        ofNullable(dataAccessConf.getDefaultFetchSize()).ifPresent(configuration::setDefaultFetchSize);
        ofNullable(dataAccessConf.getDefaultResultSetType()).ifPresent(configuration::setDefaultResultSetType);
        ofNullable(dataAccessConf.getDefaultExecutorType()).ifPresent(configuration::setDefaultExecutorType);
        ofNullable(dataAccessConf.getAutoMappingBehavior()).ifPresent(configuration::setAutoMappingBehavior);
        ofNullable(dataAccessConf.getAutoMappingUnknownColumnBehavior()).ifPresent(configuration::setAutoMappingUnknownColumnBehavior);
        ofNullable(dataAccessConf.getLazyLoadingEnabled()).ifPresent(configuration::setLazyLoadingEnabled);

        if (ofNullable(dataAccessConf.getDebugLogging()).orElse(false))
            configuration.setLogImpl(StdOutImpl.class);

        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfiguration(configuration);
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setPlugins(interceptor);

        try {
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(dataAccessConf.getMapperLocation()));
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            LOGGER.error("generate sqlSessionFactory failed, e = {}", e);
            throw new RuntimeException("generate sqlSessionFactory failed, e = " + e);
        }

    }

    /**
     * generate sqlsession template
     *
     * @param sqlSessionFactory
     * @param dataAccessConf
     * @return
     */
    public static SqlSessionTemplate generateSqlSessionTemplate(SqlSessionFactory sqlSessionFactory, DataAccessConf dataAccessConf) {
        return new SqlSessionTemplate(sqlSessionFactory, ofNullable(dataAccessConf).map(DataAccessConf::getDefaultExecutorType).orElse(BATCH));
    }

}