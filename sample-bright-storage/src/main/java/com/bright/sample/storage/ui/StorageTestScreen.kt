package com.bright.sample.storage.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bright.sample.storage.viewmodel.StorageTestViewModel
import com.bright.storage.extensions.displayIcon
import com.bright.storage.extensions.displayName
import com.bright.storage.extensions.extension
import com.bright.storage.extensions.modifiedDate
import com.bright.storage.extensions.readableDuration
import com.bright.storage.extensions.readableSize
import com.bright.storage.extensions.resolution
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.bright.storage.extensions.loadThumbnail


@Composable
fun StorageTestScreen(
    viewModel: StorageTestViewModel = viewModel()
) {

    val files = viewModel.files
    val message = viewModel.message
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = message,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                viewModel.pickImage()
            }
        ) {
            Text("Pick Image")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                viewModel.pickImages()
            }
        ) {
            Text("Pick Multiple Images")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {
                viewModel.pickVideo()
            }
        ) {
            Text("Pick Video")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {
                viewModel.pickVideos()
            }
        ) {
            Text("Pick Multiple Videos")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {
                viewModel.pickDocument()
            }
        ) {
            Text("Pick Document")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                viewModel.pickDocuments()
            }
        ) {
            Text("Pick Multiple Documents")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {
                viewModel.pickAudio()
            }
        ) {
            Text("Pick Audio")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                viewModel.pickAudios()
            }
        ) {
            Text("Pick Multiple Audio")
        }

        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {
                viewModel.captureImage()
            }
        ) {
            Text("Capture Image")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                viewModel.captureVideo()
            }
        ) {
            Text("Capture Video")
        }

        Spacer(modifier = Modifier.height(12.dp))



        if (files.isNotEmpty()) {

            Spacer(modifier = Modifier.height(24.dp))

            val selectedType = files.first().type

            Text(
                text = when (selectedType) {
                    com.bright.storage.builder.StorageType.IMAGE ->
                        "Selected Images : ${files.size}"

                    com.bright.storage.builder.StorageType.VIDEO ->
                        "Selected Videos : ${files.size}"

                    com.bright.storage.builder.StorageType.DOCUMENT ->
                        "Selected Documents : ${files.size}"

                    com.bright.storage.builder.StorageType.AUDIO ->
                        "Selected Audio : ${files.size}"

                    else ->
                        "Selected Files : ${files.size}"
                },
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            files.forEachIndexed { index, file ->

                Text("${file.displayIcon} ${file.displayName} ${index + 1}")
                Spacer(modifier = Modifier.height(8.dp))

                val thumbnail = remember(file.uri) {
                    file.loadThumbnail(context)
                }

                thumbnail?.let {

                    Spacer(modifier = Modifier.height(8.dp))

                    Image(
                        bitmap = it.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier.size(140.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                }

                Text("Name : ${file.name}")

                Text("Extension : ${file.extension}")

                Text("Size : ${file.readableSize}")

                Text("Duration : ${file.readableDuration}")

                Text("Resolution : ${file.resolution}")

                Text("Modified : ${file.modifiedDate}")

                Text("Uri : ${file.uri}")

                Text("${file.displayIcon} ${file.displayName} File")
                file.artist?.let {
                    Text("Artist : $it")
                }

                file.album?.let {
                    Text("Album : $it")
                }

                file.genre?.let {
                    Text("Genre : $it")
                }

                file.year?.let {
                    Text("Year : $it")
                }

                file.bitrate?.let {
                    Text("Bitrate : ${it / 1000} kbps")
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}