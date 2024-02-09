package com.yildirim.recipeapp.presentation.detail_page

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.skydoves.landscapist.glide.GlideImage
import com.yildirim.recipeapp.R
import com.yildirim.recipeapp.entity.Foods

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPage(navController:NavController, food: Foods) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = food.food_name) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.purple_200),
                    titleContentColor = colorResource(id = R.color.white),
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            )
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImage(
                imageModel = "http://www.yildirimenes.com/foods/images/${food.food_image_name}",
                modifier = Modifier.size(250.dp),
                contentScale = ContentScale.Fit
            )
            Text(text = "${food.food_price} ₺", color = Color.DarkGray, fontSize = 50.sp)
            Button(
                onClick = {
                    Log.e("Yemek", "${food.food_name} sipariş verildi")
                    Toast.makeText(context,"Sipariş Alındı",Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.size(250.dp, 50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_200),
                    contentColor = Color.White
                )
            ) {
                Text(text = stringResource(id = R.string.order))
            }
        }
    }
}
