package sk.sandeep.quizzappkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import sk.sandeep.quizzappkotlin.databinding.ActivityQuizzBinding

class QuizzActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var binding: ActivityQuizzBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_quizz)

        drawerLayout = binding.drawerLayout


        //add  add Up button =====================
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.myFragmentContainerView) as NavHostFragment
        val navController = navHostFragment.findNavController()
        NavigationUI.setupActionBarWithNavController(this, navController)
        //=======================================

        //add the code that allows the user to display the navigation drawer
        //we con open navigation drawer by  right swap
        NavigationUI.setupWithNavController(binding.navView, navController)


        //add the code that allows the user to display the navigation drawer Icon
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

    }

    // add Up button functionality
    /* override fun onSupportNavigateUp(): Boolean {
         val navHostFragment =
             supportFragmentManager.findFragmentById(R.id.myFragmentContainerView) as NavHostFragment
         val navController = navHostFragment.findNavController()
         return navController.navigateUp()
     }*/

    //add upButton and navigation Drawer functionality
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myFragmentContainerView)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}