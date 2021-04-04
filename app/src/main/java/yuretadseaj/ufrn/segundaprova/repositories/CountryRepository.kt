package yuretadseaj.ufrn.segundaprova.repositories

import android.annotation.SuppressLint
import android.os.AsyncTask
import yuretadseaj.ufrn.segundaprova.dao.CountryDAO
import yuretadseaj.ufrn.segundaprova.models.Country

class CountryRepository(val countryDAO: CountryDAO) {


    private inner class InsertAsyncTask() : AsyncTask<Country, Unit, Unit>() {
        override fun doInBackground(vararg params: Country?) {
            return countryDAO.insert(params[0]!!)
        }
    }

    private inner class FindByIdAsyncTask() : AsyncTask<Int, Unit, Country>() {
        override fun doInBackground(vararg params: Int?): Country {
            return countryDAO.findById(params[0]!!)
        }
    }
}