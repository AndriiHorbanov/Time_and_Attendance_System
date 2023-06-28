package com.example.workercontroller.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import com.example.workercontroller.R
import com.example.workercontroller.ViewModl.WorkerViewModel
import com.example.workercontroller.databinding.FragmentAdminWindowBinding
import kotlinx.coroutines.launch

class MainScreen : Fragment() {


    private lateinit var binding: FragmentAdminWindowBinding
    private val sharedViewModel: WorkerViewModel by activityViewModels()


    override fun onResume() {
        super.onResume()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminWindowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeState()
        binding.testButtonSet.setOnClickListener {
            sharedViewModel.addData(binding.testSetText.toString())
        }
        binding.otwarcie.setOnClickListener {
            it.findNavController().navigate(R.id.action_adminWindow_to_mainMenu)
        }

    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                sharedViewModel.uiState.collect { state ->
                    binding.testTextData.text = state.test
                }
            }
        }
    }
}