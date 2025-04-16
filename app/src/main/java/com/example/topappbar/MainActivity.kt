package com.example.topappbar

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.topappbar.ui.theme.TopAppBarTheme
import com.example.topappbar.ui.theme.greenJC

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TopAppBarTheme {
                Surface(
                    //modifier = Modifier.fillMaxSize()
                ) {
                    LearnTopAppBar()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnTopAppBar() {
    val context = LocalContext.current.applicationContext
    TopAppBar(
        title = { Text(text = "Whatsapp") },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(context, "Whatsapp", Toast.LENGTH_SHORT).show()
            }) {
                Icon(painter = painterResource(R.drawable.whatsappicon), contentDescription = "Halo")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = greenJC,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
        ),
        actions = {
            IconButton(onClick = {Toast.makeText(context,"Profile", Toast.LENGTH_SHORT).show()}) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile", tint = Color.White)
            }
            IconButton(onClick = {Toast.makeText(context,"Search", Toast.LENGTH_SHORT).show()}) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
            }
            IconButton(onClick = {Toast.makeText(context,"MoreVert", Toast.LENGTH_SHORT).show()}) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "MoreVert", tint = Color.White)
            }
        }
    )
}

@Preview
@Composable
fun TopAppBarPreview(){
    TopAppBarTheme{
        LearnTopAppBar()
    }
}
