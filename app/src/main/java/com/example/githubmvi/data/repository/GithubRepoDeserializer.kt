package com.example.githubmvi.data.repository

import com.example.githubmvi.data.model.GithubRepo
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import com.google.gson.JsonObject



class GithubRepoDeserializer:JsonDeserializer<GithubRepo> {

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): GithubRepo {
        val githubRepo = GithubRepo("","","")

        val repoJsonObject = json?.getAsJsonObject()
        githubRepo.name = repoJsonObject?.get("name")?.asString.toString()
        githubRepo.url = repoJsonObject?.get("url")?.asString.toString()

        val ownerJsonElement = repoJsonObject?.get("owner")
        val ownerJsonObject = ownerJsonElement?.asJsonObject
        githubRepo.owner = ownerJsonObject?.get("login")?.asString.toString()

        return githubRepo
    }
}