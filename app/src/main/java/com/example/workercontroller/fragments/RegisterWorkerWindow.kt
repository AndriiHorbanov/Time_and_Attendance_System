package com.example.workercontroller.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.workercontroller.R
import com.example.workercontroller.ViewModl.WorkerViewModel
import com.example.workercontroller.databinding.FragmentAdminWindowBinding

class RegisterWorkerWindow : Fragment() {


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
        binding.register.setOnClickListener {
//            sharedViewModel.updateTimeList(true)
            it.findNavController().navigate(R.id.action_adminWindow_to_mainMenu)

        }
    }

}