package com.ilkehur.mywebsite

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.github.kdroidfilter.composemediaplayer.InitialPlayerState
import io.github.kdroidfilter.composemediaplayer.VideoPlayerSurface
import io.github.kdroidfilter.composemediaplayer.rememberVideoPlayerState
import org.jetbrains.compose.resources.painterResource

import mywebsite.composeapp.generated.resources.Res
import mywebsite.composeapp.generated.resources.compose_multiplatform

@Composable
fun App() {

    val playerState = rememberVideoPlayerState()
    playerState.openUri("https://huggingface.co/spaces/Nick088/Bad-Apple-Video/resolve/b638ac1f80add1d288e583443f495c46224b75b3/bad-apple.mp4")

    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent },
                modifier = Modifier.padding(5.dp)) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .safeContentPadding()
                        .padding(52.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("LE APPLE IS LE BADDDDDDD")
                        Button(onClick = {
                            if (playerState.isPlaying) {
                                playerState.pause()
                            } else {
                                playerState.play()
                            }
                        }) {
                            Text(if (playerState.isPlaying) "Pause" else "Play")
                        }
                    }
                    VideoPlayerSurface(
                        playerState = playerState,
                        modifier = Modifier.fillMaxSize()
                            .safeContentPadding()
                    )
                }
            }
        }
    }
}