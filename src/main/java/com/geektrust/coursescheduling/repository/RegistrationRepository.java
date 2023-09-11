package com.geektrust.coursescheduling.repository;

import com.geektrust.coursescheduling.entities.Registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationRepository {
    private static Map<String, List<Registration>> registrationMap = new HashMap<>();
    // courseId -- List<Registration>

    public RegistrationRepository() {
    }

    public List<Registration> findRegistrationsByCourseId(String courseId) {
        return registrationMap.get(courseId);
    }

    public void saveRegistration(String courseId, Registration registration) {
        if (!registrationMap.containsKey(courseId)) {
            registrationMap.put(courseId, new ArrayList<>());
        }
        registrationMap.get(courseId).add(registration);
    }

    public void updateRegistrations(String courseId, List<Registration> registrationList) {
        registrationMap.put(courseId, registrationList);
    }

    public void deleteRegistrationById(String registrationId) {
        registrationMap.remove(registrationId);
    }
}
