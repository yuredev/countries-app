package yuretadseaj.ufrn.segundaprova.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import yuretadseaj.ufrn.segundaprova.R
import yuretadseaj.ufrn.segundaprova.models.Country

class CountryAdapter() : RecyclerView.Adapter<CountryViewHolder>() {
    var countries = mutableListOf<Country>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_inflater, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val chosenCountry = countries[position]
        holder.countryName.text = chosenCountry.name
    }

    override fun getItemCount() = countries.size
}

class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val countryName: TextView = view.findViewById(R.id.textViewCountryName)
}