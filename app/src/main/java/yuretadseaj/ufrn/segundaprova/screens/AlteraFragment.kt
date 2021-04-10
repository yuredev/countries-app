package yuretadseaj.ufrn.segundaprova.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import yuretadseaj.ufrn.segundaprova.R
import yuretadseaj.ufrn.segundaprova.databinding.FragmentAlteraBinding
import yuretadseaj.ufrn.segundaprova.viewmodels.AlteraFragmentViewModel

class AlteraFragment : Fragment() {
    private lateinit var binding: FragmentAlteraBinding
    private lateinit var viewModel: AlteraFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        viewModel = ViewModelProvider(this).get(AlteraFragmentViewModel::class.java)
        binding.viewModel = viewModel


        val args = AlteraFragmentArgs.fromBundle(arguments!!)
        viewModel.feedCountriesForm(args.countryId)

        binding.buttonInsert.setOnClickListener {
            viewModel.saveCountry()
        }

        return binding.root
    }
}