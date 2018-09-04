package clone.myinsta.max.myinstagramclone

import android.os.Bundle

class HomeActivity : BaseActivity(0) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpBottomNavigation()
    }
}
