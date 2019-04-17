package com.example.githubmvi.data.repository

import com.example.githubmvi.data.model.GithubIssue
import com.example.githubmvi.data.model.GithubRepo
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*

interface ApiService {

    @GET("user/repos?per_page=100")
    fun getRepos(): Observable<List<GithubRepo>>

    @GET("/repos/{owner}/{repo}/issues")
    fun getIssues(@Path("owner") owner: String, @Path("repo") repository: String): Observable<List<GithubIssue>>

    @POST
    fun postComment(@Url url: String, @Body issue: GithubIssue): Observable<ResponseBody>
}