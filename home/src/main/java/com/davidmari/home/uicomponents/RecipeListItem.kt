package com.davidmari.home.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.davidmari.resources.theme.Typography


@Preview(showBackground = true)
@Composable
fun RecipeListItem(
    ingredientsSize: Int = 6,
    title: String = "Greek Salad with a very long name",
    image: String? = null,
    readyIn: Int = 40,
    itemIndex: Int = 0,
    isPopular: Boolean? = true,
    score: Double? = 2.0
) {
    FoodieSurface(
        onClick = { /*TODO*/ }, modifier = Modifier
            .width(240.dp)
            .padding(start = 16.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
    ) {
        Box() {
            Column {
                val painter: Painter =
                    if (image == null) painterResource(id = com.davidmari.resources.R.drawable.sample_image) else
                        rememberImagePainter(image)
                Image(
                    painter = painter,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Text(
                    text = title,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth(0.8f),
                    maxLines = 1,
                    style = Typography.bodyLarge,
                    color = colorScheme.onSurface,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "$ingredientsSize ingredients ??? $readyIn min",
                    modifier = Modifier.padding(
                        top = 4.dp,
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    ),
                    style = Typography.bodyMedium,
                    color = colorScheme.primary
                )
            }
            if (isPopular == true || (score ?: 0.0) > 70.0) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 8.dp, top = 8.dp)
                        .background(colorScheme.primary, shape = RoundedCornerShape(4.dp))
                ) {
                    Text(
                        text = "Popular".uppercase(),
                        style = Typography.labelSmall,
                        color = colorScheme.onPrimary,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                }
            }
        }
    }
}