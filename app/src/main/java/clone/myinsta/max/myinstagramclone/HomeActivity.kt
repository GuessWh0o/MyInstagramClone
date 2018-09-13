package clone.myinsta.max.myinstagramclone

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(0) {

    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpBottomNavigation()

        mAuth = FirebaseAuth.getInstance()

        tv_sign_out.setOnClickListener {
            mAuth.signOut()
        }
        mAuth.addAuthStateListener {
            if(it.currentUser == null) {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if(mAuth.currentUser == null) {
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
