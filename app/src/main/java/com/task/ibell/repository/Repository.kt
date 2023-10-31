package com.task.ibell.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.task.ibell.R
import com.task.ibell.data.model.ActivityListItems
import com.task.ibell.data.model.DataConnectionCategoriesListItems
import com.task.ibell.data.model.DataConnectionListItems
import com.task.ibell.data.model.HealthSummaryList
import com.task.ibell.data.model.HealthSummaryListItems
import com.task.ibell.data.model.LabsList
import com.task.ibell.data.model.LabsListItems
import com.task.ibell.data.model.SuggestedActivitiesLIst
import com.task.ibell.data.model.SuggestedDataConnectionsCategoriesList
import com.task.ibell.data.model.SuggestedDataConnectionsList

class Repository(private val applicationContext: Context) {

    private val suggestedActivitiesLiveData = MutableLiveData<SuggestedActivitiesLIst>()

    val suggestedActivities: LiveData<SuggestedActivitiesLIst>
        get() = suggestedActivitiesLiveData

    private val suggestedDataConnectionsLiveData = MutableLiveData<SuggestedDataConnectionsList>()

    val suggestedDataConnections: LiveData<SuggestedDataConnectionsList>
        get() = suggestedDataConnectionsLiveData

    private val suggestedDataConnectionsCategoriesLiveData = MutableLiveData<SuggestedDataConnectionsCategoriesList>()

    val suggestedDataConnectionsCategories: LiveData<SuggestedDataConnectionsCategoriesList>
        get() = suggestedDataConnectionsCategoriesLiveData

    private val healthSummaryLiveData = MutableLiveData<HealthSummaryList>()

    val healthSummary: LiveData<HealthSummaryList>
        get() = healthSummaryLiveData

    private val labsLiveData = MutableLiveData<LabsList>()

    val labs: LiveData<LabsList>
        get() = labsLiveData

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

    suspend fun getDataConnectionsCategoriesList() {

        val suggestionsList = mutableListOf<DataConnectionCategoriesListItems>()

        // Category A
        suggestionsList.add(
            DataConnectionCategoriesListItems(
                "Insurance", R.drawable.circle,
                "Get your claims and financials, plus a record of the providers you see from common insurance plans and Medicare."
            )
        )
        suggestionsList.add(
            DataConnectionCategoriesListItems(
                "Providers", R.drawable.plus_icon,
                        "See your core health info, such as provider visit summaries, diagnosis, treatment history, prescriptions, and labs."
            )
        )
        suggestionsList.add(
            DataConnectionCategoriesListItems(
                "Clinics, Hospitals and Health Systems", R.drawable.ic_placeholder,
                        "See your core health info, such as your diagnosis, procedures, treatment history, prescriptions, and labs."
            )
        )
        suggestionsList.add(
            DataConnectionCategoriesListItems(
                "Labs", R.drawable.vaccine_icon,
                        "View your lab results to track your numbers over time."
            )
        )

        val activityList = SuggestedDataConnectionsCategoriesList(suggestionsList)
        suggestedDataConnectionsCategoriesLiveData.postValue(activityList)
    }

    suspend fun getDataConnectionsList() {

        val suggestionsList = mutableListOf<DataConnectionListItems>()

        // Category A
        suggestionsList.add(
            DataConnectionListItems(
                "Epic Sandbox R4C", R.drawable.baseline_person_pin_24, "Pending",R.drawable.baseline_more_vert_24
            )
        )
        suggestionsList.add(
            DataConnectionListItems(
                "HAPI - Starfleet Medical", R.drawable.baseline_person_pin_24,
                        "Disconnected",R.drawable.baseline_more_vert_24
            )
        )
        suggestionsList.add(
            DataConnectionListItems(
                "ThedaCare Ripple", R.drawable.baseline_person_pin_24,
                        "Needs Reauthorization",R.drawable.baseline_more_vert_24
            )
        )

        val activityList = SuggestedDataConnectionsList(suggestionsList)
        suggestedDataConnectionsLiveData.postValue(activityList)
    }

    suspend fun getHealthSummaryList() {

        val suggestionsList = mutableListOf<HealthSummaryListItems>()

        // Category A
        suggestionsList.add(
            HealthSummaryListItems(
                "Care Plans (1)", R.drawable.baseline_person_24,R.drawable.baseline_keyboard_arrow_right_24
            )
        )
        suggestionsList.add(
            HealthSummaryListItems(
                "Visit History (4)", R.drawable.baseline_person_24, R.drawable.baseline_keyboard_arrow_right_24
            )
        )
        suggestionsList.add(
            HealthSummaryListItems(
                "Vitals (5)", R.drawable.baseline_person_24, R.drawable.baseline_keyboard_arrow_right_24
            )
        )

        suggestionsList.add(
            HealthSummaryListItems(
                "Procedures (1)", R.drawable.baseline_person_24, R.drawable.baseline_keyboard_arrow_right_24
            )
        )

        val activityList = HealthSummaryList(suggestionsList)
        healthSummaryLiveData.postValue(activityList)
    }

    suspend fun getLabsList() {

        val suggestionsList = mutableListOf<LabsListItems>()
        // Category A
        suggestionsList.add(
            LabsListItems(
                "SARS-cov+SARS-cov-2(Covid-19) Ag [Presence] in Respiratory specimen by rapid immunoassay", "26/10/2023","Detected"
            )
        )
        suggestionsList.add(
            LabsListItems(
                "Blood Group", "26/10/2023","Group AB"
            )
        )
        suggestionsList.add(
            LabsListItems(
                "Rh in Blood", "26/10/2023","Positive"
            )
        )

        suggestionsList.add(
            LabsListItems(
                "UROBILINOGEN", "26/10/2023","0.3 mg/dl"
            )
        )

        val activityList = LabsList(suggestionsList)
        labsLiveData.postValue(activityList)
    }


}