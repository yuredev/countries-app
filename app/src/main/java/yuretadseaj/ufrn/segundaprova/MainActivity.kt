package yuretadseaj.ufrn.segundaprova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.room.Room
import yuretadseaj.ufrn.segundaprova.database.AppDatabase
import yuretadseaj.ufrn.segundaprova.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawer)
        NavigationUI.setupWithNavController(binding.navigationView, navController)
    }

    override fun onSupportNavigateUp(): Boolean{
        val navController = Navigation.findNavController(this, R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, binding.drawer)
    }
}