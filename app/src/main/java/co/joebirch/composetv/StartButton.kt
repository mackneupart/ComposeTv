package co.joebirch.composetv

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.net.URLEncoder

@Composable
fun StartButton(
    navController: NavController,
) {
        //URL til playlister
    val hesteLink = encodeURL("https://open.smk.dk/shared-list?list=KMS1302,KMS4380,KMSsp522,KMS3418,KKS2012-71,KMS3608,KMS894,KMS868,KMS4568,KMS3402&list_title=null")
    val skovenLink = encodeURL("https://open.smk.dk/shared-list?list=KMS4381,KMS1478,KMS8551,KMS6842,KMS7031,KMS719,KMS3209,KMS824,KKS9283a,KMS3657,KMS714,KMS6268,KMS4094,KMS611,KMS529,KMS413,KKSgb136,KMS6533&list_title=null")
    val sommerLink = encodeURL( "https://open.smk.dk/shared-list?list=KMS4138,KMS6856,KMS6655,KMS4126,KKS15460,KKS7936,KMS2075,KMS4209,KMS1658,KMS1568,KMS4928,KMS3120,KMS6340&list_title=null")

    val interactionSource = remember { MutableInteractionSource()}
    val interactionSource1 = remember { MutableInteractionSource()}
    val interactionSource2 = remember { MutableInteractionSource()}
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFFFAFAFA)),
        contentAlignment = Alignment.Center,
    ){
        Column(

        ){
            Text(
                text = "Spillelister: ",
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .focusRequester(focusRequester),
                onClick = { navController.navigate(route = hesteLink) },
                colors = buttonColors(
                    backgroundColor = if (interactionSource.collectIsFocusedAsState().value) Color.Blue else Color.Gray),
                    interactionSource = interactionSource
            ) {

                Text(
                    text = "Heste",
                    fontSize = MaterialTheme.typography.h3.fontSize,
                    fontWeight = FontWeight.Bold,
                    color = Color.White

                )

            }


            Button(
                modifier = Modifier.padding(16.dp),
                onClick = {navController.navigate(route = skovenLink)},
                colors = buttonColors(
                    backgroundColor = if (interactionSource1.collectIsFocusedAsState().value) Color.Blue else Color.Gray,
                    contentColor = Color.Black
                ),
                interactionSource = interactionSource1

            ){
                Text(
                    text = "Skov",
                    fontSize = MaterialTheme.typography.h3.fontSize,
                    fontWeight = FontWeight.Bold,
                    color = Color.White

                )
            }

            Button(
                modifier = Modifier.padding(16.dp),
                onClick = {navController.navigate(route = sommerLink)},
                colors = buttonColors(
                    backgroundColor = if (interactionSource2.collectIsFocusedAsState().value) Color.Blue else Color.Gray,
                    contentColor = Color.White
                ),
                interactionSource = interactionSource2


            ){
                Text(
                    text = "Sommer",
                    fontSize = MaterialTheme.typography.h3.fontSize,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

fun encodeURL(url:String): String {
    val encodedUrl = URLEncoder.encode(url, "UTF-8")
    return "carousel_screen/$encodedUrl"
}



