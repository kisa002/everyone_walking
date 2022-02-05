package com.haeyum.everyonewalking.scenarios.intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.haeyum.everyonewalking.scenarios.intro.signIn.SignInScreen
import com.haeyum.everyonewalking.scenarios.intro.splash.SplashScreen
import com.haeyum.everyonewalking.ui.theme.EveryoneWalkingTheme

class IntroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EveryoneWalkingTheme {
//                SplashScreen()
                SignInScreen()
            }
        }
    }
}