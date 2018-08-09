package com.example.anh.githubadventure.api

import com.example.anh.githubadventure.model.Repository
import com.example.anh.githubadventure.model.RepositoryReadme
import com.example.anh.githubadventure.model.RepositorySearchResult
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PlatformAPI {

    @GET("search/repositories")
    fun searchRepositories(@Query("q") query: String,
                           @Query("page") page: String,
                           @Query("per_page") offset: String) : Single<RepositorySearchResult>

    @GET("/repos/{owner}/{repo}")
    fun getRepository(@Path("owner") owner: String, @Path("repo") repository: String): Single<Repository>

    @GET("/repos/{owner}/{repo}/readme")
    fun getRepositoryReadme(@Path("owner") owner: String, @Path("repo") repository: String): Single<RepositoryReadme>
}