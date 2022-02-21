package com.davidmari.home.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davidmari.resources.theme.Typography


@Preview(showBackground = true)
@Composable
fun CategoryItem(onClick: (() -> Unit)? = null, categoryName: String = "Dessert", emoji: String = "\uD83E\uDDC1", recipesCount: Int = 10) {
    FoodieSurface(onClick = onClick, modifier = Modifier.padding(all = 8.dp).width(100.dp).aspectRatio(1f)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Text(text = emoji, fontSize = 24.sp)
            Text(text = categoryName, style = Typography.bodyMedium, fontWeight = FontWeight.Medium, modifier = Modifier.padding(top = 4.dp))
            Text(text = "$recipesCount ricette", style = Typography.bodySmall, color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(top = 4.dp))
        }

    }
}