package com.example.noteapp.ui.home

import androidx.compose.foundation.Image
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.R
import com.example.noteapp.ui.theme.HeadingStyle
import com.example.noteapp.ui.theme.Secondary
import com.example.noteapp.ui.utils.StatusBarUtils

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeHeader(
    onClickSearch: () -> Unit = {},
    onClickInfo: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Row() {
            Text(
                text = "Notes",
                modifier = Modifier
                    .wrapContentSize(),
                style = HeadingStyle,
                textAlign = TextAlign.Start,
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier.wrapContentSize(),
                shape = RoundedCornerShape(15.dp),
                colors = CardDefaults.cardColors(containerColor = Secondary),
                elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.search),
                    contentDescription = "icon search",
                    modifier = Modifier.padding(13.dp)
                )
            }
            Spacer(modifier = Modifier.width(21.dp))
            Card(
                modifier = Modifier.wrapContentSize(), shape = RoundedCornerShape(15.dp),
                colors = CardDefaults.cardColors(containerColor = Secondary),
                elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)

            ) {
                Image(
                    painterResource(id = R.drawable.info_outline),
                    contentDescription = "icon search",
                    modifier = Modifier.padding(13.dp)
                )
            }
        }
    }
}