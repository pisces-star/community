package com.oppo.community.domain

import com.oppo.community.common.UseCase
import com.oppo.community.data.SeaCreatureRepository
import com.oppo.community.model.SeaCreature
import kotlinx.coroutines.CoroutineDispatcher

class FetchSeaCreaturesUseCase(private val repository: SeaCreatureRepository, dispatcher: CoroutineDispatcher) :
    UseCase<Unit, List<SeaCreature>>(dispatcher) {
    override suspend fun execute(parameters: Unit): List<SeaCreature> {
        return repository.fetchSeaCreatures()
    }
}