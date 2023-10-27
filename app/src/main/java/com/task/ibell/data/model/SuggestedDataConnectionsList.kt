package com.task.ibell.data.model

data class SuggestedDataConnectionsList(
    val suggestedDataConnectionsList :List<DataConnectionListItems>
)

data class DataConnectionListItems(val connectionName: String,
                             val icon: Int,)
