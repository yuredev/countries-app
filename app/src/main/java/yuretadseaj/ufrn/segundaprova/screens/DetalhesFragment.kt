package yuretadseaj.ufrn.segundaprova.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import yuretadseaj.ufrn.segundaprova.R
import yuretadseaj.ufrn.segundaprova.databinding.FragmentDetalhesBinding
import yuretadseaj.ufrn.segundaprova.repositories.CountryRepository

class DetalhesFragment : Fragment() {
    private lateinit var binding: FragmentDetalhesBinding
    private lateinit var countryRepository: CountryRepository

    override fun onAttach(context: Context) {
        super.onAttach(context)
        countryRepository = CountryRepository(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false)
        val args = AlteraFragmentArgs.fromBundle(arguments!!)
        val chosenCountry = countryRepository.findById(args.countryId)

        binding.textViewCountryName.text = chosenCountry.name
        binding.textViewCountryCapital.text = chosenCountry.capital
        binding.textViewCountryArea.text = chosenCountry.area.toString()
        binding.textViewCountryPopulation.text = chosenCountry.population.toString()
        binding.textViewCountryCurrency.text = chosenCountry.currency
        binding.textViewCountryLanguage.text = chosenCountry.language

        return binding.root
    }
}