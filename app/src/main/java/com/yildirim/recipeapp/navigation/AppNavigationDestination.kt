package com.yildirim.recipeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.yildirim.recipeapp.entity.Foods
import com.yildirim.recipeapp.presentation.category_page.CategoryPage
import com.yildirim.recipeapp.presentation.detail_page.DetailPage

@Composable
fun PageController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category_page") {
        composable("category_page"){
            CategoryPage(navController = navController)
        }
        composable("detail_page/{food}", arguments = listOf(
            navArgument("food"){type = NavType.StringType}
        )){
            val json = it.arguments?.getString("food")
            val food = Gson().fromJson(json, Foods::class.java)
            DetailPage(navController = navController,food = food)
        }
    }
}
