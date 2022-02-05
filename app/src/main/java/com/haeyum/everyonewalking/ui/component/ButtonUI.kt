package com.haeyum.everyonewalking.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haeyum.everyonewalking.ui.theme.Main
import com.haeyum.everyonewalking.ui.theme.pretendardFontFamily

@Composable
fun CapsuleButton(text: String, modifier: Modifier = Modifier, backgroundColor: Color = Main, onClick: () -> Unit) {
    Button(onClick = onClick,
        shape = RoundedCornerShape(100.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(vertical = 8.dp),
            fontFamily = pretendardFontFamily,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

@Composable
@Preview
fun CapsuleButtonPreview() {
    CapsuleButton("Capsule Button") { /*no-op*/ }
}