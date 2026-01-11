package ru.yandex.practicum.gym;
import java.util.*;

public class CounterOfTrainings {
    private Coach coach;
    private int trainingCount;

    public CounterOfTrainings(Coach coach, int trainingCount) {
        this.coach = coach;
        this.trainingCount = trainingCount;
    }

    public static List<CounterOfTrainings> createCounterOfTrainingsList(Map<Coach, Integer> coachTrainingCountMap) {
        List<CounterOfTrainings> counterOfTrainingsList = new ArrayList<>();

        for (Map.Entry<Coach, Integer> entry : coachTrainingCountMap.entrySet()) {
            Coach coach = entry.getKey();
            int trainingCount = entry.getValue();

            CounterOfTrainings counterOfTrainings = new CounterOfTrainings(coach, trainingCount);
            counterOfTrainingsList.add(counterOfTrainings);
        }

        return counterOfTrainingsList;
    }

    public static void sortCounterOfTrainings(List<CounterOfTrainings> counterOfTrainingsList) {
        counterOfTrainingsList.sort(new Comparator<CounterOfTrainings>() {
            @Override
            public int compare(CounterOfTrainings o1, CounterOfTrainings o2) {
                return o2.getTrainingCount() - o1.getTrainingCount();
            }
        });
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public int getTrainingCount() {
        return trainingCount;
    }

    public void setTrainingCount(int trainingCount) {
        this.trainingCount = trainingCount;
    }
}