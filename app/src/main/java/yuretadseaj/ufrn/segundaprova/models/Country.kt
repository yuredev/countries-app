package yuretadseaj.ufrn.segundaprova.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Country(
    var name: String,
    var language: String,
    var capital: String,
    var currency: String,
    var population: Int,
    var area: Double
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
