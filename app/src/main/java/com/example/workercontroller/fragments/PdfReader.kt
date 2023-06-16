package com.example.workercontroller.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.workercontroller.ViewModl.WorkerViewModel
import com.example.workercontroller.databinding.FragmentPdfReaderBinding


class PdfReader : Fragment() {

    private lateinit var binding: FragmentPdfReaderBinding
    private val sharedViewModel: WorkerViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPdfReaderBinding.inflate(inflater, container, false)
        return binding.root



    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.allowFileAccess = true
        binding.webView.loadUrl(sharedViewModel.uiState.value.currentPositionPdf)
    }



}