package yuretadseaj.ufrn.segundaprova.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import yuretadseaj.ufrn.segundaprova.R
import yuretadseaj.ufrn.segundaprova.adapters.CountryAdapter
import yuretadseaj.ufrn.segundaprova.databinding.FragmentHomeBinding
import yuretadseaj.ufrn.segundaprova.models.Country
import yuretadseaj.ufrn.segundaprova.repositories.CountryRepository

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var ctx: Context
    private lateinit var countryRepository: CountryRepository

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
        countryRepository = CountryRepository(ctx)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val adapter = CountryAdapter(countryRepository.findAll())

        println("countries: " + countryRepository.findAll().toString())
        binding.recyclerview.adapter = adapter

        val layout = LinearLayoutManager(this.context!!, LinearLayoutManager.VERTICAL, false)
        binding.recyclerview.layoutManager = layout

        return binding.root
    }
}