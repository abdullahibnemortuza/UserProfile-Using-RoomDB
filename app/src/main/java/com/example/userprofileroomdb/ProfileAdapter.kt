package com.example.userprofileroomdb

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.userprofileroomdb.databinding.ProfileItemLayoutBinding

class ProfileAdapter(
    private val userList: List<UserProfile>,
    private val onItemClick: (UserProfile) -> Unit,
    private val onDeleteClick: (UserProfile) -> Unit,
    private val onUpdateClick: (UserProfile) -> Unit
) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {
    inner class ProfileViewHolder(val binding: ProfileItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val binding =
            ProfileItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProfileViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val user = userList[position]
        holder.binding.apply {
            userNameTxt.text = user.name
            userEmailTxt.text = user.email
            userDOBTxt.text = user.dob
            userDistritTxt.text = user.district
            userMobileTxt.text = user.mobile

            root.setOnClickListener {
                onItemClick(user)
            }
            deleteBtn.setOnClickListener {
                onDeleteClick(user)
            }
            editBtn.setOnClickListener {
                onUpdateClick(user)
            }
        }
    }
}