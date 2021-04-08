package yuretadseaj.ufrn.segundaprova.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import yuretadseaj.ufrn.segundaprova.models.Country
import yuretadseaj.ufrn.segundaprova.repositories.CountryRepository

class CadastraFragmentViewModel(app: Application) : AndroidViewModel(app) {
    var countryName = MutableLiveData<String>()
    var countryCapital = MutableLiveData<String>()
    var countryPopulation = MutableLiveData(0)
    var countryArea = MutableLiveData<Double>(0.0)
    var countryLanguage = MutableLiveData<String>()
    var countryCurrency = MutableLiveData<String>()
    private val countryRepository = CountryRepository(app.applicationContext)

    val country: Country
        get() = Country(
            countryName.value!!,
            countryLanguage.value!!,
            countryCapital.value!!,
            countryCurrency.value!!,
            countryPopulation.value!!,
            countryArea.value!!
        )

    fun saveCountry() {
        countryRepository.insert(this.country)
        println("todos paises: ${countryRepository.findAll()}")
    }

}