package com.example.leafapp.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.example.leafapp.dataclass.PostClass
import com.example.leafapp.posts.PostDao
import com.example.leafapp.posts.PostsRepoImpl
import kotlinx.coroutines.launch

class AllFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val database = PostDao.PostRoomDataBase.getInstance(application)
    private val repo = PostsRepoImpl(database, application.applicationContext)
    private val _allPosts = MutableLiveData<List<PostClass>>()
        val allPosts : LiveData<List<PostClass>>
            get() = _allPosts



    init {
        refresh()
        refreshDeletedData()
        getAllPost()
    }

    private fun refresh() {
        viewModelScope.launch {
            try {
                repo.refreshData()
            } catch (e: Exception) {
            }
        }
    }

    private fun refreshDeletedData() {
        viewModelScope.launch {
            try {
                repo.refreshDeletedData()
            } catch (e: Exception) {
            }
        }
    }

    fun getAllPost() {
        viewModelScope.launch {
            _allPosts.value = database.dao.getAllPosts()
        }
    }

    fun getPost(type: String) {
        viewModelScope.launch {
            _allPosts.value = database.dao.getSomePosts(type)
        }
    }

    fun removePost(post:PostClass):List<PostClass>{
            val tmpList = _allPosts.value as MutableList<PostClass>
            tmpList.remove(post)
//            _allPosts.value = tmpList
            return tmpList

    }

    fun addToFav(p:PostClass){
        viewModelScope.launch {
            repo.addToFav(p)
        }
    }


    fun deleteFromFav(p:PostClass){
        viewModelScope.launch {
            repo.deleteFromFav(p)
        }
    }
}