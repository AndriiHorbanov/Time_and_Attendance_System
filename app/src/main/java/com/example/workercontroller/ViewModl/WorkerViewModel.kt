package com.example.workercontroller.ViewModl

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class WorkerViewModel : ViewModel() {
    private val _state = MutableStateFlow(WorkerState())
    val state: StateFlow<WorkerState> = _state.asStateFlow()

    fun updateTimeList(currentFragment: Fragments) {
        _state.update { state ->
            state.copy(fragment = currentFragment)
        }
    }

    enum class Fragments {
        Register,
        AdminMenu

    }

}