package com.example.anh.githubadventure.model

import com.google.gson.annotations.SerializedName

data class RepositoryReadme(
        val type: String,
        val encoding: String,
        val size: Long,
        val name: String,
        val path: String,
        val sha: String,
        val url: String,
        @SerializedName("git_url")
        val gitUrl: String,
        @SerializedName("html_url")
        val htmlUrl: String,
        @SerializedName("download_url")
        val downloadUrl: String
)