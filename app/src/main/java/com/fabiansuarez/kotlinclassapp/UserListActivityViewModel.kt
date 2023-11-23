package com.fabiansuarez.kotlinclassapp

import androidx.lifecycle.ViewModel

class UserListActivityViewModel : ViewModel() {

    private val userList: ArrayList<User> = arrayListOf()
    var adapter: UserAdapter = UserAdapter(userList)

    fun loadUsers() {
        userList.apply {
            clear()
            add(User("10988230982", "Fabian suarez", "fsuarez", "No hay"))
            add(User("10988230982", "Fabian suarez", "fsuarez", "No hay"))
            add(User("10988230982", "Fabian suarez", "fsuarez", "No hay"))
            add(User("10988230982", "Fabian suarez", "fsuarez", "No hay"))
        }
    }

    fun refresh() {
        adapter.refresh(userList)
    }
}