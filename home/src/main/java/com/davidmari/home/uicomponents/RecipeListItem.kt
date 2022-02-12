package com.davidmari.home.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davidmari.resources.theme.Typography


@Preview(showBackground = true)
@Composable
fun RecipeListItem(
    ingredientsSize: Int = 6,
    title: String = "Greek Salad with a very long name",
    readyIn: Int = 40
) {
    Column(modifier = Modifier.width(210.dp).padding(start = 16.dp, end = 8.dp)) {
        val image: Painter = painterResource(id = com.davidmari.resources.R.drawable.sample_image)
        Image(
            painter = image,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(330.dp)
                .clip(
                    RoundedCornerShape(16.dp)
                )
        )
        Text(
            text = title,
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(0.8f),
            maxLines = 1,
            style = Typography.bodyLarge,
            color = colorScheme.onSurface,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "$ingredientsSize ingredients • $readyIn min",
            modifier = Modifier.padding(top = 4.dp),
            style = Typography.bodyMedium,
            color = colorScheme.onSurfaceVariant
        )
    }
}