package ru.yandex.practicum.gym;

import java.util.*;

public class Timetable {

    private final Map<DayOfWeek, TreeMap<TimeOfDay, TrainingSession>> timetable = new HashMap<>();

    public void addNewTrainingSession(TrainingSession trainingSession) {

        DayOfWeek day = trainingSession.getDayOfWeek();
        TimeOfDay time = trainingSession.getTimeOfDay();
        if (!timetable.containsKey(day)) {
            timetable.put(day, new TreeMap<>());
        }
        timetable.get(day).put(time, trainingSession);
    }

    public Collection<TrainingSession> getTrainingSessionsForDay(DayOfWeek dayOfWeek) {
        return timetable.getOrDefault(dayOfWeek, new TreeMap<>()).values();
    }

    public Collection<TrainingSession> getTrainingSessionsForDayAndTime(DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        TreeMap<TimeOfDay, TrainingSession> dayTimetable = timetable.get(dayOfWeek);
        if (dayTimetable == null) {
            return Collections.emptyList();
        }

        TrainingSession session = dayTimetable.get(timeOfDay);
        if (session == null) {
            return Collections.emptyList();
        } else {
            return Collections.singletonList(session);
        }
    }
}
