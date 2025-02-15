package com.denreyes.clink.views

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.denreyes.clink.R
import com.denreyes.clink.data.Drink
import com.denreyes.clink.data.DrinksRepositoryImpl
import com.denreyes.clink.data.getFakeDrink
import com.denreyes.clink.ui.theme.GrafittiText
import com.denreyes.clink.ui.theme.avenirFontFamily
import com.denreyes.clink.ui.theme.cruelMachineFontFamily

@Composable
fun DrinkList(
    onDrinkClicked: (Drink) -> Unit,
    drinks: List<Drink>,
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(drinks) { drink ->
            DrinkListItem(
                drink = drink,
                onDrinkClicked = onDrinkClicked
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DrinkListItem(
    drink: Drink,
    onDrinkClicked: (Drink) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onDrinkClicked(drink) }
            .padding(vertical = 12.dp)
    ) {
        GrafittiText(
            text = drink.strDrink,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(end = 36.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Cocktail Info
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    // Name
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(Color.Black.copy(alpha = 0.5f))
                    ) {
                        Text(
                            text = drink.strDrink,
                            fontSize = 32.sp,
                            color = Color.White,
                            fontFamily = avenirFontFamily,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 32.sp,
                        )
                    }

                    // Category
                    Text(
                        text = "Cocktail",
                        fontFamily = avenirFontFamily,
                        color = Color.White,
                        fontSize = 16.sp,
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Make Button
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                            onDrinkClicked(drink)
                        }
                    ) {
                        Text(
                            text = "Make",
                            fontSize = 14.sp,
                            color = Color.White,
                            fontFamily = avenirFontFamily,
                            fontWeight = FontWeight.Bold,
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Make",
                            modifier = Modifier.size(16.dp),
                            tint = Color.White
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(250.dp)
                ) {
                    // Cocktail Image (on top) with gray border
                    Box(
                        modifier = Modifier
//                            .fillMaxWidth()
                            .height(190.dp)
                            .width(150.dp)
                            .background(Color.White)
                            .border(5.dp, Color.White) // Gray border with rounded corners
                            .align(Alignment.CenterEnd)
                    ) {
                        AsyncImage(
                            model = drink.strDrinkThumb,
                            contentDescription = "${drink.strDrink} Image",
                            modifier = Modifier
                                .height(150.dp)
                                .width(150.dp),
                            contentScale = ContentScale.FillHeight
                        )
                    }

                    val letters = "ertyuisdfghxn"
                    val randomLetter = letters.random().toString()

                    Text(
                        text = randomLetter.toString(),
                        fontSize = 80.sp,
                        color = Color.LightGray,
                        fontFamily = cruelMachineFontFamily,
                        fontWeight = FontWeight.Thin,
                        modifier = Modifier
                            .align(Alignment.BottomEnd) // Position at the bottom right
                    )
                }

            }

            // Divider with 1-inch (approx. 24dp) margin on both sides
            Divider(
                color = Color.White,
                thickness = 0.8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .padding(horizontal = 48.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DrinkListItemPreview() {
    Text("Hello, world!", fontFamily = avenirFontFamily)
//    DrinkListItem(drink = getFakeDrink(), {});
}