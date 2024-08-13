package com.example.noteapp.ui.note

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.HomeScreen
import com.example.noteapp.MainActivity
import com.example.noteapp.NoteScreen
import com.example.noteapp.state.NoteEvent
import com.example.noteapp.state.NoteState
import com.example.noteapp.ui.theme.BgColor
import com.example.noteapp.ui.theme.Secondary
import com.example.noteapp.ui.theme.TxtContentPlaceholderStyle
import com.example.noteapp.ui.theme.TxtContentStyle
import com.example.noteapp.ui.theme.TxtPlaceholderColor
import com.example.noteapp.ui.theme.TxtTitlePlaceholderStyle
import com.example.noteapp.ui.theme.TxtTitleStyle


@Preview
@Composable
fun NoteContent(modifier: Modifier = Modifier, onEvent:(NoteEvent) -> Unit ?= {},  state: NoteState? = NoteState(), onBackPress : () -> Unit = {}) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
        NoteHeader(onBackPress = {
            onBackPress.invoke()
        },
            onSave = {
                onEvent(NoteEvent.SaveNote)
            })
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = {
                title = it
                onEvent.invoke(NoteEvent.Title(it))
                Log.i("LOG_TEXT_FIELD", "NoteContent: $title")
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = TxtPlaceholderColor,
                unfocusedIndicatorColor = TxtPlaceholderColor,
                cursorColor = TxtPlaceholderColor,
                focusedContainerColor = BgColor,
                unfocusedContainerColor = BgColor,

                ),
            textStyle = TxtTitleStyle,
            placeholder = { Text(text = "Title", style = TxtTitlePlaceholderStyle) })

        TextField(
            modifier = Modifier.fillMaxSize(),
            value = content,
            onValueChange = {
                content = it
                onEvent.invoke(NoteEvent.Content(it))
                Log.i("LOG_TEXT_FIELD", "NoteContent: $content")
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = TxtPlaceholderColor,
                unfocusedIndicatorColor = TxtPlaceholderColor,
                cursorColor = TxtPlaceholderColor,
                focusedContainerColor = BgColor,
                unfocusedContainerColor = BgColor
            ),
            textStyle = TxtContentStyle,
            placeholder = { Text(text = "Type something...", style = TxtContentPlaceholderStyle) })
    }

}