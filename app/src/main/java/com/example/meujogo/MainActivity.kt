package com.example.meujogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meujogo.ui.theme.MeuJogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MeuJogoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    PlayGameScreen(
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    GameOverScreen(

                    )
                }
            }
        }
    }
}


// função para receber os componentes do inimigo
@Composable
fun AndroidEnemy(
    color: Color,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(R.drawable.alien),  // Caminho que define quem vai "pintar" a img ( R é o import da pasta RESS)
        contentDescription = "Android Enemy",              // Nome do conteiner
        colorFilter = ColorFilter.tint(color),             // Um filtro que muda a cor da imagem
        modifier = modifier                                // Deixa a imagem com dimenssão
    )
}


@Composable
fun AndroidLives(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(R.drawable.naves),
        contentDescription = "Android Lives",
        modifier = modifier
    )
}


// TELA DE INICIO
@Composable
fun PlayGameScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        // STATUS DO JOGO
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "SCORE: 0050",
                color = Color.White,
                fontSize = 25.sp
            )

            // LIVES + NAVES
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "LIVES:",
                    color = Color.White,
                    fontSize = 25.sp
                )

                AndroidLives(
                    modifier = Modifier.size(35.dp)
                )

                AndroidLives(
                    modifier = Modifier.size(35.dp)
                )

                AndroidLives(
                    modifier = Modifier.size(35.dp)
                )
            }
        }


        // INIMIGOS
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 45.dp),
            horizontalArrangement = Arrangement.spacedBy(0.dp)
        ) {

            AndroidEnemy(
                color = Color.Green,
                modifier = Modifier.size(85.dp)
            )

            AndroidEnemy(
                color = Color.Red,
                modifier = Modifier.size(85.dp)
            )

            AndroidEnemy(
                color = Color.Blue,
                modifier = Modifier.size(85.dp)
            )

            AndroidEnemy(
                color = Color.Yellow,
                modifier = Modifier.size(85.dp)
            )

            AndroidEnemy(
                color = Color.Green,
                modifier = Modifier.size(85.dp)
            )
        }


        // PARTE INFERIOR DA TELA
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Empurra toda essa parte para baixo
            Spacer(
                modifier = Modifier.weight(1f)
            )

            // NAVE DO JOGADOR
            // Agora ela fica imediatamente acima do botão
            AndroidLives(
                modifier = Modifier.size(120.dp)
            )

            // BOTÃO DE START
            Row(
                modifier = Modifier
                    .width(430.dp)
                    .height(50.dp)
                    .background(Color.Gray)
                    .padding(bottom = 8.dp),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "PRESS START",
                    color = Color.White,
                    fontSize = 25.sp
                )
            }
        }
    }
}


// TELA DE GAME OVER
@Composable
fun GameOverScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            // Alien verde
            AndroidEnemy(
                color = Color.Green,
                modifier = Modifier.size(85.dp)
            )

            // Alien vermelho
            AndroidEnemy(
                color = Color.Red,
                modifier = Modifier.size(85.dp)
            )

            // Alien azul
            AndroidEnemy(
                color = Color.Blue,
                modifier = Modifier.size(85.dp)
            )

            // Alien amarelo
            AndroidEnemy(
                color = Color.Yellow,
                modifier = Modifier.size(85.dp)
            )

            // Alien verde
            AndroidEnemy(
                color = Color.Green,
                modifier = Modifier.size(85.dp)
            )
        }

        Text(
            text = "GAME OVER",
            color = Color.White,
            fontSize = 60.sp
        )
    }
}