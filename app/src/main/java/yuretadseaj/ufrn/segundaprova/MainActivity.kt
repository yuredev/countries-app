package yuretadseaj.ufrn.segundaprova

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import yuretadseaj.ufrn.segundaprova.database.AppDatabase

class MainActivity : AppCompatActivity() {

    private val database: AppDatabase by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "countries.db.sqlite"
        ).allowMainThreadQueries().build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runAsyncTask()
    }

    private fun runAsyncTask() {
        val task = LoadCountriesTask()
        task.execute()
    }

    private inner class LoadCountriesTask : AsyncTask<Unit, Int, Int>() {
        override fun doInBackground(vararg params: Unit?): Int? {
            return 1
        }
    }
}