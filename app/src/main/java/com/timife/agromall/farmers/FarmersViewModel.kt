package com.timife.agromall.farmers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.timife.agromall.base.BaseViewModel

class FarmersViewModel(repository: FarmersRepository): BaseViewModel(repository) {


    val result = repository.getFarmers().cachedIn(viewModelScope)

}