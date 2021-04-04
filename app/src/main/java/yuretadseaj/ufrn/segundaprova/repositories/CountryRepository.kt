package yuretadseaj.ufrn.segundaprova.repositories

import android.annotation.SuppressLint
import android.os.AsyncTask
import yuretadseaj.ufrn.segundaprova.dao.CountryDAO
import yuretadseaj.ufrn.segundaprova.models.Country

class CountryRepository(private val countryDAO: CountryDAO) {

    fun findAll(): List<Country> {
        return FindAllAsyncTask().execute().get()
    }

    fun findById(id: Int): Country {
        return FindByIdAsyncTask().execute(id).get()
    }

    fun insert(vararg countries: Country) {
        InsertAsyncTask().execute(*countries).get()
    }

    fun update(vararg countries: Country) {
        UpdateAsyncTask().execute(*countries)
    }

    fun delete(vararg countries: Country) {
        DeleteAsyncTask().execute(*countries)
    }

    @SuppressLint("StaticFieldLeak")
    private inner class FindByIdAsyncTask() : AsyncTask<Int, Unit, Country>() {
        override fun doInBackground(vararg params: Int?): Country {
            return countryDAO.findById(params[0]!!)
        }
    }

    @SuppressLint("StaticFieldLeak")
    private inner class FindAllAsyncTask() : AsyncTask<Unit, Unit, List<Country>>() {
        override fun doInBackground(vararg params: Unit?): List<Country> {
            return countryDAO.findAll()
        }
    }

    @SuppressLint("StaticFieldLeak")
    private inner class InsertAsyncTask() : AsyncTask<Country, Unit, Unit>() {
        override fun doInBackground(vararg countries: Country?) {
            countries.forEach {
                countryDAO.insert(it!!)
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    private inner class UpdateAsyncTask() : AsyncTask<Country, Unit, Unit>() {
        override fun doInBackground(vararg countries: Country?) {
            countries.forEach {
                countryDAO.update(it!!)
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    private inner class DeleteAsyncTask() : AsyncTask<Country, Unit, Unit>() {
        override fun doInBackground(vararg countries: Country?) {
            countries.forEach {
                countryDAO.delete(it!!)
            }
        }
    }
}
