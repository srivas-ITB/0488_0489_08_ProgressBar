package com.example.app08_ProgressBar

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbDownAlt
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.app08_ProgressBar.ui.theme.MyApp_Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp_Theme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyExample(modifier = Modifier.padding( innerPadding))
                }
            }
        }

    }
}


@Composable
fun MyExample(modifier: Modifier = Modifier) {

    Column(
        Modifier.fillMaxSize().verticalScroll( rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.padding(10.dp))
        MyProgressBar1()
        Spacer(modifier = Modifier.padding(10.dp))
        MyProgressBar2()
        Spacer(modifier = Modifier.padding(10.dp))
        MyProgressBar3( )

    }
}

@Composable
fun MyProgressBar1(){
    Text("Progress Bar circular")
    CircularProgressIndicator()
}


@Composable
fun MyProgressBar2(){
    Text("Progress Bar circular - personalitzada")
    CircularProgressIndicator(color = Color.Green, strokeWidth = 8.dp)
}

@Composable
fun MyProgressBar3(){
    Text("Progress Bar circular - canviant el valor")
    var progressStatus by rememberSaveable() { mutableStateOf(0f) }
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        CircularProgressIndicator(
            progress = { progressStatus },
            trackColor = ProgressIndicatorDefaults.circularIndeterminateTrackColor,
            color = Color.Yellow, strokeWidth = 10.dp
        )
        Row() {
            Button(onClick = { if (progressStatus > 0f) progressStatus -= 0.1f }) {
                Text(text = "Decrementar")
            }
            Button(onClick = { if (progressStatus < 1f) progressStatus += 0.1f }) {
                Text(text = "Incrementar", )
            }
            IconButton(
                onClick = { if (progressStatus < 1f) progressStatus += 0.1f }
            ) {
                Icon(imageVector = Icons.Default.ThumbUp,
                    contentDescription = "Amunt!" )
            }
            IconButton(
                onClick = { if (progressStatus > 0f) progressStatus -= 0.1f }
            ) {
                Icon(imageVector = Icons.Default.ThumbDownAlt,
                    contentDescription = "Avall!" )
            }
        }
    }

}
