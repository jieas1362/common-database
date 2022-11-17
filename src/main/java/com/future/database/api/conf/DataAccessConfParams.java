package com.future.database.api.conf;

import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.AutoMappingUnknownColumnBehavior;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.type.JdbcType;

import java.util.Map;

/**
 * data access params
 *
 * @author liuyunfei
 */
@SuppressWarnings({"AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc", "unused"})
public class DataAccessConfParams implements DataAccessConf {

    protected transient DatabaseAttr database;

    protected Boolean safeRowBoundsEnabled;

    protected Boolean safeResultHandlerEnabled;

    protected Boolean mapUnderscoreToCamelCase;

    protected Boolean aggressiveLazyLoading;

    protected Boolean multipleResultSetsEnabled;

    protected Boolean useGeneratedKeys;

    protected Boolean useColumnLabel;

    protected Boolean cacheEnabled;

    protected Boolean callSettersOnNulls;

    protected Boolean useActualParamName;

    protected Boolean returnInstanceForEmptyRow;

    protected Boolean shrinkWhitespacesInSql;

    protected Boolean nullableOnForEach;

    protected LocalCacheScope localCacheScope;

    protected JdbcType jdbcTypeForNull;

    protected Integer defaultStatementTimeout;

    protected Integer defaultFetchSize;

    protected ResultSetType defaultResultSetType;

    protected ExecutorType defaultExecutorType;

    protected AutoMappingBehavior autoMappingBehavior;

    protected AutoMappingUnknownColumnBehavior autoMappingUnknownColumnBehavior;

    protected Boolean lazyLoadingEnabled;

    protected transient String mapperLocation;

    protected transient Map<String, String> props;

    /**
     * show sql log?
     */
    protected Boolean debugLogging;

    public DataAccessConfParams() {
    }

    @Override
    public DatabaseAttr getDatabase() {
        return database;
    }

    @Override
    public Boolean getSafeRowBoundsEnabled() {
        return safeRowBoundsEnabled;
    }

    @Override
    public Boolean getSafeResultHandlerEnabled() {
        return safeResultHandlerEnabled;
    }

    @Override
    public Boolean getMapUnderscoreToCamelCase() {
        return mapUnderscoreToCamelCase;
    }

    @Override
    public Boolean getAggressiveLazyLoading() {
        return aggressiveLazyLoading;
    }

    @Override
    public Boolean getMultipleResultSetsEnabled() {
        return multipleResultSetsEnabled;
    }

    @Override
    public Boolean getUseGeneratedKeys() {
        return useGeneratedKeys;
    }

    @Override
    public Boolean getUseColumnLabel() {
        return useColumnLabel;
    }

    @Override
    public Boolean getCacheEnabled() {
        return cacheEnabled;
    }

    @Override
    public Boolean getCallSettersOnNulls() {
        return callSettersOnNulls;
    }

    @Override
    public Boolean getUseActualParamName() {
        return useActualParamName;
    }

    @Override
    public Boolean getReturnInstanceForEmptyRow() {
        return returnInstanceForEmptyRow;
    }

    @Override
    public Boolean getShrinkWhitespacesInSql() {
        return shrinkWhitespacesInSql;
    }

    @Override
    public Boolean getNullableOnForEach() {
        return nullableOnForEach;
    }

    @Override
    public LocalCacheScope getLocalCacheScope() {
        return localCacheScope;
    }

    @Override
    public JdbcType getJdbcTypeForNull() {
        return jdbcTypeForNull;
    }

    @Override
    public Integer getDefaultStatementTimeout() {
        return defaultStatementTimeout;
    }

    @Override
    public Integer getDefaultFetchSize() {
        return defaultFetchSize;
    }

    @Override
    public ResultSetType getDefaultResultSetType() {
        return defaultResultSetType;
    }

    @Override
    public ExecutorType getDefaultExecutorType() {
        return defaultExecutorType;
    }

    @Override
    public AutoMappingBehavior getAutoMappingBehavior() {
        return autoMappingBehavior;
    }

    @Override
    public AutoMappingUnknownColumnBehavior getAutoMappingUnknownColumnBehavior() {
        return autoMappingUnknownColumnBehavior;
    }

    @Override
    public Boolean getLazyLoadingEnabled() {
        return lazyLoadingEnabled;
    }

    @Override
    public String getMapperLocation() {
        return mapperLocation;
    }

    @Override
    public Map<String, String> getProps() {
        return props;
    }

    @Override
    public Boolean getDebugLogging() {
        return debugLogging;
    }

    public void setDatabase(DatabaseAttr database) {
        this.database = database;
    }

    public void setSafeRowBoundsEnabled(Boolean safeRowBoundsEnabled) {
        this.safeRowBoundsEnabled = safeRowBoundsEnabled;
    }

    public void setSafeResultHandlerEnabled(Boolean safeResultHandlerEnabled) {
        this.safeResultHandlerEnabled = safeResultHandlerEnabled;
    }

    public void setMapUnderscoreToCamelCase(Boolean mapUnderscoreToCamelCase) {
        this.mapUnderscoreToCamelCase = mapUnderscoreToCamelCase;
    }

