package com.pisces.business.data

import com.pisces.business.common.BusinessService
import com.pisces.business.model.Friend

interface FriendRepository {
    suspend fun fetchFriends(): List<Friend>
}

class FriendRepositoryImpl(private val service: BusinessService) : FriendRepository {
    override suspend fun fetchFriends(): List<Friend> = service.fetchFriends()
}