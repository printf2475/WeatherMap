package co.test.feature.weather.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.test.designsystem.theme.Black
import co.test.designsystem.theme.Gray200
import co.test.designsystem.theme.Gray800
import co.test.designsystem.theme.White

@Composable
fun SearchButton(
    modifier: Modifier = Modifier,
    onSearch: () -> Unit
) {
    TextButton(
        modifier = modifier.wrapContentHeight(),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Gray200,
            contentColor = Black
        ),
        shape = RoundedCornerShape(16.dp),
        contentPadding = PaddingValues(12.dp),
        onClick = onSearch
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )

            Text(text = "Search")
        }
    }
}

@Preview(widthDp = 1080, heightDp = 500)
@Composable
private fun PreviewSearchButton() {
    SearchButton(
        modifier = Modifier.fillMaxWidth(),
        onSearch = {}
    )
}