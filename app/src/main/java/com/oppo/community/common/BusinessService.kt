package com.oppo.community.common

import com.oppo.community.model.Friend
import retrofit2.http.GET

interface BusinessService {
    @GET("/friends")
    suspend fun fetchFriends(): List<Friend>
}
