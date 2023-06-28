package com.example.workercontroller.ViewModl

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.workercontroller.date.DataRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val application: Application,
    private val dataRepository: DataRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WorkerViewModel::class.java)) {
            return WorkerViewModel(application, dataRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}