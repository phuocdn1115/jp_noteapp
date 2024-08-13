package com.example.noteapp.ui.note

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.R
import com.example.noteapp.ui.theme.BgColor
import com.example.noteapp.ui.theme.HeadingStyle
import com.example.noteapp.ui.theme.Secondary

@Preview
@Composable
fun NoteHeader(
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit = {},
    onPreview: () -> Unit = {},
    onSave: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = 23.dp)
            .background(color = BgColor)
    ) {
        Row() {
            Card(
                modifier = Modifier.wrapContentSize(),
                shape = RoundedCornerShape(15.dp),
                colors = CardDefaults.cardColors(containerColor = Secondary),
                elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
                onClick = {
                    Log.i("CHECK_BACK_PRESS", "CLICK:------------------------------ ")
                    onBackPress.invoke()
                }
            ) {
                Image(
                    painterResource(id = R.drawable.ic_back),
                    contentDescription = "icon search",
                    modifier = Modifier.padding(vertical = 13.dp, horizontal = 18.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier.wrapContentSize(),
                shape = RoundedCornerShape(15.dp),
                colors = CardDefaults.cardColors(containerColor = Secondary),
                elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.preview),
                    contentDescription = "icon preview",
                    modifier = Modifier.padding(13.dp)
                )
            }
            Spacer(modifier = Modifier.width(21.dp))
            Card(
                modifier = Modifier.wrapContentSize(), shape = RoundedCornerShape(15.dp),
                colors = CardDefaults.cardColors(containerColor = Secondary),
                elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
                onClick = {
                    onSave.invoke()
                }

            ) {
                Image(
                    painterResource(id = R.drawable.save),
                    contentDescription = "icon save",
                    modifier = Modifier.padding(13.dp)
                )
            }
        }
    }
}