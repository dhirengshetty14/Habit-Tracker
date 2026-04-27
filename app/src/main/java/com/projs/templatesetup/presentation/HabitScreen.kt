package com.projs.templatesetup.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HabitScreen(
    vm: HabitViewModel = hiltViewModel()
) {
    val habits by vm.habits.collectAsState()
    var txt by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ){
        OutlinedTextField(
            value = txt,
            onValueChange = {txt=it},
            label = { Text("Habit Name")},
            modifier = Modifier.fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                vm.addHabit(txt)
                txt=""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add habbit")
        }
        Spacer(modifier = Modifier.height(40.dp))

        LazyColumn {
            items(habits){
                habit ->

                Row(modifier= Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween)
                {
                    Text(habit.title)

                    Checkbox(
                        checked = habit.isCompleted,
                        onCheckedChange = {
                            vm.toggleHabit(habit)
                        }
                    )
                }
            }
        }
    }
}