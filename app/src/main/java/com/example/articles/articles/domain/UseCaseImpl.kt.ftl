
package ${PackageName}.domain

import package ${PackageName}.data.repository.${RepositoryName}
import javax.inject.Inject

class ${useCaseName}Impl @Inject constructor(private val m${RepositoryName}: ${RepositoryName}) : ${useCaseName}  {

}
