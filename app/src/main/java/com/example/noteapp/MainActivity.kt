package com.example.noteapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.state.NoteEvent
import com.example.noteapp.state.NoteState
import com.example.noteapp.ui.home.HomeHeader
import com.example.noteapp.ui.home.MyFloatingActionButton
import com.example.noteapp.ui.theme.BgColor
import com.example.noteapp.ui.theme.NoteAppTheme
import com.example.noteapp.ui.theme.Secondary
import com.example.noteapp.ui.utils.StatusBarUtils

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteAppTheme {

            }
        }
    }
}

@Composable
fun Greeting() {
    val currentContext = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
            .background(BgColor)
    ) {
        HomeHeader(modifier = Modifier.padding(horizontal = 25.dp, vertical = 15.dp))
        Image(
            painter = painterResource(id = R.drawable.rafiki),
            contentDescription = "Image no note",
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.Center)
        )

        LargeFloatingActionButton(
            onClick = {
                Toast.makeText(currentContext, "Create new email", Toast.LENGTH_LONG).show()
            },
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 11.dp, bottom = 45.dp),
            contentColor = Color.White,
            containerColor = Secondary,
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 15.dp)
        ) {
            Icon(painter = painterResource(id = R.drawable.add), contentDescription = "icon add")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteAppTheme {
        Greeting()
    }
}