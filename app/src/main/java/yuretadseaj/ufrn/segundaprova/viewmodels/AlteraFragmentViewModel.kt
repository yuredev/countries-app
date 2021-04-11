package yuretadseaj.ufrn.segundaprova.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import yuretadseaj.ufrn.segundaprova.models.Country
import yuretadseaj.ufrn.segundaprova.repositories.CountryRepository

class AlteraFragmentViewModel(app: Application) : AndroidViewModel(app) {
    var countryId = MutableLiveData<Int>(null)
    var countryName = MutableLiveData<String>()
    var countryCapital = MutableLiveData<String>()
    var countryPopulation = MutableLiveData(0)
    var countryArea = MutableLiveData<Double>(0.0)
    var countryLanguage = MutableLiveData<String>()
    var countryCurrency = MutableLiveData<String>()
    private val countryRepository = CountryRepository(app.applicationContext)

    var country: Country
        get() {
            val countryToReturn = Country(
                countryName.value!!,
                countryLanguage.value!!,
                countryCapital.value!!,
                countryCurrency.value!!,
                countryPopulation.value!!,
                countryArea.value!!
            )
            countryToReturn.id = countryId.value!!
            return countryToReturn
        }
        set(country) {
            countryId.value = country.id
            countryName.value = country.name
            countryLanguage.value = country.language
            countryCapital.value = country.capital
            countryCurrency.value = country.currency
            countryPopulation.value = country.population
            countryArea.value = country.area
        }

    fun feedCountriesForm(id: Int) {
        val countryFound = countryRepository.findById(id)
        country = countryFound
    }

    fun saveCountry() {
        countryRepository.update(country)
    }
}