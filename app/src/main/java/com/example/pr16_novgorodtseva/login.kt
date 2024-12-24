package com.example.pr16_novgorodtseva

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Login(navController: NavController ){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isEmptyMessage by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .background(
                color = Color(0xFF253334)
            )
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.login_background),
            contentDescription = "Login Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(220.dp)

        )
        Column(
            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.small_logo),
                contentDescription = "Small logo",
                modifier = Modifier
                    .size(width = 343.dp, 349.dp)
                    .fillMaxWidth()
                    .offset(x = (-50).dp, y = (-10).dp)
            )
            Text(
                text = "Sign in",
                color = Color.White,
                fontSize = 30.sp,
                fontFamily = AlegreyaFontFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 40.dp)
                    .offset(y = (-130).dp)
            )
            Row (
                modifier = Modifier.fillMaxSize(),
            ){
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = -(30).dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = isEmptyMessage,
                        color = if (isEmptyMessage.contains("empty")) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                    )
                    TextField(
                        value = email,
                        placeholder = { Text(text = "Email", color = Color(0xffBEC2C2))},
                        onValueChange = { email = it },
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.Transparent,
                            unfocusedTextColor = Color(0xffBEC2C2),
                            focusedContainerColor = Color(0x40FFFFFF),
                            focusedTextColor = Color.White,
                            unfocusedIndicatorColor = Color(0xffBEC2C2),
                            focusedIndicatorColor = Color.White
                        ),
                        modifier = Modifier
                            .padding(horizontal = 40.dp)
                            .fillMaxWidth(),
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = { Text(text = "Password", color = Color(0xffBEC2C2))},
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.Transparent,
                            unfocusedTextColor = Color(0xffBEC2C2),
                            focusedContainerColor = Color(0x40FFFFFF),
                            focusedTextColor = Color.White,
                            unfocusedIndicatorColor = Color(0xffBEC2C2),
                            focusedIndicatorColor = Color.White
                        ),
                        modifier = Modifier
                            .padding(horizontal = 40.dp)
                            .fillMaxWidth(),
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    Button(
                        onClick = {
                            if(email.isNotEmpty() && password.isNotEmpty())
                                navController.navigate("home") {
                                    popUpTo("home") {inclusive = true}
                                }
                            else
                                isEmptyMessage = "TextFields is empty"
                        },
                        modifier = Modifier.size(width = 321.dp, height = 61.dp),
                        shape = RoundedCornerShape(7.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xb47C9A92))
                    ) {
                        Text(
                            text = "Sign in",
                            color = Color.White,
                            fontSize = 25.sp,
                            fontFamily = AlegreyaFontFamily,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Row (
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Text(
                            text = "Register",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = AlegreyaFontFamily,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(horizontal = 40.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.size(width = 321.dp, height = 61.dp),
                        shape = RoundedCornerShape(7.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xb47C9A92))
                    ) {
                        Text(
                            text = "Профиль",
                            color = Color.White,
                            fontSize = 25.sp,
                            fontFamily = AlegreyaFontFamily,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun PreviewLogin(){
//    Login()
//}