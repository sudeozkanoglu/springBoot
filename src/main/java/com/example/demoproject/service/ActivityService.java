package com.example.demoproject.service;

import com.example.demoproject.entity.Activity;
import com.example.demoproject.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public void savedActivity(Activity activity) {
        Activity savedActivity = new Activity();
        savedActivity.setActivityName(activity.getActivityName());
        savedActivity.setActivityDate(activity.getActivityDate());
        savedActivity.setActivityTime(activity.getActivityTime());
        savedActivity.setTargetGroup(activity.getTargetGroup());
        savedActivity.setPersonLimit(activity.getPersonLimit());
        activityRepository.save(savedActivity);
    }

    public Map<String, Boolean> deleteActivity(Long activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity is not found for this id :: " + activityId));
        activityRepository.delete(activity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
