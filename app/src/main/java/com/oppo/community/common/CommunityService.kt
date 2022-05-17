package com.oppo.community.common

import com.oppo.community.model.SeaCreature
import retrofit2.http.GET

interface CommunityService {
    @GET("sea")
    suspend fun fetchSeaCreatures(): List<SeaCreature>
}

