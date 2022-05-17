package com.oppo.community.domain

import com.oppo.community.common.UseCase
import com.oppo.community.data.FriendRepository
import com.oppo.community.model.Friend
import kotlinx.coroutines.CoroutineDispatcher

class FetchFriendsUseCase(private val friendRepository: FriendRepository, dispatcher: CoroutineDispatcher) :
    UseCase<Unit, List<Friend>>(dispatcher) {
    override suspend fun execute(parameters: Unit): List<Friend> {
        return friendRepository.fetchFriends()
    }
}