package com.example.aifood.ui.theme.dastan


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.aifood.R
import com.example.aifood.ui.theme.Orange
import com.google.firebase.firestore.FirebaseFirestore


@Composable
fun Home(
    navController: NavController,bottomViewModel: BottomViewModel = viewModel()
) {
    val bottomItems = bottomViewModel.bottomItems.observeAsState()
    println(bottomItems)
    data class BottomC(
        val imageZero:Int,
        val imageFirst:Int,
        val title:String,
        var isTrue: Boolean

    )

    val topBottom = listOf(
        BottomC(R.drawable.ic_bottom_home,R.drawable.ic_bottom_home1,"home",true),
        BottomC(R.drawable.ic_bottom_basket,R.drawable.ic_bottom_basket1,"basket",false),
        BottomC(R.drawable.ic_bottom_chat,R.drawable.ic_bottom_chat1,"chat",false),
        BottomC(R.drawable.ic_bottom_profile,R.drawable.ic_bottom_profile1,"profile",false)
    )
    val categoryList = listOf(
        Pair(R.drawable.ic_burgercategory, "Burger"),
        Pair(R.drawable.ic_pizzacategory, "Pizza"),
        Pair(R.drawable.ic_drinkcategory, "Ice cream"),
        Pair(R.drawable.ic_sandwichcategory, "Taco"),
        Pair(R.drawable.ic_burgercategory, "Burger"),
        Pair(R.drawable.ic_pizzacategory, "Pizza"),
        Pair(R.drawable.ic_drinkcategory, "Drink"),
        Pair(R.drawable.ic_sandwichcategory, "Taco")

    )
    val db = FirebaseFirestore.getInstance()
    var foods by remember { mutableStateOf<List<Pair<String, String>>>(emptyList()) }

    fun loadDishes() {

        db.collection("foods")
            .get()
            .addOnSuccessListener { result ->
                val dishList = result.map { document ->
                    Pair(
                        document.id,
                        "${document.getString("name")} - ${document.getDouble("price")} - ${
                            document.getString("image_url")
                        }"
                    )
                }
                foods = dishList
            }
            .addOnFailureListener { exception ->
                Log.w("Firestore", "Ошибка чтения данных", exception)
            }
    }
    LaunchedEffect(Unit) { loadDishes() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.7f)
                .height(230.dp)
                .background(Orange)
        ) {
            Image(
                painter = painterResource
                    (id = R.drawable.ic_hometopimage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.height(52.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth()
                        .height(53.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Row {
                            Text(
                                text = "Your Location",
                                color = Color.White,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Image(
                                painter = painterResource(id = R.drawable.ic_iconhome),
                                contentDescription = null,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.ic_locationorange),
                                contentDescription = null,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "New York City",
                                color = Color.White,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W600
                            )


                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(90.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.ic_notification),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }

                }
                Column(
                    modifier = Modifier
                        .padding(start = 24.dp)
                        .padding(vertical = 22.5.dp)
                        .height(80.dp)
                        .width(272.dp)
                ) {
                    Text(
                        text = "Provide the best food for you",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.W600,
                        color = Color.White
                    )
                }

            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Find by Category", fontWeight = FontWeight.W600, fontSize = 16.sp)
                Text(
                    text = "See all",
                    color = Orange,
                    fontWeight = FontWeight.W500,
                    fontSize = 14.sp, modifier = Modifier.clickable{navController.navigate("forgot")}
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                categoryList.forEach { (imagec, namec) ->
                    Column(
                        modifier = Modifier
                            .width(59.dp)
                            .height(65.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Orange)
                        , horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painter = painterResource(id = imagec), contentDescription = null, modifier = Modifier.weight(1f).size(24.dp))
                        Column (modifier = Modifier.fillMaxWidth().weight(0.9f), horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = namec, fontSize = 14.sp, fontWeight = FontWeight.W500, textAlign = TextAlign.Center)
                        }
                    }
                    Spacer(modifier = Modifier.width(40.dp))

                }
            }
            Spacer(modifier = Modifier.height(15.dp))
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            foods.chunked(2).forEach { foodPair ->

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    foodPair.forEach { (id, dish) ->
                        val parts = dish.split(" - ")
                        val name = parts.getOrNull(0) ?: ""
                        val price = parts.getOrNull(1) ?: ""
                        val image_url = parts.getOrNull(2) ?: ""
                        Column(
                            modifier = Modifier
                                .width(152.dp)
                                .height(204.dp)
                                .clip(RoundedCornerShape(15.dp))
                                .background(Color.White)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(7.5.dp)
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    modifier = Modifier
                                        .width(137.dp)
                                        .height(106.dp)
                                )
                                {
                                    AsyncImage(
                                        model = image_url,
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }
                                Row() {
                                    Text(
                                        text = name,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W500
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(16.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row {
                                        Image(
                                            painter = painterResource(id = R.drawable.ic_star),
                                            contentDescription = null,
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Text(text = "4.9")
                                    }
                                    Row {
                                        Image(
                                            painter = painterResource(id = R.drawable.ic_locationorange),
                                            contentDescription = null,
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Text(text = "190m")
                                    }


                                }
                                Row {
                                    Text(
                                        text = "$${price}",
                                        color = Orange,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W700
                                    )
                                }
                            }


                        }

                    }
                }
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
        Row(modifier = Modifier.fillMaxWidth().height(92.dp).weight(0.2f).background(Color.White,
            RoundedCornerShape(20.dp)
        ), verticalAlignment = Alignment.Top){
            Row(modifier = Modifier.padding(horizontal = 25.dp).height(52.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically){
                bottomItems.value?.forEach{(a,b,c,d) ->
                    Column (modifier = Modifier
                        .height(52.dp)
                        .width(76.dp)
                        .clickable(indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ){
                            navController.navigate(c.toString())
                            bottomViewModel.toggleItemState(c)
                        }
                        , horizontalAlignment = Alignment.CenterHorizontally
                        , verticalArrangement = if (d) Arrangement.SpaceAround else Arrangement.Center)
                    {
                        if (d){
                            Image(painter = painterResource(id = b)
                                , contentDescription = null
                                , modifier = Modifier.size(24.dp)
                            )
                            Text(text = c, color = Orange)
                        }else{
                            Image(painter = painterResource(id = a)
                                , contentDescription = null
                                , modifier = Modifier.size(24.dp))
                        }
                    }

                }

            }

        }


    }
}