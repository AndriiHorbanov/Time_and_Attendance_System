package com.example.workercontroller.ViewModl

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.workercontroller.fragments.HealpData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class WorkerViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(WorkerState())
    val uiState: StateFlow<WorkerState> = _uiState.asStateFlow()

    private val currentUiState
        get() = uiState.value

//    val assetManager = application.assets

    fun updateHelpList(uiList: List<HealpData> ) {
        _uiState.update { state ->
            state.copy(listHelpData = uiList)
        }
    }

    fun updatePdf(position: String ) {
        _uiState.update { state ->
            state.copy(currentPositionPdf = position)
        }
    }

}