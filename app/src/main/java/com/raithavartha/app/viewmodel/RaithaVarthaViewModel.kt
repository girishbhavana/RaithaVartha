package com.raithavartha.app.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.raithavartha.app.data.MockAdvisoryData
import com.raithavartha.app.model.Advisory
import com.raithavartha.app.model.FarmerProfile

class RaithaVarthaViewModel : ViewModel() {
    val advisories: List<Advisory> = MockAdvisoryData.advisories
    val filters: List<String> = MockAdvisoryData.cropFilters
    val profile = FarmerProfile()

    var farmerName by mutableStateOf("")
        private set

    var selectedFilter by mutableStateOf("All")
        private set

    var searchQuery by mutableStateOf("")
        private set

    var expertProblem by mutableStateOf("")
        private set

    private val savedIds = mutableStateListOf<Int>()

    val filteredAdvisories: List<Advisory>
        get() = filterAdvisories(selectedFilter)

    val savedAdvisories: List<Advisory>
        get() = advisories.filter { it.id in savedIds }

    fun login(name: String) {
        farmerName = name.ifBlank { "Farmer" }
    }

    fun selectFilter(filter: String) {
        selectedFilter = filter
    }

    fun updateSearch(query: String) {
        searchQuery = query
    }

    fun updateExpertProblem(problem: String) {
        expertProblem = problem
    }

    fun toggleSaved(advisoryId: Int) {
        if (savedIds.contains(advisoryId)) {
            savedIds.remove(advisoryId)
        } else {
            savedIds.add(advisoryId)
        }
    }

    fun isSaved(advisoryId: Int): Boolean = advisoryId in savedIds

    fun advisoryById(id: Int): Advisory? = advisories.firstOrNull { it.id == id }

    fun filterAdvisories(filter: String): List<Advisory> {
        return if (filter == "All") advisories else advisories.filter { it.cropEnglish == filter }
    }

    fun searchResults(): List<Advisory> {
        val query = searchQuery.trim().lowercase()
        if (query.isBlank()) return advisories
        return advisories.filter { advisory ->
            listOf(
                advisory.cropEnglish,
                advisory.cropKannada,
                advisory.category,
                advisory.titleEnglish,
                advisory.titleKannada,
                advisory.tipEnglish,
                advisory.tipKannada
            ).any { it.lowercase().contains(query) } ||
                advisory.diseaseKeywords.any { it.lowercase().contains(query) }
        }
    }
}
