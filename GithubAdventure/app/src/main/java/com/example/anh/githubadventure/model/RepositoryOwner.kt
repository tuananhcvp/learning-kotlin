package com.example.anh.githubadventure.model

import com.google.gson.annotations.SerializedName

data class RepositoryOwner(
        val login: String,
        val id: Long,
        @SerializedName("node_id")
        val nodeId: String,
        @SerializedName("avatar_url")
        val avatarUrl: String,
        val url: String,
        val type: String
)