    public void setAggressiveLazyLoading(Boolean aggressiveLazyLoading) {
        this.aggressiveLazyLoading = aggressiveLazyLoading;
    }

    public void setMultipleResultSetsEnabled(Boolean multipleResultSetsEnabled) {
        this.multipleResultSetsEnabled = multipleResultSetsEnabled;
    }

    public void setUseGeneratedKeys(Boolean useGeneratedKeys) {
        this.useGeneratedKeys = useGeneratedKeys;
    }

    public void setUseColumnLabel(Boolean useColumnLabel) {
        this.useColumnLabel = useColumnLabel;
    }

    public void setCacheEnabled(Boolean cacheEnabled) {
        this.cacheEnabled = cacheEnabled;
    }

    public void setCallSettersOnNulls(Boolean callSettersOnNulls) {
        this.callSettersOnNulls = callSettersOnNulls;
    }

    public void setUseActualParamName(Boolean useActualParamName) {
        this.useActualParamName = useActualParamName;
    }

    public void setReturnInstanceForEmptyRow(Boolean returnInstanceForEmptyRow) {
        this.returnInstanceForEmptyRow = returnInstanceForEmptyRow;
    }

    public void setShrinkWhitespacesInSql(Boolean shrinkWhitespacesInSql) {
        this.shrinkWhitespacesInSql = shrinkWhitespacesInSql;
    }

    public void setNullableOnForEach(Boolean nullableOnForEach) {
        this.nullableOnForEach = nullableOnForEach;
    }

    public void setLocalCacheScope(LocalCacheScope localCacheScope) {
        this.localCacheScope = localCacheScope;
    }

    public void setJdbcTypeForNull(JdbcType jdbcTypeForNull) {
        this.jdbcTypeForNull = jdbcTypeForNull;
    }

    public void setDefaultStatementTimeout(Integer defaultStatementTimeout) {
        this.defaultStatementTimeout = defaultStatementTimeout;
    }

    public void setDefaultFetchSize(Integer defaultFetchSize) {
        this.defaultFetchSize = defaultFetchSize;
    }

    public void setDefaultResultSetType(ResultSetType defaultResultSetType) {
        this.defaultResultSetType = defaultResultSetType;
    }

    public void setDefaultExecutorType(ExecutorType defaultExecutorType) {
        this.defaultExecutorType = defaultExecutorType;
    }

    public void setAutoMappingBehavior(AutoMappingBehavior autoMappingBehavior) {
        this.autoMappingBehavior = autoMappingBehavior;
    }

    public void setAutoMappingUnknownColumnBehavior(AutoMappingUnknownColumnBehavior autoMappingUnknownColumnBehavior) {
        this.autoMappingUnknownColumnBehavior = autoMappingUnknownColumnBehavior;
    }

    public void setLazyLoadingEnabled(Boolean lazyLoadingEnabled) {
        this.lazyLoadingEnabled = lazyLoadingEnabled;
    }

    public void setMapperLocation(String mapperLocation) {
        this.mapperLocation = mapperLocation;
    }

    public void setProps(Map<String, String> props) {
        this.props = props;
    }

    public void setDebugLogging(Boolean debugLogging) {
        this.debugLogging = debugLogging;
    }

    @Override
    public String toString() {
        return "BaseDataAccessConfParams{" +
                "database=" + database +
                ", safeRowBoundsEnabled=" + safeRowBoundsEnabled +
                ", safeResultHandlerEnabled=" + safeResultHandlerEnabled +
                ", mapUnderscoreToCamelCase=" + mapUnderscoreToCamelCase +
                ", aggressiveLazyLoading=" + aggressiveLazyLoading +
                ", multipleResultSetsEnabled=" + multipleResultSetsEnabled +
                ", useGeneratedKeys=" + useGeneratedKeys +
                ", useColumnLabel=" + useColumnLabel +
                ", cacheEnabled=" + cacheEnabled +
                ", callSettersOnNulls=" + callSettersOnNulls +
                ", useActualParamName=" + useActualParamName +
                ", returnInstanceForEmptyRow=" + returnInstanceForEmptyRow +
                ", shrinkWhitespacesInSql=" + shrinkWhitespacesInSql +
                ", nullableOnForEach=" + nullableOnForEach +
                ", localCacheScope=" + localCacheScope +
                ", jdbcTypeForNull=" + jdbcTypeForNull +
                ", defaultStatementTimeout=" + defaultStatementTimeout +
                ", defaultFetchSize=" + defaultFetchSize +
                ", defaultResultSetType=" + defaultResultSetType +
                ", defaultExecutorType=" + defaultExecutorType +
                ", autoMappingBehavior=" + autoMappingBehavior +
                ", autoMappingUnknownColumnBehavior=" + autoMappingUnknownColumnBehavior +
                ", lazyLoadingEnabled=" + lazyLoadingEnabled +
                ", mapperLocation='" + mapperLocation + '\'' +
                ", props=" + props +
                ", debugLogging=" + debugLogging +
                '}';
    }

}
