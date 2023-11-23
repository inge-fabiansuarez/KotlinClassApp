package com.fabiansuarez.kotlinclassapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.fabiansuarez.kotlinclassapp.R
import com.fabiansuarez.kotlinclassapp.viewmodel.UserListActivityViewModel
import com.fabiansuarez.kotlinclassapp.databinding.ActivityUserListBinding

class UserListActivity : AppCompatActivity() {

    private lateinit var viewModel: UserListActivityViewModel
    private lateinit var binding: ActivityUserListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_user_list)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_list)
        viewModel = ViewModelProvider(this)[UserListActivityViewModel::class.java]
        binding.viewModel = viewModel

        viewModel.loadUsers()
        viewModel.refresh()


    }
}