package com.example.githubmvi.data.model

import com.google.gson.annotations.SerializedName

data class GithubIssue(
    val id:String,
    val title:String,
    val comments_url:String,
    @SerializedName("body") val comment:String ) {
}