package com.example.workercontroller.ViewModl

import com.example.workercontroller.fragments.HealpData

data class WorkerState(
    val listHelpData: List<HealpData> = emptyList(),
    val currentPositionPdf: String = ""
)
