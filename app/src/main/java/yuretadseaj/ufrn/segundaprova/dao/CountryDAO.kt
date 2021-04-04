package yuretadseaj.ufrn.segundaprova.dao

import androidx.room.*
import yuretadseaj.ufrn.segundaprova.models.Country

@Dao
interface CountryDAO {
    @Query("SELECT * FROM Country")
    fun findAll(): List<Country>

    @Query("SELECT * FROM Country WHERE id=:id")
    fun findById(id: Int): Country

    @Insert
    fun insert(vararg countries: Country)

    @Delete
    fun delete(country: Country): Int

    @Update
    fun update(country: Country)
}