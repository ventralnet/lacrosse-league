dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    //driverClassName = "com.mysql.jdbc.Driver"
    username = "sa"
    password = ""
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
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            loggingSql = true
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            //url = "jdbc:mysql://localhost:3306/matt_lacrosse"
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
                dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
                loggingSql = true
                url = "jdbc:mysql://localhost:3306/matt_lacrosse"
            }
    }
}
