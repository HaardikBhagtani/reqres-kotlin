package codes.haardikbhagtani.reqres_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import codes.haardikbhagtani.reqres_kotlin.databinding.ActivityReqresUserDetailsBinding
import codes.haardikbhagtani.reqres_kotlin.model.Data
import com.bumptech.glide.Glide

class ReqresUserDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReqresUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reqres_user_details)
        val person = this.intent.getSerializableExtra("data") as Data

        Glide.with(this).load(person.avatar).into(binding.imageView5)
        binding.tvEmail.text = person.email
        binding.tvName.text = person.firstName + " " + person.lastName
    }
}