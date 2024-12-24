package com.example.pr16_novgorodtseva

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Onboarding(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()){
        Background()

        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Logo()
            Text(
                text = "ПРИВЕТ",
                color = Color.White,
                fontSize = 34.sp,
                fontFamily = AlegreyaFontFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.offset(x = 0.dp, y = (-80).dp)
            )
            Text(
                text = "Наслаждайся отборочными.\nБудь внимателен.\nДелай хорошо.",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = AlegreyaFontFamily,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.offset(x = 0.dp, y = (-80).dp)
            )
            Button(
                onClick = { navController.navigate("login")},
                modifier = Modifier.size(width = 321.dp, height = 61.dp),
                shape = RoundedCornerShape(7.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C9A92))
            ) {
                Text(
                    text = "Войти в аккаунт",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontFamily = AlegreyaFontFamily,
                    fontWeight = FontWeight.Normal,
                )
            }
            Row (
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Text(
                    text = "Еще нет аккаунта? ",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = AlegreyaFontFamily,
                    fontWeight = FontWeight.Normal,
                )
                Text(
                    modifier = Modifier.clickable { /*TODO*/ },
                    text = "Зарегистрируйтесь",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = AlegreyaFontFamily,
                    fontWeight = FontWeight.ExtraBold,
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun PreviewOnboarding(){
//    Onboarding()
//}