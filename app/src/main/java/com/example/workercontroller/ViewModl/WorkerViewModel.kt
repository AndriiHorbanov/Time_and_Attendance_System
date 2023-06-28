package com.example.workercontroller.ViewModl

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.workercontroller.date.DataRepository
import com.example.workercontroller.date.DatasDatabase
import com.example.workercontroller.date.DatasEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class WorkerViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(WorkerState())
    val uiState: StateFlow<WorkerState> = _uiState.asStateFlow()

    private var count = 1
    private var lastInfo = DatasEntity()

    val repository: DataRepository

    init {
        collectData()
        val dataDao = DatasDatabase.getDatabase(application).datasDao()
        repository = DataRepository(dataDao)
    }

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

    fun setValue(value: String){
        lastInfo = lastInfo.copy(someDAta = value)
    }

    fun collectData(){
        viewModelScope.launch {
            repository.readAllData().collect{ list ->
                count = list.size
                updateTest(list)
            }
        }
    }

    fun updateTest(list: List<DatasEntity>){
        var name = "" + "f"
        list.map {
            name = it.someDAta
        }
        _uiState.update { state ->
            state.copy(
                test = name
            )
        }
    }


    fun addData(value: String){
        viewModelScope.launch(Dispatchers.IO){
            repository.addDatas(lastInfo.copy(id = count, someDAta = value))
        }
    }



}