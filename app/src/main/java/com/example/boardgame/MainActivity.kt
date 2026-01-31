package com.example.boardgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //First Screen of welcome
            BoardgameTheme {
                Scaffold( modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    GreetingImage(
                        name = "The Board Game" ,
                        from = "Lets Play",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
//Function to show the presentation of the game
fun Greeting(name: String, from: String, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
           ){
        Text(
            text = name ,
            color = Color.Blue,
            fontSize = 40.sp,
            lineHeight = 56.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,

        )
        Text(
            text = from,
            color = Color.Red,
            fontSize = 30.sp,
            modifier = Modifier.padding(8.dp),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,

        )

    }
}
@Composable
// Image of background
fun GreetingImage(name: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.andrej_lisakov_v2oyjtfqety_unsplash)
    Box(modifier) {
        //Styling the imagen
        Image(
            painter = image,
            modifier = Modifier
                .fillMaxSize(),
            contentDescription = null
        )
        //Styling the imagen
        Greeting(
            name = name,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)


        )

    }
}