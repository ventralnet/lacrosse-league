class BootStrap {

    def grailsApplication

    def init = { servletContext ->

        def ctx=grailsApplication.mainContext

        //implement test on borrow
        def dataSource = ctx.dataSource
        dataSource.targetDataSource.setMinEvictableIdleTimeMillis(1000 * 60 * 30)
        dataSource.targetDataSource.setTimeBetweenEvictionRunsMillis(1000 * 60 * 30)
        dataSource.targetDataSource.setNumTestsPerEvictionRun(3)
        dataSource.targetDataSource.setTestOnBorrow(true)
        dataSource.targetDataSource.setTestWhileIdle(true)
        dataSource.targetDataSource.setTestOnReturn(false)
        dataSource.targetDataSource.setValidationQuery("SELECT 1")

    }
    def destroy = {
    }
}
