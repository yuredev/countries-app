package yuretadseaj.ufrn.segundaprova.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import yuretadseaj.ufrn.segundaprova.R
import yuretadseaj.ufrn.segundaprova.adapters.CountryAdapter
import yuretadseaj.ufrn.segundaprova.databinding.FragmentHomeBinding
import yuretadseaj.ufrn.segundaprova.models.Country
import yuretadseaj.ufrn.segundaprova.repositories.CountryRepository
import yuretadseaj.ufrn.segundaprova.viewmodels.HomeFragmentViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var ctx: Context
    private lateinit var countryRepository: CountryRepository
    private lateinit var viewModel: HomeFragmentViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
        countryRepository = CountryRepository(ctx)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        val adapter = CountryAdapter()
        binding.recyclerview.adapter = adapter

        binding.button.setOnClickListener {
            viewModel.insertCountry(
                Country(
                    "Russia",
                    "Russo",
                    "Moskow",
                    "moeda russa la",
                    60000000,
                    8955211.5
                )
            )
        }

        viewModel.countries.observe(viewLifecycleOwner, Observer {
            adapter.countries = it as MutableList<Country>
            adapter.notifyDataSetChanged()
        })

        val layout = LinearLayoutManager(this.context!!, LinearLayoutManager.VERTICAL, false)
        binding.recyclerview.layoutManager = layout

        return binding.root
    }
}
