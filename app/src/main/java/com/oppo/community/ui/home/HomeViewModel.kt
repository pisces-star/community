package com.oppo.community.ui.home

import androidx.lifecycle.viewModelScope
import com.oppo.community.common.BaseViewModel
import com.oppo.community.domain.FetchSeaCreaturesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val fetchSeaCreaturesUseCase: FetchSeaCreaturesUseCase) :
    BaseViewModel<HomeContract.State, HomeContract.Event, HomeContract.Effect>() {
    override fun handleEvent(event: HomeContract.Event) {
        setState {
            copy()
        }
    }

    init {
        viewModelScope.launch {
            fetchSeaCreaturesUseCase(Unit)
        }
    }

    override fun createInitialState(): HomeContract.State {
        return HomeContract.State(
            "海洋生物",
            HomeContract.LoadStatus.LoadMoreInit,
            HomeContract.RefreshStatus.RefreshInit
        )
    }
}