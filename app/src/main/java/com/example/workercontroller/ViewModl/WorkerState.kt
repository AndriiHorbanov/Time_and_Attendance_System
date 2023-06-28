package com.example.workercontroller.ViewModl

import android.provider.ContactsContract.Data
import com.example.workercontroller.fragments.HealpData

data class WorkerState(
    val listHelpData: List<HealpData> = emptyList(),
    val currentPositionPdf: String = "",
    val test: String = ""
)
