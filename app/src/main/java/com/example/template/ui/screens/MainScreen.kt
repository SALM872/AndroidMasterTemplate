package com.example.template.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.template.data.entity.User
import com.example.template.ui.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()
) {

    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    val users by viewModel.users.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "BrightRoom Sample",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = {
                Text("Name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = {
                Text("Age")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {

                viewModel.insertUser(
                    name = name,
                    age = age.toIntOrNull() ?: 0
                )

                name = ""
                age = ""

            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Insert User")

        }

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn {

            items(users) { user ->

                UserCard(
                    user = user,
                    onUpdate = {
                        viewModel.updateUser(
                            user.copy(
                                name = user.name + " Updated",
                                age = user.age + 1
                            )
                        )
                    },
                    onDelete = {
                        viewModel.deleteUser(user)
                    }
                )

            }

        }

    }

}

@Composable
private fun UserCard(
    user: User,
    onUpdate: () -> Unit,
    onDelete: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(user.name)

            Text("Age : ${user.age}")

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Button(
                    onClick = onUpdate
                ) {
                    Text("Update")
                }

                Button(
                    onClick = onDelete
                ) {
                    Text("Delete")
                }

            }

        }

    }

}