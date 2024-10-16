package com.lasindu.xitebassesment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.lasindu.xitebassesment.data.DataSource
import com.lasindu.xitebassesment.model.Planet
import com.lasindu.xitebassesment.ui.theme.XitebAssesmentTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            XitebAssesmentTheme {
                val layoutDirection = LocalLayoutDirection.current
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                        .padding(
                            start = WindowInsets.safeDrawing
                                .asPaddingValues()
                                .calculateStartPadding(layoutDirection),
                            end = WindowInsets.safeDrawing
                                .asPaddingValues()
                                .calculateEndPadding(layoutDirection),
                        ),
                ) {
                    StarWarsApp()
                }
            }
        }
    }
}

@Composable
fun StarWarsApp() {
    Column(
        content = {
            Text(DataSource().getPlants()!!)
            PlanetList(
                planetList = DataSource().loadPlanets()
            )
        }
    )

}

@Composable
fun MinimalDialog(planet : Planet, onDismissRequest: () -> Unit) {

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Text("Hello")
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),

        ) {
            Column () {

                    Text(
                        text = planet.climate,
                        modifier = Modifier
                            .fillMaxSize(),
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = planet.climate,
                        modifier = Modifier
                            .fillMaxSize(),
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = planet.gravity,
                        modifier = Modifier
                            .fillMaxSize(),
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = planet.orbitalPeriod.toString(),
                        modifier = Modifier
                            .fillMaxSize(),
                        textAlign = TextAlign.Center,
                    )
                }

        }
    }
}

@Composable
fun PlanetList(planetList: List<Planet>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(planetList.size) { planet ->
            ListItemCard(
                planet = planetList[planet],
                modifier = Modifier.padding(8.dp),
            )
        }
    }
}

@Composable
fun ListItemCard(planet: Planet, modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(false) }

    Card(modifier = modifier.clickable { showDialog = true } ) {
        Column {
            Text(
                text = planet.name,
                modifier = Modifier
                    .padding(4.dp)
                    .width(300.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = planet.climate,
                modifier = Modifier
                    .padding(4.dp)
                    .width(300.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }

    if (showDialog) {
        MinimalDialog(planet= planet, onDismissRequest = {
            showDialog = false
        })
    }
}

@Preview
@Composable
private fun ListItemCardPreview() {
    ListItemCard(Planet("abc1", 200, "abc", "abc"))
}
