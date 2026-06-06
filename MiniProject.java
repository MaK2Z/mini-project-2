import java.util.Scanner;

public class MiniProject {
    public static void main(String[] args){
        Project mini = new Project();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("\nВведите предмет: ");
        String works = scanner.nextLine();

        System.out.print("\nВведите коллчество оценок: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        int num = 0;

        System.out.println("Введите ваши оценки:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
            num = array [i];
            if (array[i] > 5){
                System.out.println("Ваша оценка не может быть выше 5.");
                break;
            } else if (array[i] < 2) {
                System.out.println("Ваша оценка не может быть ниже 2.");
                break;
            }
        }

        if (size == 0){
            System.out.println("Отсутствуют оценки. Расчет окончен.");
        }
        else if (num > 5);
        else if (num < 2);
        else {
            System.out.println("Имя: " + name);
            System.out.println("Предмет: " + works);
            mini.conclusion(array);
            mini.calculation(array,0,0);
            mini.miniNum(array,5);
            mini.maxNum(array,0);
            mini.SumFiveAndTow(array,0,0);
        }
        scanner.close();


    }
    static class Project{
        void conclusion(int[] array){

            System.out.println("Ваши оценки:");
            for (int num : array) {
                System.out.print(num + " ");
            }
        }

        void calculation (int[] array, double sum, double quant){
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
                quant++;

            }
            double result = sum / quant;

            System.out.printf("\nВаш средний балл состовляет: %.1f\n", result);

            if (result == 5){
                System.out.println("Ваш статус - «отлично»");
            } else if (result > 3) {
                System.out.println("Ваш статус - «нормально»");
            }else{
                System.out.println("Ваш статус - «нужно подтянуть»");
            }

        }

        void miniNum (int[] array, int boxMin){
            for (int i = 0; i < array.length; i++) {
                if (boxMin > array[i]){
                    boxMin = array[i];
                }
            }
            System.out.printf("Ваша минимальная оценка: %d\n", boxMin);
        }

        void maxNum (int[] array, int boxMax){
            for (int i = 0; i < array.length; i++) {
                if (boxMax < array[i]){
                    boxMax = array[i];
                }
            }
            System.out.printf("Ваша максимальная оценка: %d\n", boxMax);
        }

        void SumFiveAndTow(int[] array, int box5, int box2){
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 5){
                    box5++;
                }

                if (array[i]< 3){
                    box2++;
                }
            }

            System.out.printf("Ваше колличество пятерок: %d\nВаше колличество оценок ниже 3: %d\n",box5,box2 );
        }


    }
}
