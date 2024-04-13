package pe.edu.upc.superherocompose.ui.herodetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pe.edu.upc.superherocompose.model.data.Biography
import pe.edu.upc.superherocompose.model.data.Hero
import pe.edu.upc.superherocompose.repositories.HeroRepository
import pe.edu.upc.superherocompose.ui.heroessearch.HeroImage

@Composable
fun HeroDetails() {


    val hero = remember {
        mutableStateOf<Hero?>(null)
    }
    HeroRepository().searchHeroById("78") {
        hero.value = it
    }

    hero.value?.let {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeroImage(url = it.image.url, 292.dp)
            HeroHeader(it.name)
            HeroBiography(it.biography)
        }
    }

}

@Composable
fun HeroBiography(biography: Biography) {
    Card ( modifier = Modifier.fillMaxWidth()){
        Text(
            text = "Biography",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun HeroHeader(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold
    )
}