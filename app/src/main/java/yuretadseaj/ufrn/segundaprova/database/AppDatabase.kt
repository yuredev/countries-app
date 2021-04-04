package yuretadseaj.ufrn.segundaprova.database

import androidx.room.Database
import androidx.room.RoomDatabase
import yuretadseaj.ufrn.segundaprova.dao.CountryDAO
import yuretadseaj.ufrn.segundaprova.models.Country

@Database(entities = [Country::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDAO
}