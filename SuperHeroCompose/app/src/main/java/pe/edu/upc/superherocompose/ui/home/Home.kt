package pe.edu.upc.superherocompose.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import pe.edu.upc.superherocompose.model.data.Hero

@Composable
fun Home() {
    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            HeroSearch()
            HeroList()
        }
    }

}

@Composable
fun HeroSearch() {

}


@Composable
fun HeroList() {

    val heroes = remember {
        mutableStateOf(emptyList<Hero>())
    }

    LazyColumn {
        items(heroes.value) { hero ->
            HeroCard(hero)
        }
    }
}

@Composable
fun HeroCard(hero: Hero) {
    Card {
        Row {
            HeroImage(hero.image.url)
            Column {
                Text(text = hero.name)
                Text(text = hero.biography.fullName)
            }
        }
    }
}

@Composable
fun HeroImage(url: String) {
    GlideImage(
        imageModel = { url },
        imageOptions = ImageOptions(contentScale = ContentScale.Fit),
        modifier = Modifier.size(92.dp)
    )
}


