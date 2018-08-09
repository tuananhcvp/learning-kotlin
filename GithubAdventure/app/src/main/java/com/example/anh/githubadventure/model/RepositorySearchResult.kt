package com.example.anh.githubadventure.model

import com.google.gson.annotations.SerializedName

data class RepositorySearchResult(
        @SerializedName("total_count")
        val totalCount: Int,
        @SerializedName("incomplete_results")
        val incompleteResults: Boolean,
        val items: List<Repository>
)