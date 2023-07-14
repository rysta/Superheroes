package com.example.superheroes

import HeroesRepository
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.model.Hero

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier){
    Card(
        modifier = modifier
    ) {
        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            HeroInformation(hero, modifier)
            HeroImage(hero, modifier)
        }
    }
}

@Composable
fun HeroInformation(hero: Hero, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(hero.nameRes),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(hero.descriptionRes),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun HeroImage(hero: Hero, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(hero.imageRes),
        contentDescription = stringResource(hero.descriptionRes)
    )
}

@Preview
@Composable
fun HeroItemPreview(){
    HeroItem(hero = HeroesRepository.heroes.component1())
}
