dataSource {
    pooled = true
    //driverClassName = "org.h2.Driver"
    driverClassName = "com.mysql.jdbc.Driver"
    username = "projectuser"
    password = "pwfall2012"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "validate" // one of 'create', 'create-drop', 'update', 'validate', ''
            loggingSql = true
//            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            url = "jdbc:mysql://web3.apl.jhu.edu:3306/project_db_fall12"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
                dbCreate = "validate" // one of 'create', 'create-drop', 'update', 'validate', ''
                loggingSql = true
                url = "jdbc:mysql://web3.apl.jhu.edu:3306/project_db_fall12"
                properties { 
                    testWhileIdle=true 
                    testOnBorrow=true 
                    testOnReturn=false 
                    validationQuery="SELECT 1" 
                    validationInterval=30000 
                    timeBetweenEvictionRunsMillis=5000 
                    maxActive=100 
                    minIdle=10 
                    maxWait=10000 
                    initialSize=10 
                    removeAbandonedTimeout=60 
                    removeAbandoned=true 
                    minEvictableIdleTimeMillis=30000 
                } 
            }
    }
}
