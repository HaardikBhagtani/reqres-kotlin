package codes.haardikbhagtani.reqres_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import codes.haardikbhagtani.reqres_kotlin.databinding.ActivityPostReqresUserBinding
import codes.haardikbhagtani.reqres_kotlin.helper.ReqresApi
import codes.haardikbhagtani.reqres_kotlin.helper.RetrofitHelper
import codes.haardikbhagtani.reqres_kotlin.model.PostUserBody
import codes.haardikbhagtani.reqres_kotlin.model.PostUserResponse
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class PostReqresUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostReqresUserBinding
    private lateinit var users: PostUserResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_reqres_user)

        binding.bPostUserData.text = "Post User"
        binding.bPostUserData.setOnClickListener {
            if(binding.etName.text.isEmpty()) {
                Toast.makeText(this, "Name is Required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(binding.etJob.text.isEmpty()) {
                Toast.makeText(this, "Job is Required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val usersApi = RetrofitHelper.getInstance().create(ReqresApi::class.java)
            // launching a new coroutine
            MainScope().launch {
                val result = usersApi.postUser(PostUserBody(binding.etName.text.toString(), binding.etJob.text.toString()))
                Log.d("Main", result.body().toString())
                users = result.body()!!
                Log.d("Main", users.name.toString())
            }
            Toast.makeText(this, "Created Successfully", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}