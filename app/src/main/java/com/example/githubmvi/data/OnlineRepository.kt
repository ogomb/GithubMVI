package com.example.githubmvi.data

import com.example.githubmvi.data.model.GithubIssue
import com.example.githubmvi.data.model.GithubRepo
import io.reactivex.Single
import okhttp3.ResponseBody

interface OnlineRepository {
    fun getRepos(): Single<List<GithubRepo>>
    fun getIssues(owner: String,repository: String): Single<List<GithubIssue>>
    fun postComment( url: String, issue: GithubIssue): Single<ResponseBody>
}