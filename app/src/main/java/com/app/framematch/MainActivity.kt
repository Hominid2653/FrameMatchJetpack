package com.app.framematch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.framematch.ui.theme.FrameMatchJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FrameMatchJetpackTheme {
                StateBasedNavigation()
            }
        }
    }
}


@Composable
fun StateBasedNavigation() {
    // State to track the current screen
    var currentScreen by remember { mutableStateOf("Login") }

    // Switch between screens based on currentScreen value
    when (currentScreen) {
        "Login" -> LoginScreen(onNavigateToRegister = {
            currentScreen = "Register"
        }, onNavigateToHome = {
            currentScreen = "Home"
        })
        "Register" -> RegisterScreen(onBackToLogin = {
            currentScreen = "Login"
        })
        "Home" -> HomeScreen(onNavigateToLogin = {
            currentScreen = "Login"
        })
    }
}

@Composable
fun LoginScreen(onNavigateToRegister: () -> Unit, onNavigateToHome: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Login Screen")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateToRegister) {
            Text("Go to Register Screen")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateToHome) {
            Text("Go to Home Screen")
        }
    }
}

@Composable
fun RegisterScreen(onBackToLogin: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Register Screen")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onBackToLogin) {
            Text("Back to Login Screen")
        }
    }
}

@Composable
fun HomeScreen(onNavigateToLogin: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Welcome to the Home Screen!")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateToLogin) {
            Text("Logout")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StateBasedNavigationPreview() {
    FrameMatchJetpackTheme {
        StateBasedNavigation()
    }
}
