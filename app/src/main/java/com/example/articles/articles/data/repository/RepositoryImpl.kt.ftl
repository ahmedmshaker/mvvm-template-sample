package ${PackageName}.data.repository


import javax.inject.Inject
package ${PackageName}.data.remote.source.${RemoteDataSourceName}


class ${RepositoryName}Impl @Inject constructor(
    private val remoteDataSource: ${RemoteDataSourceName}
) : ${RepositoryName} {




// Sample Code to be deleted
//    override suspend fun getArticles(mustFetchFromNetwork: Boolean) = liveData {
//        emit(Result.loading<List<Article>>())
//        try {
//
//            var articles: List<Article>? = null
//            if (!mustFetchFromNetwork)
//                articles = localDataSource.getArticles()
//
//
//            if (articles == null) {
//                articles = remoteDataSource.requestArticles()
//                localDataSource.saveArticles(articles)
//            }
//            emit(Result.success(articles))
//
//        } catch (exception: Exception) {
//            emit(Result.error<List<Article>>(exception.message ?: ""))
//        }
//    }




}