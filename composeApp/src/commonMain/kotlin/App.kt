import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.cyrillrx.rpg.AppRouter
import com.cyrillrx.rpg.core.Greeting
import com.cyrillrx.rpg.ui.DummyRouter
import com.cyrillrx.rpg.ui.theme.AppTheme
import com.cyrillrx.rpg.ui.theme.spacingMedium
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import ttrpg_companion.composeapp.generated.resources.Res
import ttrpg_companion.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App1() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}

@Composable
@Preview
fun App(router: AppRouter = DummyRouter()){
    AppTheme { HomeScreen(router) }
}

@Composable
fun HomeScreen(router: AppRouter) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacingMedium),
    ) {
        HomeButton("Grimoire") { router.openDndSpellBook() }
        HomeButton("Grimoire Compose") { router.openDndSpellBookCompose() }
        HomeButton("Bestiaire") { router.openDndBestiary() }
        HomeButton("Objets magiques") { router.openDndInventory() }
        HomeButton("Objets magiques Compose") { router.openDndInventoryCompose() }
    }
}

@Composable
fun HomeButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingValues(spacingMedium)),
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    HomeScreen(DummyRouter())
}
