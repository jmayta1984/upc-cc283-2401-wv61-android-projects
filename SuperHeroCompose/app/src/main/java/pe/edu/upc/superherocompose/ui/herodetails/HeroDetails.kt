package pe.edu.upc.superherocompose.ui.herodetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pe.edu.upc.superherocompose.factories.HeroRepositoryFactory
import pe.edu.upc.superherocompose.model.data.Biography
import pe.edu.upc.superherocompose.model.data.Hero
import pe.edu.upc.superherocompose.model.data.PowerStats
import pe.edu.upc.superherocompose.repositories.HeroRepository
import pe.edu.upc.superherocompose.ui.heroessearch.HeroImage

@Composable
fun HeroDetails(id: String) {

    val hero = remember {
        mutableStateOf<Hero?>(null)
    }
    HeroRepositoryFactory.getHeroRepository().searchHeroById(id) {
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
            HeroPowerStats(it.powerStats)
        }
    }

}

@Composable
fun HeroPowerStats(powerStats: PowerStats) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp)) {
        Column(modifier = Modifier.padding(4.dp)) {
            Text(
                text = "Power Stats",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            HeroStat("Intelligence", powerStats.intelligence)
            HeroStat("Strength", powerStats.strength)
            HeroStat("Speed", powerStats.speed)
            HeroStat("Durability", powerStats.durability)
            HeroStat("Power", powerStats.power)

        }
    }
}

@Composable
fun HeroStat(name: String, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = name, modifier = Modifier.weight(2f))
        value.toFloatOrNull()?.let {
            Slider(
                value = it,
                onValueChange = {},
                valueRange = 0f..100f,
                modifier = Modifier.weight(4f)
            )

        }
    }
}


@Composable
fun HeroBiography(biography: Biography) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp)) {
        Column(modifier = Modifier.padding(4.dp)) {
            Text(
                text = "Biography",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Full name: ${biography.fullName}"
            )
            Text(
                text = "Place of birth: ${biography.placeOfBirth}"
            )
            Text(
                text = "Publisher: ${biography.publisher}"
            )
        }

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