package com.example.demoproject.controller;

import com.example.demoproject.entity.Activity;
import com.example.demoproject.entity.Hotel;
import com.example.demoproject.repository.ActivityRepository;
import com.example.demoproject.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/activity/v1")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;
    private final ActivityRepository activityRepository;

    @GetMapping(path = "getAllActivities")
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    @PostMapping(path = "savedActivity")
    public void saveActivity(@RequestBody Activity activity) {
        activityService.savedActivity(activity);
    }

    @DeleteMapping(path = "deleteActivity/{id}")
    public Map<String, Boolean> deleteActivity(@PathVariable(value = "id") Long activityId) {
        return activityService.deleteActivity(activityId);
    }
}
