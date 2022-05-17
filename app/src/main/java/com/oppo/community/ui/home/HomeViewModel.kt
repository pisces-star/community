package com.oppo.community.ui.home

import com.oppo.community.common.BaseViewModel
import com.oppo.community.domain.FetchSeaCreaturesUseCase

class HomeViewModel(private val friendsUseCase: FetchSeaCreaturesUseCase) :
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