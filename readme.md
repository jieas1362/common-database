# database
## mybatis-plus

### application.yml
```
data:
  database:
    url: *****
    data-base-conf: *****
    username: *****
    password: *****
    driverClassName: com.mysql.cj.jdbc.Driver
    connectionTimeout: 30000
    maxLifetime: 60000
    maximumPoolSize: 4
    minimumIdle: 2
    idleTimeout: 8
    testQuery: SELECT 1 FROM DUAL
    readOnly: false
    autoCommit: false

  safeRowBoundsEnabled: false
  safeResultHandlerEnabled: false
  mapUnderscoreToCamelCase: true
  aggressiveLazyLoading: false
  multipleResultSetsEnabled: false
  useGeneratedKeys: false
  useColumnLabel: true
  cacheEnabled: false
  callSettersOnNulls: false
  useActualParamName: false
  returnInstanceForEmptyRow: false
  shrinkWhitespacesInSql: false
  nullableOnForEach: false
  localCacheScope: SESSION
  jdbcTypeForNull:
  defaultStatementTimeout: 30000
  defaultFetchSize: 100
  defaultResultSetType: DEFAULT
  defaultExecutorType: SIMPLE
  autoMappingBehavior: FULL
  autoMappingUnknownColumnBehavior: FAILING
  lazyLoadingEnabled: false
  mapperLocation: classpath:mapper/*.xml
  props:
    sql.show: true
    sql.simple: false
    executor.size: 128
    max.connections.size.per.query: 2
    check.table.metadata.enabled: true
    query.with.cipher.column: false
    xa.transaction.manager.type: Atomikos
  debugLogging: true
```




### project
#### config class
```
@Component
@ConfigurationProperties(prefix = "data")
public class ProDataAccessConfig extends DataAccessConfParams {
}
```

#### use
```
mybais-plus
```