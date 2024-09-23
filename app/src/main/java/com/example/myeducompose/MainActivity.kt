package com.example.myeducompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
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
    @Composable
    fun SetUi(){
        Column {
            Text(
                text = "mmadmadi",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp)
                    .background(color = Color.LightGray)
                    .padding(30.dp),


                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.teal_700),
            )
            Button(onClick = {
                Toast.makeText(
                    this@MainActivity,
                    "test app",
                    Toast.LENGTH_SHORT
                ).show()
            },
                modifier = Modifier
                    .width(200.dp)
                    .padding(start = 70.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color. Blue
                )
            ) {
                Text(
                    text = "Click",
                    color = Color.White
                )
            }
        }}

    @Preview(showBackground = true,
        name = "Test",
        showSystemUi = true,
        device = Devices.PIXEL_6_PRO)
    @Composable
    fun TestPreview() {
        SetUi()
    }
}






