package codes.haardikbhagtani.reqres_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import codes.haardikbhagtani.reqres_kotlin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.bGetUsers.text = "Get Reqres Users"

        binding.bPostUser.text = "Post Reqres User"

        binding.bGetUsers.setOnClickListener {
            val intent = Intent(this@HomeActivity, GetReqresUsersActivity::class.java)
            startActivity(intent)
        }

        binding.bPostUser.setOnClickListener {
            val intent = Intent(this@HomeActivity, PostReqresUserActivity::class.java)
            startActivity(intent)
        }

    }
}