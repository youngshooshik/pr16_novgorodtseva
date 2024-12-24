package com.example.pr16_novgorodtseva

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Main(){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "С возвращением, Эмиль!",
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = AlegreyaFontFamily,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Каким ты себя ощущаешь сегодня?",
            color = Color(0xb2ffffff),
            fontSize = 22.sp,
            fontFamily = AlegreyaFontFamily,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(items){ item ->
                ColumnItem(item)
            }
        }
        Block(R.drawable.block1)
        Block(R.drawable.block2)

    }
}
data class ItemData(val drawableId: Int, val text: String)
private val items = listOf(
    ItemData(R.drawable.calm, "Спокойным"),
    ItemData(R.drawable.relaxed, "Расслабленным"),
    ItemData(R.drawable.attentive, "Сосредоточеным"),
    ItemData(R.drawable.excited, "Взволнованным"),
    ItemData(R.drawable.excited, "Энергичным")
)
@Composable
fun ColumnItem(item: ItemData) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(70.dp)) {
            Image(painter = painterResource(id = item.drawableId), contentDescription = "calm", Modifier.size(60.dp))
        }
        Text(
            text = item.text,
            color = Color(0xffffffff),
            fontSize = 12.sp,
            fontFamily = AlegreyaFontFamily,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Block(imageId: Int){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .padding(horizontal = 20.dp)
        .padding(top = 20.dp)
        .background(Color(0xffF7F3F0), shape = RoundedCornerShape(20.dp)),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
    ) {
        Row (
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ){
            Column (
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(220.dp)
                    .padding(start = 25.dp)
            ){
                Text(
                    text = "Заголовок блока",
                    color = Color(0xff253334),
                    fontSize = 25.sp,
                    fontFamily = AlegreyaFontFamily,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Кратенькое описание блока с двумя строчками",
                    color = Color(0xff000000),
                    fontSize = 15.sp,
                    fontFamily = AlegreyaFontFamily,
                    fontWeight = FontWeight.Normal,
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.offset(y = 10.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF253334))
                ) {
                    Text(
                        text = "подробнее",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight.Normal,
                    )
                }
            }

            Image(
                painter = painterResource(id = imageId),
                contentDescription = "blockimage",
                modifier = Modifier
                    .fillMaxSize()
                    .offset(x = (-20).dp)
            )

        }
    }
}

@Preview
@Composable
fun PreviewMain(){
    Main()
}