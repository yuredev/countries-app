package yuretadseaj.ufrn.segundaprova.screens

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import yuretadseaj.ufrn.segundaprova.R
import yuretadseaj.ufrn.segundaprova.RecyclerViewClickListener
import yuretadseaj.ufrn.segundaprova.CountryAdapter
import yuretadseaj.ufrn.segundaprova.databinding.FragmentHomeBinding
import yuretadseaj.ufrn.segundaprova.models.Country
import yuretadseaj.ufrn.segundaprova.repositories.CountryRepository
import yuretadseaj.ufrn.segundaprova.viewmodels.HomeFragmentViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var ctx: Context
    private lateinit var countryRepository: CountryRepository
    private lateinit var viewModel: HomeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        val adapter = CountryAdapter()
        binding.recyclerview.adapter = adapter

        viewModel.refreshCountries()
        viewModel.countries.observe(viewLifecycleOwner, Observer {
            adapter.countries = it as MutableList<Country>
            adapter.notifyDataSetChanged()
        })

        val layout = LinearLayoutManager(this.context!!, LinearLayoutManager.VERTICAL, false)
        binding.recyclerview.layoutManager = layout

        binding.recyclerview.addOnItemTouchListener(
            RecyclerViewClickListener(this.requireContext(),
                binding.recyclerview,
                object : RecyclerViewClickListener.OnItemCLickListener {
                    override fun onItemClick(v: View, position: Int) {
                        val chosenCountry = viewModel.countries.value!![position]
                        Navigation.findNavController(v)
                            .navigate(
                                HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(
                                    chosenCountry.id
                                )
                            )
                    }

                    override fun onItemLongClick(v: View, position: Int) {
                        val chosenCountry = viewModel.countries.value!![position]
                        Navigation.findNavController(v)
                            .navigate(
                                HomeFragmentDirections.actionHomeFragmentToAlteraFragment(
                                    chosenCountry.id
                                )
                            )
                    }
                })
        )

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
        countryRepository = CountryRepository(ctx)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, this.findNavController()) || super.onOptionsItemSelected(item)
    }
}
