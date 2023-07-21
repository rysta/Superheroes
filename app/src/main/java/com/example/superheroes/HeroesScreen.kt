package com.example.superheroes

import HeroesRepository.heroes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.superheroes.model.Hero

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesTopAppBar(){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}

@Composable
fun HeroesAppBody(innerPadding: PaddingValues){
    LazyColumn(
        contentPadding = innerPadding
    ){
        items(heroes){
            HeroItem(
                hero = it,
                modifier = Modifier.padding(
                    horizontal = dimensionResource(R.dimen.padding_medium),
                    vertical = dimensionResource(R.dimen.padding_small)
                )
            )
        }
    }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier){
    Card(
        elevation = CardDefaults
            .cardElevation(
                defaultElevation = dimensionResource(R.dimen.card_elevation)
            ),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
                .sizeIn(minHeight = dimensionResource(R.dimen.card_size))
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ){
                HeroInformation(hero)
            }
            Spacer(
                modifier = Modifier.width(dimensionResource(R.dimen.between_text_image_spacer))
            )
            HeroImage(hero)
        }
    }
}

@Composable
fun HeroInformation(hero: Hero) {
    Text(
        text = stringResource(hero.nameRes),
        style = MaterialTheme.typography.displaySmall
    )
    Text(
        text = stringResource(hero.descriptionRes),
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun HeroImage(hero: Hero) {
    Box(
        modifier = Modifier
            .size(dimensionResource(R.dimen.image_size))
            .clip(MaterialTheme.shapes.small)
    ){
        Image(
            painter = painterResource(hero.imageRes),
            contentDescription = stringResource(hero.descriptionRes),
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.TopCenter

        )
    }
}
