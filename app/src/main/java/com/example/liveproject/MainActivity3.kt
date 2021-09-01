package com.example.liveproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.addTextChangedListener
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import java.util.Locale.filter

class MainActivity3 : AppCompatActivity() {
    lateinit var navigationView: NavigationView
    lateinit var adapter: readapter
    val list:ArrayList<DataModel> = ArrayList<DataModel>()
    lateinit var drawerLayout: DrawerLayout
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var toolbar: Toolbar
    lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        bottomNavigationView = findViewById(R.id.navigation)
        navigationView = findViewById(R.id.navigationview)
        drawerLayout = findViewById(R.id.dra)
        toolbar = findViewById(R.id.tool1)


        toolbar.setNavigationIcon(R.drawable.ic_baseline_dehaze_24)
        toolbar.setTitle("Intraday")
        setSupportActionBar(toolbar)

        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.isDrawerIndicatorEnabled = true


        val header: View = navigationView.getHeaderView(0)
        val login: TextView = header.findViewById(R.id.login)
        val sign: TextView = header.findViewById(R.id.sign)
        val guest:TextView=header.findViewById(R.id.guest)
        val lash:TextView=header.findViewById(R.id.lash)
        login.setOnClickListener {
            val intent=Intent(this,MainActivity6::class.java)
            startActivity(intent)
        }
        sign.setOnClickListener {
            val intent=Intent(this,MainActivity6::class.java)
            startActivity(intent)
        }
        val sharedPreferences:SharedPreferences=this.getSharedPreferences("USER",Context.MODE_PRIVATE)
        val sharevalue=sharedPreferences.getString("email","")
        if(sharevalue.equals("")){
            guest.setText("Guest User")
        }else{
            guest.setText(sharevalue)
            login.visibility=View.GONE
            sign.visibility=View.GONE
            lash.visibility=View.GONE
            Log.e("email>>",sharevalue+"")
        }

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.intra -> {
                    val fragment = BlankFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                    navigationView.setCheckedItem(R.id.intra2)
                    toolbar.setTitle("Intraday")
                    true
                }
                R.id.sterm -> {
                    val fragment = BlankFragment2()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                    navigationView.setCheckedItem(R.id.sterm2)
                    toolbar.setTitle("Short term")
                    true
                }
                R.id.lterm -> {
                    val fragment = BlankFragment3()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                    navigationView.setCheckedItem(R.id.lterm2)
                    toolbar.setTitle("Long term")
                    true
                }
                R.id.detail -> {
                    val fragment = BlankFragment4()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                    navigationView.setCheckedItem(R.id.detail2)
                    toolbar.setTitle("Details")
                    true
                }
                R.id.contest -> {
                    val fragment = BlankFragment5()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                    navigationView.setCheckedItem(R.id.contest2)
                    toolbar.setTitle("Contest")
                    true
                }

                else -> false
            }
        }



        val screen: String? = intent.getStringExtra("fragment")
        Log.e("screnn>>>>", screen + "")

        if (screen.equals("Intraday")) {
            toolbar.setTitle("Intraday")
            bottomNavigationView.setSelectedItemId(R.id.intra)
            navigationView.setCheckedItem(R.id.intra2)
            val fragment = BlankFragment()
            supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
            true
        } else if (screen.equals("Short term")) {
            bottomNavigationView.setSelectedItemId(R.id.sterm)
            navigationView.setCheckedItem(R.id.sterm2)
            toolbar.setTitle("Short term")
            val fragment = BlankFragment2()
            supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
            true
        } else if (screen.equals("Long term")) {
            toolbar.setTitle("Long term")
            bottomNavigationView.setSelectedItemId(R.id.lterm)
            navigationView.setCheckedItem(R.id.lterm2)
            val fragment = BlankFragment3()
            supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
            true
        } else if (screen.equals("Details")) {
            toolbar.setTitle("Details")
            bottomNavigationView.setSelectedItemId(R.id.detail)
            navigationView.setCheckedItem(R.id.detail2)
            val fragment = BlankFragment4()
            supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
            true
        } else if (screen.equals("Contest")) {
            toolbar.setTitle("Contest")
            bottomNavigationView.setSelectedItemId(R.id.contest)
            navigationView.setCheckedItem(R.id.contest2)
            val fragment = BlankFragment5()
            supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
            true
        }



        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home2 -> {
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                }
                R.id.intra2 -> {
                    bottomNavigationView.setSelectedItemId(R.id.intra)
                    toolbar.setTitle("Intraday")
                    val fragment = BlankFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                }
                R.id.sterm2 -> {
                    bottomNavigationView.setSelectedItemId(R.id.sterm)
                    toolbar.setTitle("Short term")
                    val fragment = BlankFragment2()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                }
                R.id.lterm2 -> {
                    bottomNavigationView.setSelectedItemId(R.id.lterm)
                    toolbar.setTitle("Long term")
                    val fragment = BlankFragment3()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                }
                R.id.detail2 -> {
                    bottomNavigationView.setSelectedItemId(R.id.detail)
                    toolbar.setTitle("Details")
                    val fragment = BlankFragment4()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                }
                R.id.contest2 -> {
                    val fragment = BlankFragment5()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                    toolbar.setTitle("Contest")
                    bottomNavigationView.setSelectedItemId(R.id.contest)
                }
                R.id.share2 -> {
                    val intent=Intent(this,MainShare::class.java)
                    startActivity(intent)
                }
                R.id.prize2 -> {
                    val intent = Intent(this, MainActivity4::class.java)
                    startActivity(intent)
                }
                R.id.disclaimer2 -> {
                    val intent = Intent(this, MainActivity5::class.java)
                    startActivity(intent)
                }
                R.id.logout2->{
                    FirebaseAuth.getInstance().signOut()
                    val intent=Intent(this,MainActivity2::class.java)
                    startActivity(intent)
                    val sharedPreferences:SharedPreferences =this.getSharedPreferences("USER",
                        Context.MODE_PRIVATE)
                    val editor:SharedPreferences.Editor=sharedPreferences.edit()
                    editor.clear()
                    editor.apply()
                    Toast.makeText(this,"Logout",Toast.LENGTH_LONG).show()
                }

            }
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }

    }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.homecontext, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.conthome -> {
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                }
            }
            return true
        }


}