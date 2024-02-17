package com.high_thon.lucian.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.high_thon.lucian.common.theme.LucianTypography
import com.high_thon.lucian.common.theme.color.LightColor

@Composable
fun LucianTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    error: String? = null,
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    onClick: (() -> Unit)? = null,
    titleHint: String? = null,
    hint: String? = null,
) {
    val interactionSource = remember { MutableInteractionSource() }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    Column {
        if (titleHint != null) {
            Text(
                modifier = Modifier.padding(bottom = 4.dp),
                text = titleHint,
                color = LightColor.GRAY5,
                style = LucianTypography.R16
            )
        }
        Box(
            modifier = modifier
                .height(44.dp)
                .background(
                    shape = RoundedCornerShape(12.dp),
                    color = LightColor.SUBPrimary,
                )
                .wrapContentHeight(Alignment.CenterVertically)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    if (onClick != null) {
                        onClick()
                    }
                }
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(start = 14.dp),
                    value = value,
                    onValueChange = onValueChange,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = keyboardType,
                        imeAction = imeAction
                    ),
                    visualTransformation = if (!passwordVisible && isPassword) PasswordVisualTransformation() else VisualTransformation.None,
                    maxLines = 1,
                    textStyle = LucianTypography.R16.copy(color = Color.White),
                    decorationBox = { innerTextField ->
                        if (value.isEmpty() && hint != null) {
                            Text(text = hint, color = LightColor.GRAY4)
                        }

                        innerTextField()
                    },
                )
//                if (isPassword) {
//                    Image(
//                        modifier = Modifier
//                            .clickable(
//                                interactionSource = interactionSource,
//                                indication = null
//                            ) { passwordVisible = !passwordVisible },
//                        painter = if (passwordVisible) painterResource(id = SMonkeyIcon.EYE_ON) else painterResource(
//                            id = SMonkeyIcon.EYE_OFF
//                        ),
//                        contentDescription = null,
//                        alpha = if (value.isNotEmpty()) 1f else 0f
//                    )
//                }
            }
        }
//
//        if (error != null) {
//            SmonkeyBody10(
//                text = error,
//                modifier = Modifier.padding(start = 3.dp, top = 6.dp),
//                color = SMonkeyColor.Error,
//            )
//        }
    }
}

@Preview
@Composable
fun PreviewLucianTextField() {
    var value by remember { mutableStateOf(String()) }
    var value2 by remember { mutableStateOf(String()) }
    var value3 by remember { mutableStateOf(String()) }
    var value4 by remember { mutableStateOf(String()) }

    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        // default text field
        LucianTextField(
            value = value,
            onValueChange = { value = it }
        )

        Spacer(modifier = Modifier.height(15.dp))

        // password text field
        LucianTextField(
            value = value2,
            onValueChange = { value2 = it },
            isPassword = true
        )

        Spacer(modifier = Modifier.height(15.dp))

        // error text field
        LucianTextField(
            value = value3,
            onValueChange = { value3 = it },
            error = "특수문자는 사용할 수 없습니다!"
        )

        Spacer(modifier = Modifier.height(15.dp))

        // description text field
        LucianTextField(
            value = value4,
            onValueChange = { value4 = it },
            titleHint = "비밀번호"
        )
    }
}