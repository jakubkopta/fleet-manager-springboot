package com.project.web;

import com.project.service.TaskService;
import com.project.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String readAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }

    @GetMapping("/new")
    public String createTask(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "create_task";
    }

    @PostMapping
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable int id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "edit_task";
    }

    @PostMapping("/{id}")
    public String updateTask(@PathVariable int id, @ModelAttribute("task") Task task, Model model) {
        Task existingTask = taskService.getTaskById(id);
        existingTask.setId(id);
        existingTask.setDescription(task.getDescription());

        taskService.updateTask(existingTask);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTaskById(id);
        return "redirect:/tasks";
    }
}
