package com.example.pr16_novgorodtseva

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Profile(){
    Surface(
        modifier = Modifier.fillMaxSize().padding(top = 80.dp),
        color = Color.Transparent
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profilepic),
                        contentDescription = "Profile picture",
                        modifier = Modifier.size(150.dp)
                    )
                    Text(
                        text = "Эмиль",
                        color = Color.White,
                        fontSize = 35.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(25.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items){item ->
                    PictureBlock(item)
                }
            }
        }
    }
}

private val items = listOf(
    ItemData(R.drawable.pic1, "11:00"),
    ItemData(R.drawable.pic2, "15:55"),
    ItemData(R.drawable.pic3, "19:11"),
    ItemData(R.drawable.pic4, "11:11"),
    ItemData(R.drawable.pic_add, "")
)

@Composable
fun PictureBlock(item: ItemData){
    Box(
        modifier = Modifier.size(153.dp, 115.dp),
    ){
        Image(painter = painterResource(id = item.drawableId), contentDescription = "pic", modifier = Modifier.fillMaxSize())
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = item.text,
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = AlegreyaFontFamily,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewProfile(){
    Profile()
}