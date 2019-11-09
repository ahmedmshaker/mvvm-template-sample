
package ${PackageName}.di



import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
package ${PACKAGE_NAME}.data.remote.source.${RemoteDataSourceName}
package ${PACKAGE_NAME}.data.remote.source.${RemoteDataSourceName}Impl




@Module(includes = [${RemoteModuleName}.Binders::class])
class ${RemoteModuleName} {



    @Module
    interface Binders {



        @Binds
        fun bindsRemoteSource(
            remoteDataSourceImpl: ${RemoteDataSourceName}Impl
        ): ${RemoteDataSourceName}



    }



    @Provides
    fun provides${ServiceName}(retrofit: Retrofit): ${ServiceName} =
        retrofit.create(${ServiceName}::class.java)



}