package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        logo = painterResource(id = R.drawable.android_logo),
                        fullName = "Onur AKIN",
                        businessTitle = "Vice President of Ideation and Disruption",
                        phone = "+0 (000) 000 00 00",
                        handle = "@otuva",
                        email = "onralpakin@gmail.com",
                        accentColor = Color(0xFF007FFF)
                    )
                }
            }
        }
    }
}

/**
 * Main component for business card screen. Calls header and footer
 * */
@Composable
fun BusinessCard(
    logo: Painter,
    fullName: String,
    businessTitle: String,
    phone: String,
    handle: String,
    email: String,
    accentColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        // take full space and center
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // logo name title
        CardHeader(
            logo = logo,
            fullName = fullName,
            businessTitle = businessTitle,
            accentColor = accentColor
        )
        // info
        CardFooter(
            phone = phone,
            handle = handle,
            email = email,
            accentColor = accentColor
        )
    }
}

/**
 * First part of the business card. Displays logo, name, and title
 * */
@Composable
fun CardHeader(logo: Painter, fullName: String, businessTitle: String, accentColor: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 100.dp,
                bottom = 300.dp
            )
    ) {
        // logo with accentColor background
        Box(modifier = Modifier.background(accentColor)) {
            Image(
                painter = logo,
                contentDescription = "Business card logo",
                modifier = Modifier.requiredSize(100.dp)
            )
        }
        // name
        Text(
            text = fullName,
            fontSize = 32.sp,
            modifier = Modifier.padding(8.dp)
        )
        // title with accentColor
        Text(
            text = businessTitle,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            color = accentColor
        )
    }
}

/**
 * Second part of the business card. Displays contact info such as phone, handle, email
 * */
@Composable
fun CardFooter(phone: String, handle: String, email: String, accentColor: Color) {
    val phoneIcon = painterResource(id = R.drawable.baseline_phone_24)
    val shareIcon = painterResource(id = R.drawable.baseline_share_24)
    val emailIcon = painterResource(id = R.drawable.baseline_email_24)

    // column with IconText rows
    Column {
        // phone
        IconText(
            icon = phoneIcon,
            iconDescription = "Phone Icon",
            text = phone,
            accentColor = accentColor
        )
        // handle
        IconText(
            icon = shareIcon,
            iconDescription = "Share Icon",
            text = handle,
            accentColor = accentColor
        )
        // email
        IconText(
            icon = emailIcon,
            iconDescription = "Email Icon",
            text = email,
            accentColor = accentColor
        )
    }
}

/**
 * Little component that displays given icon with accentColor and text.
 * */
@Composable
fun IconText(icon: Painter, iconDescription: String, text: String, accentColor: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = icon,
            contentDescription = iconDescription,
            modifier = Modifier.padding(8.dp),
            colorFilter = ColorFilter.tint(accentColor)
        )
        Text(
            text = text,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(
            logo = painterResource(id = R.drawable.android_logo),
            fullName = "Onur AKIN",
            businessTitle = "Vice President of Ideation and Disruption",
            phone = "+0 (000) 000 00 00",
            handle = "@otuva",
            email = "onralpakin@gmail.com",
            accentColor = Color(0xFF007FFF)
        )
    }
}