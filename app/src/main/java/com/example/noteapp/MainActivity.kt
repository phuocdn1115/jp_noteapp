package com.example.noteapp

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.state.NoteEvent
import com.example.noteapp.state.NoteState
import com.example.noteapp.ui.home.HomeHeader
import com.example.noteapp.ui.note.NoteContent
import com.example.noteapp.ui.theme.BgColor
import com.example.noteapp.ui.theme.NoteAppTheme
import com.example.noteapp.ui.theme.Pink80
import com.example.noteapp.ui.theme.Secondary
import com.example.noteapp.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: NoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteAppTheme {
                val state by viewModel.state.collectAsState()
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home_screen") {
                    composable(route = "home_screen") {
                        Greeting(state = state, onEvent = viewModel::onEvent) {
                            navController.navigate("note_screen")
                        }
                    }
                    composable(route = "note_screen"){
                        NoteContent(state = state, onEvent = viewModel::onEvent, onBackPress = {
                            navController.popBackStack("home_screen", true)
                        })
                    }
                }
            }
        }
    }
}

@Serializable
object HomeScreen

@Serializable
object NoteScreen

@Composable
fun Greeting(state: NoteState, onEvent: (NoteEvent) -> Unit, onNewNote: () -> Unit) {
    onEvent.invoke(NoteEvent.SortNote())
    Box(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
            .background(BgColor)
    ) {
        HomeHeader(modifier = Modifier.padding(horizontal = 25.dp, vertical = 15.dp))
        if (state.notes.isEmpty()) {
            Image(
                painter = painterResource(id = R.drawable.rafiki),
                contentDescription = "Image no note",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        } else {
            LazyColumn(
                contentPadding = PaddingValues(25.dp),
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.notes) { note ->
                    Card(modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(15.dp),
                        colors = CardDefaults.cardColors(containerColor = Pink80),
                        onClick = { /*TODO*/ }) {
                        Column {
                            Text(text = note.title)
                            Text(text = note.content)
                        }
                    }
                }
            }
        }
        LargeFloatingActionButton(
            onClick = {
                onNewNote.invoke()
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

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    NoteAppTheme {
//        Greeting()
//    }
//}