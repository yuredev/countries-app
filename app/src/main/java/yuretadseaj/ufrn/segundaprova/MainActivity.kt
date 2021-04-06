package yuretadseaj.ufrn.segundaprova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }

}