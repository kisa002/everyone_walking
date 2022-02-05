package com.haeyum.everyonewalking.scenarios.intro.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haeyum.everyonewalking.R
import com.haeyum.everyonewalking.ui.theme.Main
import com.haeyum.everyonewalking.ui.theme.pretendardFontFamily

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Main)
    ) {
        Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = "logo", modifier = Modifier.align(Alignment.Center))
        Text(text = stringResource(R.string.app_name), color = Color.White, fontSize = 24.sp, fontFamily = pretendardFontFamily, fontWeight = FontWeight.Black, modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 94.dp))
    }
}

@Composable
@Preview(widthDp = 375, heightDp = 812)
fun SplashScreenPreview() {
    SplashScreen()
}