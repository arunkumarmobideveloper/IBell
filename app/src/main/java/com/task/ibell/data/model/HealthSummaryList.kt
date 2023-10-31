package com.task.ibell.data.model

data class HealthSummaryList(
    val healthSummaryList :List<HealthSummaryListItems>
)

data class HealthSummaryListItems(val health_summary_type: String,
                                   val health_summary_type_logo: Int,val health_summary_details_logo: Int)
