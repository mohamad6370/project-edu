package com.example.myeducompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myeducompose.ui.theme.MyEduComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyEduComposeTheme {
                SetUi()
            }
        }
    }
        private val username = mutableStateOf(TextFieldValue())
        private val password = mutableStateOf(TextFieldValue())
        private val phone = mutableStateOf(TextFieldValue())

        private val userError = mutableStateOf(false)
        private val passError = mutableStateOf(false)
        private val phoneError = mutableStateOf(false)

        @Composable
        fun SetUi() {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_profile), contentDescription = null,
                    modifier = Modifier
                        .padding(30.dp)
                        .width(200.dp)
                        .height(200.dp),
                )

                MyEditText("نام کاربری", username, userError, false)
                MyEditText("رمز عبور", password, passError, false)
                MyEditText("شماره تلفن", phone, phoneError, true)

                Button(
                    onClick =
                    {
                        userError.value =username.value.text.isEmpty()
                        passError.value =password.value.text.length>5
                        phoneError.value =phone.value.text.length>11
                    },
                    modifier = Modifier
                        .width(280.dp)
                        .padding(top = 20.dp)
                ) {
                    Text(
                        text = "Click Here",
                        fontSize = 22.sp
                    )
                }

            }

        }

        @Composable
        fun MyEditText(
            label: String,
            valueText: MutableState<TextFieldValue>,
            valueError: MutableState<Boolean>,
            isNumber: Boolean
        ) {
            var text by remember {
                valueText
            }
            val error by remember {
                valueError
            }

            valueError.value = false

            TextField(value = text,
                onValueChange = {
                    text = it
                },
                label = {
                    Text(
                        text = label
                    )

                },
                keyboardOptions = if (isNumber)
                    KeyboardOptions(keyboardType = KeyboardType.Number)
                else
                    KeyboardOptions(keyboardType = KeyboardType.Text),
                textStyle = TextStyle(
                    fontSize = 20.sp
                ),
                modifier = Modifier
                    .padding(top = 30.dp)
                    .width(280.dp),
                isError = error,
                supportingText = {
                    if (error)
                        Text(text = "لطفا فیلد خالی را پر کنید")
                }

            )

        }
    }






