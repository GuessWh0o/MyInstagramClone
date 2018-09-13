package clone.myinsta.max.myinstagramclone

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_login.*


/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var emailTextDisposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        emailTextDisposable = RxTextView.textChanges(et_password)
                .subscribe { charSequence ->
                    btn_login.isEnabled = et_email.text.isNotEmpty() && charSequence.isNotEmpty()
                }

        btn_login.setOnClickListener { it ->
            mAuth.signInWithEmailAndPassword(et_email.text.toString(), et_password.text.toString())
                    .addOnCompleteListener {
                        if(it.isSuccessful) {
                            startActivity(Intent(this, HomeActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        emailTextDisposable.dispose()
    }
}
