package com.example.superheroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroapp.model.Hero
import com.example.superheroapp.model.HeroesRepository
import com.example.superheroapp.ui.theme.SuperHeroAppTheme
import kotlin.text.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroAppTheme {
                    SuperApp()
            }
        }
    }
}

@Composable
fun SuperApp() {
    Scaffold(
        topBar = {SuperTopbar()}
    ) {padding ->
        LazyColumn(modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(padding)){
            items(HeroesRepository.heroes.size){
                    hero -> SuperCard(hero = HeroesRepository.heroes.get(hero))
            }

        }
    }
}

@Composable
fun SuperTopbar(){
        Text(
            stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.secondary,
            modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
        )
}


@Composable
fun SuperCard(modifier: Modifier = Modifier, hero: Hero){
    Card(elevation = 2.dp, modifier = Modifier
        .padding(16.dp, 8.dp)) {
        Row(modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    stringResource(hero.nameRes),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.onSurface,
                    textAlign = TextAlign.Justify
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier
                .size(72.dp)
                .clip(RoundedCornerShape(8.dp))
                .fillMaxHeight()){
            Image(painter = painterResource(hero.imageRes), contentDescription = stringResource(hero.nameRes
            ),
                contentScale = ContentScale.FillWidth
            )
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperHeroAppTheme {
       SuperApp()
    }
}