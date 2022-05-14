package com.pisces.business.domain

import com.pisces.business.common.UseCase
import com.pisces.business.data.FriendRepository
import com.pisces.business.model.Friend
import kotlinx.coroutines.CoroutineDispatcher

class FetchFriendsUseCase(private val friendRepository: FriendRepository, dispatcher: CoroutineDispatcher) :
    UseCase<Unit, List<Friend>>(dispatcher) {
    override suspend fun execute(parameters: Unit): List<Friend> {
        return friendRepository.fetchFriends()
    }
}