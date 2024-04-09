package pe.edu.upc.superherocompose.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import pe.edu.upc.superherocompose.model.data.Hero
import pe.edu.upc.superherocompose.repositories.HeroRepository

@Composable
fun Home() {

    val name = remember {
        mutableStateOf("")
    }
    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            HeroSearch(name)
            HeroList(name)
        }
    }

}

@Composable
fun HeroSearch(name: MutableState<String>) {

}


@Composable
fun HeroList(name: MutableState<String>) {
    val heroes = remember {
        mutableStateOf(emptyList<Hero>())
    }
    val heroRepository = HeroRepository()

    heroRepository.searchHero(name.value) {
        heroes.value = it
    }
    LazyColumn {


        items(heroes.value) { hero ->
            HeroCard(hero)
        }
    }
}

@Composable
fun HeroCard(hero: Hero) {
    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp)) {
        Row {
            HeroImage(hero.image.url)
            Column (modifier = Modifier.padding(4.dp)){
                Text(text = hero.name, fontWeight = FontWeight.Bold)
                Text(text = hero.biography.fullName)
            }
        }
    }
}

@Composable
fun HeroImage(url: String) {
    GlideImage(
        imageModel = { url },
        imageOptions = ImageOptions(contentScale = ContentScale.Crop),
        modifier = Modifier.size(92.dp)
    )
}


