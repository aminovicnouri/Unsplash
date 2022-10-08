package com.aminovic.unsplash.screens.home

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import com.aminovic.unsplash.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


//
// Created by Mohamed El Amine Nouri on 08/10/2022.
// Copyright (c) 2021 Track24. All rights reserved.
//

@ExperimentalPagingApi
@HiltViewModel
class HomeViewModel
@Inject constructor(
    repository: Repository
): ViewModel() {
    val getAllImages = repository.getAllImages()
}