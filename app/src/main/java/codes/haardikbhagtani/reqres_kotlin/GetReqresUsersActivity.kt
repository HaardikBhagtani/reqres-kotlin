package codes.haardikbhagtani.reqres_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import codes.haardikbhagtani.reqres_kotlin.adapter.UsersAdapter
import codes.haardikbhagtani.reqres_kotlin.databinding.ActivityGetReqresUsersBinding
import codes.haardikbhagtani.reqres_kotlin.helper.ReqresApi
import codes.haardikbhagtani.reqres_kotlin.helper.RetrofitHelper
import codes.haardikbhagtani.reqres_kotlin.model.Data
import codes.haardikbhagtani.reqres_kotlin.model.GetUsers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

interface CellClickListener {
    fun onCellClickListener(data: Data)
}

class GetReqresUsersActivity : AppCompatActivity(), CellClickListener {
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

            adapter = UsersAdapter(this@GetReqresUsersActivity, users, this@GetReqresUsersActivity)

            binding.rvUsers.layoutManager = LinearLayoutManager(this@GetReqresUsersActivity, LinearLayoutManager.VERTICAL, false)

            binding.rvUsers.adapter = adapter
        }
    }

    override fun onCellClickListener(data: Data) {
        val intent = Intent(this, ReqresUserDetailsActivity::class.java).apply {
            putExtra("data", data)
        }
       startActivity(intent)
    }
}