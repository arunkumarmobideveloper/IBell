package com.task.ibell.data.model

data class LabsList(
    val labsList :List<LabsListItems>
)

data class LabsListItems(val labsType: String,val labsDate: String,val labsStatus: String)
