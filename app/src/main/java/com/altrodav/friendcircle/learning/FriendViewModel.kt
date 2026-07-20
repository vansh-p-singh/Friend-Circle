package com.altrodav.friendcircle.learning

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FriendViewModel: ViewModel() {
    private val friendsFlow = MutableStateFlow(friendList)
    private val searchQuery = MutableStateFlow("")

    val filteredFriends =
        combine(
            friendsFlow,
            searchQuery
        ) { friends, query ->

            friends.filter {
                it.name.contains(query, ignoreCase = true)
            }
                .map {
                    it.copy(name = it.name.uppercase())
                }

        }.stateIn(
            initialValue = friendList,
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
        )
    fun updateSearchQuery(newQuery: String) {
        searchQuery.value = newQuery
    }
}


