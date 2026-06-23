import java.util.InputMismatchException;
import java.util.Scanner;

public class MiniProject {
    public static void main(String[] args) {
        Project mini = new Project();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("\nВведите предмет: ");
        String subject = scanner.nextLine();

        System.out.print("\nВведите количество оценок: ");
        int size = 0;

        try {
            size = scanner.nextInt();

            if (size < 0) {
                System.out.println("Ошибка: количество оценок не может быть отрицательным. Программа завершена.");
                return;
            }

            int[] grades = new int[size];
            boolean hasInvalidGrade = false;

            System.out.println("Введите ваши оценки (от 2 до 5):");
            for (int i = 0; i < size; i++) {
                grades[i] = scanner.nextInt();

                if (grades[i] > 5 || grades[i] < 2) {
                    System.out.println("Ошибка: оценка должна быть от 2 до 5. Программа завершена.");
                    hasInvalidGrade = true;
                    break;
                }
            }

            if (size == 0) {
                System.out.println("Отсутствуют оценки. Расчет окончен.");
            } else if (hasInvalidGrade) {
                System.out.println("Программа завершена из-за некорректной оценки.");
            } else {
                System.out.println("Имя: " + name);
                System.out.println("Предмет: " + subject);

                mini.printGrades(grades);

                double average = mini.calculateAverage(grades);
                int min = mini.findMin(grades);
                int max = mini.findMax(grades);
                int countFives = mini.countFives(grades);
                int countBelowThree = mini.countBelowThree(grades);

                System.out.printf("\nВаш средний балл составляет: %.1f\n", average);
                printStatus(average);
                System.out.printf("Ваша минимальная оценка: %d\n", min);
                System.out.printf("Ваша максимальная оценка: %d\n", max);
                System.out.printf("Ваше количество пятерок: %d\n", countFives);
                System.out.printf("Ваше количество оценок ниже 3: %d\n", countBelowThree);
            }

        } catch (NegativeArraySizeException e) {
            System.out.println("Ошибка: введено отрицательное количество оценок. Программа завершена.");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не числовое значение. Программа завершена.");
        } finally {
            scanner.close();
        }
    }


    private static void printStatus(double average) {
        if (average == 5) {
            System.out.println("Ваш статус - «отлично»");
        } else if (average > 3) {
            System.out.println("Ваш статус - «нормально»");
        } else {
            System.out.println("Ваш статус - «нужно подтянуть»");
        }
    }

    static class Project {
        void printGrades(int[] grades) {
            System.out.println("Ваши оценки:");
            for (int grade : grades) {
                System.out.print(grade + " ");
            }
            System.out.println();
        }

        double calculateAverage(int[] grades) {
            double sum = 0;
            for (int grade : grades) {
                sum += grade;
            }
            return sum / grades.length;
        }

        int findMin(int[] grades) {
            int min = grades[0];
            for (int i = 1; i < grades.length; i++) {
                if (grades[i] < min) {
                    min = grades[i];
                }
            }
            return min;
        }

        int findMax(int[] grades) {
            int max = grades[0];
            for (int i = 1; i < grades.length; i++) {
                if (grades[i] > max) {
                    max = grades[i];
                }
            }
            return max;
        }

        int countFives(int[] grades) {
            int count = 0;
            for (int grade : grades) {
                if (grade == 5) {
                    count++;
                }
            }
            return count;
        }

        int countBelowThree(int[] grades) {
            int count = 0;
            for (int grade : grades) {
                if (grade < 3) {
                    count++;
                }
            }
            return count;
        }
    }
}