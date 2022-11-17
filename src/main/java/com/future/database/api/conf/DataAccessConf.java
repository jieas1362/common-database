package com.future.database.api.conf;

import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.AutoMappingUnknownColumnBehavior;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.type.JdbcType;

import java.util.Map;

/**
 * data access conf
 *
 * @author liuyunfei
 */
@SuppressWarnings({"JavaDoc", "AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc"})
public interface DataAccessConf {

    DatabaseAttr getDatabase();

    Boolean getSafeRowBoundsEnabled();

    Boolean getSafeResultHandlerEnabled();

    Boolean getMapUnderscoreToCamelCase();

    Boolean getAggressiveLazyLoading();

    Boolean getMultipleResultSetsEnabled();

    Boolean getUseGeneratedKeys();

    Boolean getUseColumnLabel();

    Boolean getCacheEnabled();

    Boolean getCallSettersOnNulls();

    Boolean getUseActualParamName();

    Boolean getReturnInstanceForEmptyRow();

    Boolean getShrinkWhitespacesInSql();

    Boolean getNullableOnForEach();

    LocalCacheScope getLocalCacheScope();

    JdbcType getJdbcTypeForNull();

    Integer getDefaultStatementTimeout();

    Integer getDefaultFetchSize();

    ResultSetType getDefaultResultSetType();

    ExecutorType getDefaultExecutorType();

    AutoMappingBehavior getAutoMappingBehavior();

    AutoMappingUnknownColumnBehavior getAutoMappingUnknownColumnBehavior();

    Boolean getLazyLoadingEnabled();

    /**
     * mybatis mapper location
     *
     * @return
     */
    String getMapperLocation();

    /**
     * additional attributes
     *
     * @return
     */
    Map<String, String> getProps();

    /**
     * show sql log?
     *
     * @return
     */
    Boolean getDebugLogging();

}
