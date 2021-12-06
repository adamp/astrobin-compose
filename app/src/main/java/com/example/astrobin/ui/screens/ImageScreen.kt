package com.example.astrobin.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.navigation.NavController
import com.example.astrobin.api.AstroImage
import com.example.astrobin.api.LocalAstrobinApi

@Composable
fun ImageScreen(
  hash: String,
  nav: NavController
) {
  val api = LocalAstrobinApi.current
  val data = produceState<AstroImage?>(null) {
    value = api.image(hash)
  }.value
  if (data == null) {
    Text(text = "Loading...")
  } else {
    Column {
      Text(text = data.title)
      Text(data.url_gallery)
    }
  }
}