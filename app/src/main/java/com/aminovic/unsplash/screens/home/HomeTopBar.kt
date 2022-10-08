package com.aminovic.unsplash.screens.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.aminovic.unsplash.ui.theme.topAppBarBackgroundColor
import com.aminovic.unsplash.ui.theme.topAppBarContentColor


@Composable
fun HomeTopBar(
    onSearchClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Home",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search icon"
                )
            }
        }
    )
}

@Preview
@Composable
fun TopBarPreview() {
    HomeTopBar(onSearchClicked = {})
}