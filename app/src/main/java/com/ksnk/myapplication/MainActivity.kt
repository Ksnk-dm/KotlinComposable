package com.ksnk.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ksnk.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    // private var mCount=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                //     Greeting(name = "dima")
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    //     testFun()
                    //     testFunSecond()
                    //     testFunThree()
                    textFieldLogin()
                    textFieldPassword()
                    buttonDone()
                }
            }
        }
    }
}

@Composable
fun TestView(count: Int, onNewTest: () -> Unit) {
    Column {
        Text(text = "count $count")
        Button(onClick = onNewTest) {
            Text(text = "Click button")
        }
    }
}

@Composable
fun TextShow(text: String, onNewTest: () -> Unit){
    Column(        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

    }
}

@Composable
fun testFun() {
    var count by remember { mutableStateOf(2) }
    TestView(count) { count += 2 }
}

@Composable
fun testFunSecond() {
    var count by remember { mutableStateOf(2) }
    TestView(count) { count *= 3 }
}

@Composable
fun testFunThree() {
    var count by remember { mutableStateOf(2) }
    TestView(count) { count *= 2 }
}

@Composable
fun textFieldLogin() {
    val text = remember { mutableStateOf("") }
    TextField(
        value = text.value,
        onValueChange = { value ->
            text.value = value
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            cursorColor = Color.Black,
            disabledLabelColor = Color.Green
        ),
        label = { Text("Set Login") }
    )
}

@Composable
fun textFieldPassword() {
    val text = remember { mutableStateOf("") }
    TextField(
        value = text.value,
        onValueChange = { value ->
            text.value = value
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            cursorColor = Color.Black,
            disabledLabelColor = Color.Green
        ),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        label = { Text("Set Password") }
    )
}

@Composable
fun buttonDone() {
    val context = LocalContext.current
    Button(onClick = {
        Toast.makeText(
            context,
            "Showing toast....",
            Toast.LENGTH_SHORT
        ).show()
    }, modifier = Modifier.padding(top = 15.dp)) {
        Text(text = "Done")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            //      testFun()
            //    testFunSecond()
            //    testFunThree()
            textFieldLogin()
            textFieldPassword()
            buttonDone()

        }
    }
}