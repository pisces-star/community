package com.oppo.community.data

import com.oppo.community.common.BusinessService
import com.oppo.community.model.Friend

interface FriendRepository {
    suspend fun fetchFriends(): List<Friend>
}

class FriendRepositoryImpl(private val service: BusinessService) : FriendRepository {
    override suspend fun fetchFriends(): List<Friend> = service.fetchFriends()
}