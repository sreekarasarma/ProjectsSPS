package com.example.lazylistrecyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CartoonListScreen()
            }
        }
    }
}

@Composable
fun CartoonListScreen() {
    val cartoonList = listOf(
        Cartoon(
            R.drawable.cartoon1,
            "Tom & Jerry",
            "A mischievous cat and clever mouse play cat-and-mouse games."
        ),
        Cartoon(
            R.drawable.cartoon2,
            "SpongeBob SquarePants",
            "A quirky sponge lives in a pineapple under the sea."
        ),

        Cartoon(
            R.drawable.cartoon4,
            "Looney Tunes",
            "A series of zany adventures with iconic cartoon characters."
        ),
        Cartoon(
            R.drawable.cartoon5,
            "Richie Rich",
            "A super-wealthy kid, Richie Rich, must use his vast resources and ingenuity to find his missing parents while forming unlikely friendships with a group of neighborhood kids."
        ),
        Cartoon(
            R.drawable.cartoon6,
            "Courage The Cowardly Dog",
            "A cowardly dog who must overcome his own fears to heroically defend his unknowing farmer owners from all kinds of dangers, paranormal events and menaces that appear around their land."
        ),
        Cartoon(
            R.drawable.cartoon7,
            "He-Man",
            "A seemingly ordinary prince, Adam, transforms into the powerful He-Man using the Sword of Power to protect his planet Eternia from the evil Skeletor's attempts to seize control of Castle Grayskull."
    )
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Cyan
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            items(cartoonList) { cartoon ->
                CartoonCard(cartoon)
            }
        }
    }
}

@Composable
fun CartoonCard(cartoon: Cartoon) {
    Card(
        elevation = 8.dp,
        backgroundColor = Color.White,
        border = BorderStroke(2.dp, Color.Magenta),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = cartoon.imageResId),
                contentDescription = cartoon.name,
                modifier = Modifier
                    .size(96.dp)
                    .padding(end = 16.dp)
            )
            Column {
                Text(
                    text = cartoon.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = cartoon.plot,
                    fontSize = 14.sp,
                    color = Color.Red
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCartoonListScreen() {
    CartoonListScreen()
}
