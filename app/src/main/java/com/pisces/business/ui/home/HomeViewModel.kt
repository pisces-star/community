package com.pisces.business.ui.home

import com.pisces.business.common.BaseViewModel
import com.pisces.business.domain.FetchFriendsUseCase

class HomeViewModel(private val friendsUseCase: FetchFriendsUseCase) :
    BaseViewModel<HomeContract.State, HomeContract.Event, HomeContract.Effect>() {
    override fun handleEvent(event: HomeContract.Event) {
        setState {
            copy()
        }
    }

    override fun createInitialState(): HomeContract.State {
        return HomeContract.State(
            "",
            HomeContract.LoadStatus.LoadMoreInit,
            HomeContract.RefreshStatus.RefreshInit
        )
    }
}