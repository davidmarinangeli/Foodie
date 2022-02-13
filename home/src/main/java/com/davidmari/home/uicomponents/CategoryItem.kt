package com.davidmari.home.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davidmari.resources.theme.Typography


@Preview(showBackground = true)
@Composable
fun CategoryItem(onClick: (() -> Unit)? = null) {
    FoodieSurface(onClick = onClick, modifier = Modifier.padding(all = 8.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)) {
            Text(text = "\uD83E\uDDC1", style = Typography.titleLarge)
            Text(text = "Desserts", style = Typography.bodyLarge)
        }

    }
}