package com.aminovic.unsplash.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.aminovic.unsplash.Util.Constants.ITEMS_PER_PAGE
import com.aminovic.unsplash.data.local.UnsplashDatabase
import com.aminovic.unsplash.data.paging.UnsplashRemoteMediator
import com.aminovic.unsplash.data.remote.UnsplashApi
import com.aminovic.unsplash.model.UnsplashImage
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


//
// Created by Mohamed El Amine Nouri on 08/10/2022.
// Copyright (c) 2021 Track24. All rights reserved.
//

@ExperimentalPagingApi
class Repository @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashDatabase: UnsplashDatabase
) {
    fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = {
            unsplashDatabase.unsplashImageDao().getAllImages()
        }
        return  Pager(
            config = PagingConfig(
                initialLoadSize = 30,
                pageSize =  ITEMS_PER_PAGE
                ),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashDatabase = unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory,
        ).flow
    }
}