package com.task.ibell.data.model

data class HealthSummaryList(
    val healthSummaryList :List<HealthSummaryListItems>
)

data class HealthSummaryListItems(val healthSummaryType: String,
                                   val healthSummaryTypeLogo: Int,val healthSummaryDetailsLogo: Int)
