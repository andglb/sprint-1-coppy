public class Converter {
    int[][] stepsInDay;
    Converter() {
        stepsInDay = new int[12][30];
    }
    //Дистанция
    double printDistance(int month, int maxSteps) {
        int distance = maxSteps * 75/100000;
        return distance;
    }
    //Калории
    double printCalories(int month, int sumSteps) {
        int calories = sumSteps * 50/1000;
        return calories;
    }
}
