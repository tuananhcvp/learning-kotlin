package com.example.anh.githubadventure.model

import com.google.gson.annotations.SerializedName

data class Repository(
        val id: String,
        @SerializedName("node_id")
        val nodeId: String,
        val name: String,
        @SerializedName("full_name")
        val fullName: String,
        val owner: RepositoryOwner,
        @SerializedName("html_url")
        val htmlUrl: String,
        val description: String?,
        val url: String,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("updated_at")
        val updatedAt: String,
        @SerializedName("pushed_at")
        val pushedAt: String,
        val homepage: String?,
        @SerializedName("stargazers_count")
        val stargazerCount: Long,
        @SerializedName("watchers_count")
        val watcherCount: Long,
        val watchers: String,
        val score: Double
)