
package ${PACKAGE_NAME}.data.remote.source

import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import ${PackageName}.data.remote.services.${ServiceName}


class ${RemoteDataSourceName}Impl @Inject constructor(
    private val service: ${ServiceName},
    @IO private val context: CoroutineContext
    )
    : ${RemoteDataSourceName} {

//  Example for Sync API calls
//    override suspend fun requestArticles()= withContext(context) {
//        val response = articlesService.requestArticlesAsync(BuildConfig.API_KEY).await()
//
//        if (response.isSuccessful)
//             response.body()?.articles ?: throw Exception("no Articles")
//        else
//            throw Exception("invalid request with code ${response.code()}")
//   }

}
