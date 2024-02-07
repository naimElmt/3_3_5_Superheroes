package com.example.superheroes


import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun SuperTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun HeroesList(heroes: List<Hero>, contentPadding: PaddingValues =
    PaddingValues(dimensionResource(R.dimen.padding_smaller)))
{
        LazyColumn(contentPadding = contentPadding) {
            items(heroes){hero ->
                HeroItem(hero = hero,
                        modifier = Modifier.padding
                            (horizontal = dimensionResource(R.dimen.padding_medium),
                             vertical = dimensionResource(R.dimen.padding_small)))
            }
        }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier)
{
Card(modifier = modifier, elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.padding_verysmall)))
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_medium))){
        Column(modifier = Modifier.weight(1f)){

           Text(text = stringResource(id = hero.nameRes),
                style = MaterialTheme.typography.displaySmall)

            Text(text = stringResource(id = hero.descriptionRes),
                style = MaterialTheme.typography.bodyLarge)
            }

        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_medium)))

        Image(painter = painterResource(hero.imageRes),
                modifier = Modifier
                    .size(dimensionResource(R.dimen.padding_big))
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.padding_small))),
                contentDescription = null,
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.FillWidth)
        }

    }


}