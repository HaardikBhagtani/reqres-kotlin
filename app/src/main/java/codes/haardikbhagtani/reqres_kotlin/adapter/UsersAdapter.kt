package codes.haardikbhagtani.reqres_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import codes.haardikbhagtani.reqres_kotlin.GetReqresUsersActivity
import codes.haardikbhagtani.reqres_kotlin.R
import codes.haardikbhagtani.reqres_kotlin.databinding.UserCardBinding
import codes.haardikbhagtani.reqres_kotlin.model.GetUsers
import com.bumptech.glide.Glide


class UsersAdapter(
    private val activity: GetReqresUsersActivity,
    private var list: GetUsers

) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {
    class ViewHolder(var bind: UserCardBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val listItemContactsBinding: UserCardBinding
        val view = LayoutInflater.from(parent.context)
        listItemContactsBinding = DataBindingUtil.inflate(
            view,
            R.layout.user_card, parent, false
        )
        return ViewHolder(listItemContactsBinding)
    }

    override fun getItemCount(): Int {
        return list.data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(activity).load(list.data[position].avatar).into(holder.bind.imageView5)
        holder.bind.tvEmail.text = list.data[position].email
        holder.bind.tvName.text = list.data[position].firstName + " " + list.data[position].lastName
    }
}