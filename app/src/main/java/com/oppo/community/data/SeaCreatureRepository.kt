package com.oppo.community.data

import com.oppo.community.common.CommunityService
import com.oppo.community.model.SeaCreature

interface SeaCreatureRepository {
    suspend fun fetchSeaCreatures(): List<SeaCreature>
}

class SeaCreatureRepositoryImpl(private val service: CommunityService) : SeaCreatureRepository {
    override suspend fun fetchSeaCreatures(): List<SeaCreature> = service.fetchSeaCreatures()

}