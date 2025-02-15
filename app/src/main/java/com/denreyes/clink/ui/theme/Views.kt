package com.denreyes.clink.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GrafittiText(
    text: String,
    modifier: Modifier = Modifier,
    maxFontSize: TextUnit = 250.sp,
    minFontSize: TextUnit = 12.sp
) {
    val textMeasurer = rememberTextMeasurer()
    var fontSize by remember { mutableStateOf(maxFontSize) }

    val randomRotation = remember { (Random.nextFloat() * 40f) - 20f }
    val processedText = text
        .uppercase()
        .replace(".", "")
        .replace(",", "")
        .removePrefix("A ")
        .removePrefix("THE ")
        .split(" ")
        .firstOrNull()
        .orEmpty()
        .take(3)

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val availableWidth = constraints.maxWidth.toFloat()

        LaunchedEffect(text, availableWidth) {
            var currentSize = maxFontSize

            while (currentSize > minFontSize) {
                val textLayoutResult = textMeasurer.measure(
                    text = processedText,
                    style = androidx.compose.ui.text.TextStyle(fontSize = currentSize)
                )
                if (textLayoutResult.size.width <= availableWidth) break
                currentSize *= 0.9f // Reduce size by 10% each step
            }

            fontSize = currentSize
        }

        Text(
            text = processedText,
            fontSize = fontSize,
            fontWeight = FontWeight.Normal,
            fontFamily = cruelMachineFontFamily,
            textAlign = TextAlign.Center,
            color = Color.LightGray,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = modifier
                .fillMaxSize()
                .graphicsLayer(rotationZ = randomRotation),
        )
    }
}
