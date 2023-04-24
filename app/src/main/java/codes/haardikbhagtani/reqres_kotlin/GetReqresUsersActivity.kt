package codes.haardikbhagtani.reqres_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import codes.haardikbhagtani.reqres_kotlin.adapter.UsersAdapter
import codes.haardikbhagtani.reqres_kotlin.databinding.ActivityGetReqresUsersBinding
import codes.haardikbhagtani.reqres_kotlin.helper.ReqresApi
import codes.haardikbhagtani.reqres_kotlin.helper.RetrofitHelper
import codes.haardikbhagtani.reqres_kotlin.model.GetUsers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class GetReqresUsersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetReqresUsersBinding
    private lateinit var users: GetUsers
    private lateinit var adapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_get_reqres_users)

        val usersApi = RetrofitHelper.getInstance().create(ReqresApi::class.java)
        // launching a new coroutine
        MainScope().launch {
            val result = usersApi.getUsers(1)
            Log.d("Main", result.body().toString())
            users = result.body()!!
            Log.d("Main", users.data[0].firstName.toString())

            adapter = UsersAdapter(this@GetReqresUsersActivity, users)

            binding.rvUsers.layoutManager = LinearLayoutManager(this@GetReqresUsersActivity, LinearLayoutManager.VERTICAL, false)

            binding.rvUsers.adapter = adapter
        }
    }
}