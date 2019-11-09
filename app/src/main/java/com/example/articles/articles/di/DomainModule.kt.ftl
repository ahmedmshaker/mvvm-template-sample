
package ${PackageName}.di

import ${PackageName}.data.repository.${RepositoryName}
import ${PackageName}.data.repository.${RepositoryName}Impl
import ${PackageName}.domain.${useCaseName}Impl
import ${PackageName}.domain.${useCaseName}
import dagger.Binds
import dagger.Module

@Module
abstract class ${DomainModuleName} {

    @Binds
    abstract fun bindsRepository(
        repoImpl: ${RepositoryName}Impl
    ): ${RepositoryName}


    @Binds
    abstract fun bindsArticlesUseCase(
        m${useCaseName}: ${useCaseName}Impl
    ): ${useCaseName}



}