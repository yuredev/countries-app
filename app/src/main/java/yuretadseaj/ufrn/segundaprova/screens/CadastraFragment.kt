package yuretadseaj.ufrn.segundaprova.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import yuretadseaj.ufrn.segundaprova.R
import yuretadseaj.ufrn.segundaprova.databinding.FragmentCadastraBinding
import yuretadseaj.ufrn.segundaprova.viewmodels.CadastraFragmentViewModel

class CadastraFragment : Fragment() {
    private lateinit var binding: FragmentCadastraBinding
    private lateinit var viewModel: CadastraFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra, container, false)
        viewModel = ViewModelProvider(this).get(CadastraFragmentViewModel::class.java)
        binding.viewModel = viewModel


        binding.buttonInsert.setOnClickListener {
            viewModel.saveCountry()
        }

        return binding.root
    }

}