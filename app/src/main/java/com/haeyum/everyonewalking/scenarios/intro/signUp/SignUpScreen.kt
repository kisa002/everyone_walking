package com.haeyum.everyonewalking.scenarios.intro.signUp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haeyum.everyonewalking.ui.component.CapsuleButton
import com.haeyum.everyonewalking.ui.component.RoundedTextField
import com.haeyum.everyonewalking.ui.theme.Hint
import com.haeyum.everyonewalking.ui.theme.Main
import com.haeyum.everyonewalking.ui.theme.pretendardFontFamily

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen() {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequesters = List(2) { FocusRequester() }

    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "반갑습니다.\n계정을 생성해주세요.",
            modifier = Modifier.padding(top = 36.dp),
            color = Color.Black,
            fontFamily = pretendardFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp
        )

        Column(modifier = Modifier.align(Alignment.Center)) {
            RoundedTextField(
                placeholderText = "아이디",
                modifier = Modifier.fillMaxWidth().focusRequester(focusRequesters[0]),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = {
                    focusRequesters[1].requestFocus()
                }),
                onValueChange = { username.value = it }
            )

            RoundedTextField(
                placeholderText = "비밀번호",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .focusRequester(focusRequesters[1]),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                }),
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = { password.value = it }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "이미 회원가입을 하셨나요?",
                    fontFamily = pretendardFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = Hint
                )
                Text(
                    text = "로그인 하기",
                    fontFamily = pretendardFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }
        }

        CapsuleButton(
            text = "회원가입 하기",
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            backgroundColor = when (username.value.isNotEmpty() && password.value.isNotEmpty()) {
                true -> Main
                false -> Color.Gray
            }
        ) {

        }
    }
}

@Composable
@Preview(widthDp = 375, heightDp = 812)
fun SignUpScreenPreview() {
    SignUpScreen()
}