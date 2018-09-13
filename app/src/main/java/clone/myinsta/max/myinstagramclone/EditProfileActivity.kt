package clone.myinsta.max.myinstagramclone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        iv_closeImage.setOnClickListener {
            finish()
        }

        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        val database = FirebaseDatabase.getInstance().reference
        database.child("users").child(user!!.uid).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(data: DatabaseError) {

            }

            override fun onDataChange(data: DataSnapshot) {
                val user = data.getValue(User::class.java)
                et_name_input.setText(user!!.name, TextView.BufferType.EDITABLE)
                et_username_input.setText(user.username, TextView.BufferType.EDITABLE)
                et_website_input.setText(user.website, TextView.BufferType.EDITABLE)
                et_bio_input.setText(user.bio, TextView.BufferType.EDITABLE)
                et_email_input.setText(user.email, TextView.BufferType.EDITABLE)
                et_phone_input.setText(user.phone.toString(), TextView.BufferType.EDITABLE)
            }
        })
    }
}
