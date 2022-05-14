package com.pisces.business.common

import com.pisces.business.model.Friend
import retrofit2.http.GET

interface BusinessService {
    @GET("/friends")
    suspend fun fetchFriends(): List<Friend>
}
