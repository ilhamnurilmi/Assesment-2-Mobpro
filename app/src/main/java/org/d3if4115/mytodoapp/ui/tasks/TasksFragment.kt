package org.d3if4115.mytodoapp.ui.tasks

import androidx.fragment.app.Fragment
import org.d3if4115.mytodoapp.R
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TasksFragment : Fragment(R.layout.fragment_tasks) {

    private val viewModel: TasksViewModel by viewModels()
}
