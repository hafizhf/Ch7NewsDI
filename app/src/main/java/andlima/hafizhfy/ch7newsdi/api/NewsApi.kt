package andlima.hafizhfy.ch7newsdi.api

import andlima.hafizhfy.ch7newsdi.model.GetAllNewsResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface NewsApi {
    @GET("news")
    suspend fun getALlNews() : List<GetAllNewsResponseItem>
}