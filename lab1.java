/*
 * Номер залікової книжки: 19
 * C5 (остача від ділення на 5): 4
 * C7 (остача від ділення на 7): 5
 * C11 (остача від ділення на 11): 8
 * Дія з матрицею: C = A × B, де × — матричний добуток
 * Тип елементів матриці: char
 * Дія з матрицею С: Знайти середнє значення елементів кожного рядка матриці
 */
public class lab1 {
    public static void main(String[] args) {
        try {
            // Оголошення та ініціалізація матриць типу char
            char[][] A = {
                    { '1', '2', '3' },
                    { '4', '5', '6' }
            };

            char[][] B = {
                    { '7', '8' },
                    { '9', 'A' }, // 'A' в Unicode дорівнює 65
                    { 'B', 'C' } // 'B' = 66, 'C' = 67
            };

            // Перевірка можливості множення матриць
            if (A[0].length != B.length) {
                throw new IllegalArgumentException(
                        "Неможливо перемножити матрицi: кiлькiсть стовпцiв A не дорiвнює кiлькостi рядкiв B.");
            }

            // Оголошення результуючої матриці C
            int rowsA = A.length;
            int colsB = B[0].length;
            int[][] C = new int[rowsA][colsB];

            // Множення матриць A і B
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    for (int k = 0; k < A[0].length; k++) {
                        // Виконуємо добуток символів як числові значення (код символу)
                        C[i][j] += (A[i][k] - '0') * (B[k][j] - '0');
                    }
                }
            }

            // Виведення результуючої матриці C
            System.out.println("Результуюча матриця C (множення A x B):");
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    System.out.print(C[i][j] + " ");
                }
                System.out.println();
            }

            // Знаходимо середнє значення елементів кожного рядка матриці C
            System.out.println("Середнє значення елементiв кожного рядка матрицi C:");
            for (int i = 0; i < rowsA; i++) {
                int sum = 0;
                for (int j = 0; j < colsB; j++) {
                    sum += C[i][j];
                }
                double average = (double) sum / colsB;
                System.out.println("Середнє значення для рядка " + (i + 1) + ": " + average);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Невiдома помилка: " + e.getMessage());
        }
    }
}
