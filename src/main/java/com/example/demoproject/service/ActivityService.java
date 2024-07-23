package com.example.demoproject.service;

import com.example.demoproject.entity.Activity;
import com.example.demoproject.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        savedActivity.setLimit(activity.getLimit());
        activityRepository.save(savedActivity);
    }
}
