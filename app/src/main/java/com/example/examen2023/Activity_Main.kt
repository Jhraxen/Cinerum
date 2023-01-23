package com.example.examen2023
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.aplicacio.R
import com.example.examen2023.DB.PeliculasDBHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import model.ApiCall
import model.ModelApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/*mostrará el menú principal, que está enlazado con DBHelper*/
class Activity_Main : AppCompatActivity() {
    companion object {
        lateinit var dbHelper:PeliculasDBHelper
    }


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNav: BottomNavigationView = findViewById(R.id.main_menu)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.sunrise-sunset.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiCall = retrofit.create(ApiCall::class.java)

        val call: Call<ModelApi?>? = apiCall.getData("32","3")


        dbHelper = PeliculasDBHelper(this)


        call?.enqueue(object : Callback<ModelApi?> {
            override fun onResponse(call: Call<ModelApi?>, response: Response<ModelApi?>) {
                if (response.code() !== 200) {
                    Log.i("testApi", "checkConnection")
                    return
                }
                Log.i(
                    "testApi",
                    response.body()?.status + " - " + response.body()?.results?.sunrise
                )
            }

            override fun onFailure(call: Call<ModelApi?>?, t: Throwable?) {}
        })


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