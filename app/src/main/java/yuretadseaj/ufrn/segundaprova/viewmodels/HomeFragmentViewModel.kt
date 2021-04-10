package yuretadseaj.ufrn.segundaprova.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import yuretadseaj.ufrn.segundaprova.models.Country
import yuretadseaj.ufrn.segundaprova.repositories.CountryRepository

class HomeFragmentViewModel(app: Application) : AndroidViewModel(app) {
    var countries: LiveData<List<Country>>
    private val countryRepository = CountryRepository(app.applicationContext)

    init {
        countries = countryRepository.findAll()
    }
}