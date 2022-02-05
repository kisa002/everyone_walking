package com.haeyum.everyonewalking.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.haeyum.everyonewalking.ui.theme.Hint
import com.haeyum.everyonewalking.ui.theme.InputLine
import com.haeyum.everyonewalking.ui.theme.pretendardFontFamily

@Composable
fun RoundedTextField(
    placeholderText: String,
    modifier: Modifier = Modifier,
    isSingleLine: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit
) {
    val value = remember { mutableStateOf("") }

    OutlinedTextField(
        value = value.value,
        modifier = modifier.background(Color.White),
        placeholder = {
            Text(
                text = placeholderText,
                fontFamily = pretendardFontFamily,
                fontWeight = FontWeight.Normal,
                color = Hint
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = InputLine,
            unfocusedBorderColor = InputLine
        ),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        onValueChange = {
            value.value = it
            onValueChange(it)
        }
    )
}

@Composable
@Preview
fun RoundedTextFieldPreview() {
    RoundedTextField(placeholderText = "placeholderText") { /*no-op*/ }
}