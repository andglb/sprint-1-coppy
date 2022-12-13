import java.util.Scanner;
public class StepTracker {
    int[][] stepsInDay;
    int months = 12;
    int days = 30;
    Scanner scanner = new Scanner(System.in);

    StepTracker() {

        stepsInDay = new int[months][days];
    }

    //Сохранение количества шагов
    void saveStepsInDay(int month, int day) {
        int steps = scanner.nextInt();
        if (steps<0){
            System.out.println("Количество шагов не должно быть отрицательным!");
        }
        else {
            stepsInDay[month][day - 1] = steps;
            System.out.println("Количество шагов сохранено!");
        }
    }

    //Статистика шагов за каждый день месяца
    void printStepsOnTheMonth(int month) {
        for (int i = 0; i < days; i++) {
            System.out.print((i + 1) + " день: " + stepsInDay[month][i]+", ");
        }
    }

    //Сумма всех шагов за месяц
    int printSumSteps(int month) {
        int sumSteps = 0;
        for (int i = 0; i < days; i++) {
            sumSteps = sumSteps + stepsInDay[month][i];
        }
        return sumSteps;
    }

    //Максимальное количество шагов в сутки
    int printMaxSteps(int month) {
        int maxSteps = 0;
        for (int i = 0; i < days; i++) {
            if (stepsInDay[month][i] > maxSteps) {
                maxSteps = stepsInDay[month][i];
            }
        }
        return maxSteps;
    }

    //Среднее количество шагов в месяц
    int averageNumberOfSteps(int month) {
        int average = printSumSteps(month) / days;
        return average;
    }

    //Установить новое целевое значение шагов
    int newMission(int mission) {
        System.out.println("Цель - " + mission + " шагов в день.");
        System.out.println("Введите новое целевое количество шагов!");
        int newMission = scanner.nextInt();
        if (newMission<0) {
            System.out.println("Значение не должно быть отрицательным!");
            return mission;
        }
        mission = newMission;
        System.out.println("Целевое количество шагов изменено!");
        return mission;
    }

    //Лучшая серия
    int printBestSeries(int mission, int month) {
        int series = 0;
        int bestSeries = 0;
        for (int i = 0; i < days; i++) {
            if (mission <= stepsInDay[month][i]) {
                series = series + 1;
                if (bestSeries < series) {
                    bestSeries = series;
                }
            }
            else series = 0;
        }
        return bestSeries;
    }
}