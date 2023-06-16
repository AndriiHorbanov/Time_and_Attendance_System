package com.example.workercontroller.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.workercontroller.R
import com.example.workercontroller.ViewModl.WorkerViewModel
import com.example.workercontroller.databinding.FragmentOpenShiftBinding

class OpeningShift : Fragment() {



    private val sharedViewModel: WorkerViewModel by activityViewModels()
    private lateinit var binding: FragmentOpenShiftBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOpenShiftBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        initHelpList()
        setAdapter()
        updateAdapter()

//        check()
    }

    private fun updateAdapter(){
        binding.switchOpenClose.setOnClickListener{
            initHelpList()
            setAdapter()
        }
    }


    private fun initHelpList() {
        val open: List<HealpData> = listOf(
            HealpData("first", "https://red-madel-62.tiiny.site/", true),
            HealpData("second", "https://red-madel-62.tiiny.site/", true),
            HealpData("third", "https://red-madel-62.tiiny.site/", true),
            HealpData("fifth", "https://red-madel-62.tiiny.site/", true),
            HealpData("five", "https://red-madel-62.tiiny.site/", true),
            HealpData("six", "https://red-madel-62.tiiny.site/", true),
            HealpData("seven", "https://red-madel-62.tiiny.site/", true)
        )

        val close: List<HealpData> = listOf(
            HealpData("1", "https://red-madel-62.tiiny.site/", true),
            HealpData("2", "https://red-madel-62.tiiny.site/", true),
            HealpData("3", "https://red-madel-62.tiiny.site/", true),
            HealpData("4", "https://red-madel-62.tiiny.site/", true),
            HealpData("5", "https://red-madel-62.tiiny.site/", true),
            HealpData("6", "https://red-madel-62.tiiny.site/", true),
            HealpData("7", "https://red-madel-62.tiiny.site/", true)
        )

        if (binding.switchOpenClose.isChecked){
            sharedViewModel.updateHelpList(close)
            binding.titleWork.text = resources.getText(R.string.end_work)
        }else{
            sharedViewModel.updateHelpList(open)
            binding.titleWork.text = resources.getText(R.string.start_work)
        }


    }

    private fun setAdapter() {
        binding.helpRecycler.adapter = RecyclerAdapter(navController, sharedViewModel.uiState.value.listHelpData, sharedViewModel)
    }



//    fun check() {
//        binding.close.setOnClickListener {
//            val listaCheckBox = with(binding) {
//                listOf(alarm, swiatwo, komputer, odbicie, zadania, vpn, inpos, kasa)
//            }
//
//            if (listaCheckBox.all { it.isChecked }) {
//                it.findNavController().navigate(R.id.action_mainMenu_to_adminWindow)
//            } else {
//                listaCheckBox.forEach { checkBox ->
//                    if (!checkBox.isChecked) {
//                        checkBox.setTextColor(Color.RED)
//                    }
//                }
//            }
//        }
//
//        binding.pytajnik.setOnClickListener{
//            it.findNavController().navigate(R.id.action_mainMenu_to_openingHealp)
//        }
//    }


}