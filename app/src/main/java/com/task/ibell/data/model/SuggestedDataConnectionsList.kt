package com.task.ibell.data.model

data class SuggestedDataConnectionsList(
    val suggestedDataConnectionsList :List<DataConnectionListItems>
)

data class DataConnectionListItems(val connectionName: String,
                             val connection_logo: Int,val status: String,val status_change_logo: Int)

data class SuggestedDataConnectionsCategoriesList(
    val suggestedDataConnectionsCategoriesList :List<DataConnectionCategoriesListItems>
)

data class DataConnectionCategoriesListItems(val connectionCategoryName: String,
                                   val connection_logo: Int,val description: String)
