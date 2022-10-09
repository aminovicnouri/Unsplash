package com.aminovic.unsplash.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.aminovic.unsplash.data.repository.Repository
import com.aminovic.unsplash.model.UnsplashImage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


//
// Created by Mohamed El Amine Nouri on 09/10/2022.
// Copyright (c) 2021 Track24. All rights reserved.
//

@ExperimentalPagingApi
@HiltViewModel
class SearchViewModel @ExperimentalPagingApi
@Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    private val _searchedImages = MutableStateFlow<PagingData<UnsplashImage>>(PagingData.empty())
    val searchedImages = _searchedImages

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun searchHeroes(query: String) {
        viewModelScope.launch {
            repository.searchImages(query = query).cachedIn(viewModelScope).collect {
                _searchedImages.value = it
            }
        }
    }
}