package clone.myinsta.max.myinstagramclone

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity(4) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setUpBottomNavigation()

        btn_edit_profile.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }
}
