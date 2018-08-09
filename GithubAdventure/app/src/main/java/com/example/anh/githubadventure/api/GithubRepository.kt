package com.example.anh.githubadventure.api

import com.example.anh.githubadventure.model.Repository
import com.example.anh.githubadventure.model.RepositoryReadme
import com.example.anh.githubadventure.model.RepositorySearchResult
import io.reactivex.Single
import java.io.IOException
import javax.inject.Inject

class GithubRepository @Inject constructor(private val platformAPI: PlatformAPI) : GithubRepositoryInterface {

    @Throws(IOException::class)
    override fun searchRepositories(query: String, page: String, offset: String): Single<RepositorySearchResult> {
        return platformAPI.searchRepositories(query, page, offset)
    }

    @Throws(IOException::class)
    override fun getRepository(owner: String, repository: String): Single<Repository> {
        return platformAPI.getRepository(owner, repository)
    }

    @Throws(IOException::class)
    override fun getRepositoryReadme(owner: String, repository: String): Single<RepositoryReadme> {
        return platformAPI.getRepositoryReadme(owner, repository)
    }

}