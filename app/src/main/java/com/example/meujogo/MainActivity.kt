package com.example.meujogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
                    PlayGameScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


//// função para receber os componentes do inimigo
@Composable
fun AndroidEnemy(
    color: Color,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Android Enemy",
        colorFilter = ColorFilter.tint(color),
        modifier = modifier
    )
}


// TELA DE INICIO
@Composable
fun PlayGameScreen(modifier: Modifier = Modifier) {

    // o column cobre toda a tela por ser o pai
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        // status do jogo
        Row(
            modifier = Modifier
                .fillMaxWidth()                                 //ocupa toda a largura da tela
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween    // Arrangement horizontal -> espaça entre os elementos
        ) {

            Text(
                text = "SCORE: 0050",
                color = Color.White,
                fontSize = 25.sp
            )

            // LIVES + bonecos
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "LIVES:",
                    color = Color.White,
                    fontSize = 25.sp
                )

                //OUTRA FORMA DE COLOCAR OS 3 ELEMENTOS DE UMA VEZ
//                repeat(3 ){
//                    AndroidEnemy(
//                        color = Color.Green,
//                        modifier = Modifier.size(35.dp)
//                    )
//                }

                AndroidEnemy(
                    color = Color.Green,
                    modifier = Modifier.size(35.dp)
                )

                AndroidEnemy(
                    color = Color.Green,
                    modifier = Modifier.size(35.dp)
                )

                AndroidEnemy(
                    color = Color.Green,
                    modifier = Modifier.size(35.dp)
                )
            }
        }

        // inimigos
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)            // Corrigido para Column
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

        // Empurra o botão de start para a parte inferior da tela
        Spacer(modifier = Modifier.weight(1f))

        // Arrumando o botão de start
        Row(
            modifier = Modifier
                .width(430.dp)                      // Define a largura fixa
                .height(100.dp)                     // Define a altura fixa
                .align(Alignment.CenterHorizontally)// Corrigido para Column
                .padding(bottom = 45.dp)            // Espaçamento de baixo
                .background(Color.Gray),            // Define a cor da caixa

            verticalAlignment = Alignment.CenterVertically, // Centraliza o texto no eixo vertical (altura).
            horizontalArrangement = Arrangement.Center      // Centraliza os elementos filhos no eixo horizontal (largura).
        ) {

            Text(
                text = "PRESS START",
                color = Color.White,
                fontSize = 25.sp
            )
        }

    }
}

// TELA DE GAME OVER
@Composable
fun GameOverScreen() {

}