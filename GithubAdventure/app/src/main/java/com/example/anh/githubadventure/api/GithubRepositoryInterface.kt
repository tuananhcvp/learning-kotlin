package com.example.anh.githubadventure.api

import com.example.anh.githubadventure.model.Repository
import com.example.anh.githubadventure.model.RepositoryReadme
import com.example.anh.githubadventure.model.RepositorySearchResult
import io.reactivex.Single
import rx.Observable
import java.io.IOException


interface GithubRepositoryInterface {

    @Throws(IOException::class)
    fun searchRepositories(query: String, page: String, offset: String): Single<RepositorySearchResult>

    @Throws(IOException::class)
    fun getRepository(owner: String, repository: String): Single<Repository>

    @Throws(IOException::class)
    fun getRepositoryReadme(owner: String, repository: String): Single<RepositoryReadme>

}