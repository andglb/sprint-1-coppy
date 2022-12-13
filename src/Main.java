import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int months = 12;
        int days = 30;
        int mission=10000;
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("За какой месяц вы хотите ввести количество шагов: 0-ЯНВ, 1-ФЕВР, 2-МАРТ, 3-АПР, 4-МАЙ, 5-ИЮНЬ, 6-ИЮЛЬ, 7-АВГ, 8-СЕН, 9-ОКТ, 10-НОЯБ, 11-ДЕК?");
                int month = scanner.nextInt();
                if (month<0 || month>=months) {
                    System.out.println("Такого месяца в программе нет!");
                }
                else {
                    System.out.println("За какой день вы хотите ввести количество шагов?");
                    int day = scanner.nextInt();
                    if (day<0 || day>days) {
                        System.out.println("Такого дня в программе нет!");
                    }
                    else {
                        System.out.println("Введите количество шагов.");
                        stepTracker.saveStepsInDay(month, day);
                    }
                }
            }
            else if (command == 2) {
                System.out.println("Введите месяц за который нужно вывести статистику: 0-ЯНВ, 1-ФЕВР, 2-МАРТ, 3-АПР, 4-МАЙ, 5-ИЮНЬ, 6-ИЮЛЬ, 7-АВГ, 8-СЕН, 9-ОКТ, 10-НОЯБ, 11-ДЕК");
                int printMonth = scanner.nextInt();
                System.out.println("Количество шагов за каждый день месяца: ");
                stepTracker.printStepsOnTheMonth(printMonth);
                System.out.println();
                System.out.println("Сумма шагов за месяц - "+ stepTracker.printSumSteps(printMonth));
                System.out.println("Максимальное количество шагов за день - "+stepTracker.printMaxSteps(printMonth));
                System.out.println("Среднее количество шагов за месяц - "+stepTracker.averageNumberOfSteps(printMonth));
                System.out.println("За месяц пройдено - "+converter.printDistance(printMonth, stepTracker.printSumSteps(printMonth))+" км");
                System.out.println("За месяц сожжено - "+converter.printCalories(printMonth, stepTracker.printSumSteps(printMonth))+" килокалорий");
                System.out.println("Лучшая серия за месяц в днях - "+stepTracker.printBestSeries(mission, printMonth));
            }
            else if (command == 3) {
                mission=stepTracker.newMission(mission);
            }
            else if (command == 4) {
                System.out.println("Выходим из приложения!");
                break;
            }
            else {
                System.out.println("Такой команды пока что не существует :(");
                System.out.println("Попробуйте ввести команду из списка ниже");
            }
        }

    }
    public static void printMenu() {
        System.out.println("Выберите команду");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }
}
