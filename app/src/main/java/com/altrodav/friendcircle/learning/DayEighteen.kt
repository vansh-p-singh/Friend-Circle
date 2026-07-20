package com.altrodav.friendcircle.learning

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn


data class FriendTest(val id:Int,val name: String)

val friendList=listOf<FriendTest>(
    FriendTest(1,"Vansh"),
    FriendTest(2,"Reeta"),
    FriendTest(3,"Seeta"),
    FriendTest(4,"Geeta"),
    FriendTest(5,"Roshni")
)


