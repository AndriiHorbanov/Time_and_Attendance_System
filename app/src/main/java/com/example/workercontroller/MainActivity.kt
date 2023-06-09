package com.example.workercontroller

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.workercontroller.ViewModl.ViewModelFactory
import com.example.workercontroller.ViewModl.WorkerViewModel
import com.example.workercontroller.databinding.ActivityMainBinding
import com.example.workercontroller.date.DataRepository
import com.example.workercontroller.date.DatasDatabase
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private val sharedViewModel: WorkerViewModel by viewModels()
    {
        ViewModelFactory(application, DataRepository(DatasDatabase.getDatabase(application).datasDao()))
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        observeState()
        initNavController()
    }




    private fun initBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initNavController() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                sharedViewModel.uiState.collect { state ->

                }
            }
        }
    }

}