package com.example.aplicacio
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.aplicacio.DB.PeliculasDBHelper
import com.google.android.material.bottomnavigation.BottomNavigationView


/*mostrará el menú principal, que está enlazado con DBHelper*/
class Activity_Main : AppCompatActivity() {
    companion object {
        lateinit var dbHelper:PeliculasDBHelper
    }


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNav: BottomNavigationView = findViewById(R.id.main_menu)

        dbHelper = PeliculasDBHelper(this)



        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(MainFragment())
                    true
                }
                R.id.nav_form -> {

                    loadFragment(FormFragment(dbHelper))
                    true

                }
                R.id.nav_list -> {
                    loadFragment(ListFragment(dbHelper))
                    true
                }
                else -> {
                    false
                }
            }

        }


    }
    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }


    private  fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }

}