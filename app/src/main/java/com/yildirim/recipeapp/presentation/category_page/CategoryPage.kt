package com.yildirim.recipeapp.presentation.category_page

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.gson.Gson
import com.skydoves.landscapist.glide.GlideImage
import com.yildirim.recipeapp.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryPage(navController: NavController) {
    val viewModel: CategoryPageViewModel = viewModel()
    val foodList = viewModel.foodsList.observeAsState(listOf())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.menu)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.purple_200),
                    titleContentColor = colorResource(id = R.color.white),
                )
            )
        },
    ) {
        LazyColumn(
            contentPadding = PaddingValues(
                start = 12.dp,
                top = 70.dp,
                end = 12.dp,
                bottom = 16.dp
            ),
        ) {
            items(
                count = foodList.value!!.count(),
                itemContent = {
                    val foods = foodList.value!![it]
                    Card(
                        modifier = Modifier
                            .padding(all = 5.dp)
                            .fillMaxWidth()
                    ) {
                        Row(modifier = Modifier.clickable {
                            val foodJson = Gson().toJson(foods)
                            navController.navigate("detail_page/$foodJson")
                        }) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(all = 10.dp)
                                    .fillMaxWidth()
                            ) {
                                GlideImage(
                                    imageModel = "http://www.yildirimenes.com/foods/images/${foods.food_image_name}",
                                    modifier = Modifier.size(100.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
                                ) {
                                    Column(
                                        verticalArrangement = Arrangement.SpaceEvenly,
                                        modifier = Modifier.fillMaxHeight()
                                    ) {
                                        Text(text = foods.food_name, fontSize = 20.sp)
                                        Spacer(modifier = Modifier.size(30.dp))
                                        Text(text = "${foods.food_price} ₺", color = Color.DarkGray)
                                    }
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_arrow_right_24),
                                        contentDescription = ""
                                    )
                                }
                            }
                        }
                    }
                }
            )
        }
    }
}