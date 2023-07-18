package com.example.superheroes

import HeroesRepository
import HeroesRepository.heroes
import android.graphics.drawable.shapes.Shape
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero

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
            HeroInformation(hero)
            Spacer(
                modifier = Modifier.width(dimensionResource(R.dimen.between_text_image_spacer))
            )
            HeroImage(hero)
        }
    }
}

@Composable
fun HeroInformation(hero: Hero) {
    Column(
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

@Preview
@Composable
fun HeroItemPreview(){
    HeroItem(hero = heroes[3])
}
