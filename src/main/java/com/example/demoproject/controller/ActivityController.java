package com.example.demoproject.controller;

import com.example.demoproject.entity.Activity;
import com.example.demoproject.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/activity/v1")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping(path = "getAllActivities")
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    @PostMapping(path = "savedActivity")
    public void saveActivity(@RequestBody Activity activity) {
        activityService.savedActivity(activity);
    }
}
