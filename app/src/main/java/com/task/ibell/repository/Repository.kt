package com.task.ibell.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.task.ibell.R
import com.task.ibell.data.model.ActivityListItems
import com.task.ibell.data.model.DataConnectionListItems
import com.task.ibell.data.model.SuggestedActivitiesLIst
import com.task.ibell.data.model.SuggestedDataConnectionsList

class Repository(private val applicationContext: Context) {

    private val suggestedActivitiesLiveData = MutableLiveData<SuggestedActivitiesLIst>()

    val suggestedActivities: LiveData<SuggestedActivitiesLIst>
        get() = suggestedActivitiesLiveData

    private val suggestedDataConnectionsLiveData = MutableLiveData<SuggestedDataConnectionsList>()

    val suggestedDataConnections: LiveData<SuggestedDataConnectionsList>
        get() = suggestedDataConnectionsLiveData

    suspend fun getActivitiesSuggestionList() {

        val suggestionsList = mutableListOf<ActivityListItems>()
        suggestionsList.add(
            ActivityListItems(
                applicationContext.getString(R.string.connect_your_care_providers),
                applicationContext.getString(
                    R.string.your_healthcare_providers_store_lots_of_important_information_about_your_health
                ), R.drawable.circle
            )
        )
        suggestionsList.add(
            ActivityListItems(
                applicationContext.getString(R.string.build_your_care_team),
                applicationContext.getString(
                    R.string.having_a_team_of_healthcare_providers_you_trust_helps_you_get_the_best_care_possible
                ), R.drawable.plus_icon
            )
        )
        suggestionsList.add(
            ActivityListItems(
                applicationContext.getString(R.string.build_your_care_team),
                applicationContext.getString(
                    R.string.having_a_team_of_healthcare_providers_you_trust_helps_you_get_the_best_care_possible
                ), R.drawable.ic_placeholder
            )
        )
        suggestionsList.add(
            ActivityListItems(
                applicationContext.getString(R.string.build_your_care_team),
                applicationContext.getString(
                    R.string.having_a_team_of_healthcare_providers_you_trust_helps_you_get_the_best_care_possible
                ), R.drawable.vaccine_icon
            )
        )
        suggestionsList.add(
            ActivityListItems(
                applicationContext.getString(R.string.build_your_care_team),
                applicationContext.getString(
                    R.string.having_a_team_of_healthcare_providers_you_trust_helps_you_get_the_best_care_possible
                ), R.drawable.circle
            )
        )
        suggestionsList.add(
            ActivityListItems(
                applicationContext.getString(R.string.find_a_primary_care_provider_you),
                applicationContext.getString(
                    R.string.a_primary_care_provider_is_a_healthcare_professional_who_helps
                ), R.drawable.vaccine_icon
            )
        )
        val activityList = SuggestedActivitiesLIst(suggestionsList)
        suggestedActivitiesLiveData.postValue(activityList)
    }

    suspend fun getDataConnectionsList() {

        val suggestionsList = mutableListOf<DataConnectionListItems>()

        // Category A
        suggestionsList.add(
            DataConnectionListItems(
                "Absolute Total Care", R.drawable.circle
            )
        )
        suggestionsList.add(
            DataConnectionListItems(
                "Advantage by Superior HealthPlan (Ambetter)", R.drawable.plus_icon
            )
        )
        suggestionsList.add(
            DataConnectionListItems(
                "Aetna (Medicaid and Medicare Only)", R.drawable.ic_placeholder
            )
        )
        suggestionsList.add(
            DataConnectionListItems(
                "Affinity by Molina HealthCare", R.drawable.vaccine_icon
            )
        )
        suggestionsList.add(
            DataConnectionListItems(
                "Agewell New York", R.drawable.circle
            )
        )

        // Category B
        suggestionsList.add(
            DataConnectionListItems(
                "BCBS Minnesota", R.drawable.vaccine_icon
            )
        )
        suggestionsList.add(
            DataConnectionListItems(
                "BCBS of Alabama", R.drawable.circle
            )
        )
        suggestionsList.add(
            DataConnectionListItems(
                "BCBS of Arizona", R.drawable.vaccine_icon
            )
        )
        suggestionsList.add(
            DataConnectionListItems(
                "BCBS of Iowa (Wellmark)", R.drawable.circle
            )
        )
        suggestionsList.add(
            DataConnectionListItems(
                "BCBS of Kansas", R.drawable.vaccine_icon
            )
        )

        // Category C
        suggestionsList.add(
            DataConnectionListItems(
                "California Health and Wellness", R.drawable.circle
            )
        )
        suggestionsList.add(
            DataConnectionListItems(
                "CalViva Health", R.drawable.vaccine_icon
            )
        )
        suggestionsList.add(
            DataConnectionListItems(
                "Capital Health Plan", R.drawable.circle
            )
        )
        suggestionsList.add(
            DataConnectionListItems(
                "Care N' Care", R.drawable.vaccine_icon
            )
        )
        suggestionsList.add(
            DataConnectionListItems(
                "Care1st Health Plan Arizona", R.drawable.circle
            )
        )

        val activityList = SuggestedDataConnectionsList(suggestionsList)
        suggestedDataConnectionsLiveData.postValue(activityList)
    }

}