package clone.myinsta.max.myinstagramclone

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

abstract class BaseActivity(private val navNumber: Int) : AppCompatActivity() {

    fun setUpBottomNavigation() {
        bottom_nav_view.setTextVisibility(false)
        bottom_nav_view.setIconSize(29f, 29f)
        bottom_nav_view.enableItemShiftingMode(false)
        bottom_nav_view.enableShiftingMode(false)
        bottom_nav_view.enableAnimation(false)
        for (i in 0 until bottom_nav_view.menu.size()) {
            bottom_nav_view.setIconTintList(i, null)
        }

        bottom_nav_view.setOnNavigationItemSelectedListener {
            val nextActivity =
                    when (it.itemId) {
                        R.id.item_home -> HomeActivity::class.java
                        R.id.item_search -> SearchActivity::class.java
                        R.id.item_share -> ShareActivity::class.java
                        R.id.item_likes -> LikesActivity::class.java
                        R.id.item_profile -> ProfileActivity::class.java
                        else -> null
                    }
            if (nextActivity != null) {
                val intent = Intent(this, nextActivity)
                intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                startActivity(intent)
                overridePendingTransition(0, 0)
                true
            } else {
                false
            }
        }
        bottom_nav_view.menu.getItem(navNumber).isChecked = true
    }
}