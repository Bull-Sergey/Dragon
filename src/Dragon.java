import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Dragon {
    static void main(String[] args) throws IOException {
        String fileInput = "INPUT.TXT", fileOutput = "OUTPUT.TXT", s;
        Scanner scanner = new Scanner(new File(fileInput));
        int n = scanner.nextInt(); // число голов срубает за раз
        int m = scanner.nextInt(); // число голов дракона изначально
        int k = scanner.nextInt(); // число голов регенерирует
        scanner.close();
        PrintWriter out = new PrintWriter("OUTPUT.TXT");
        if (m <= n) {
            out.println(1);
        } else if (n <= k) {
            out.println("NO");
        } else {
            /*
            int round = n - k; // сколько голов сносит за раунд
            int first = m - n; // сколько голов осталось первый раз
            int fullRounds = (first + round - 1) / round; // всего раундов
            out.println(fullRounds + 1);
            */
            int fullRounds = 0;

            while (m > 0) {
                fullRounds++;
                m = m - n; // осталось голов
                if (m > 0)  // если хоть одна голова осталась
                    m = m + k; // регенерируем головы
            }

            out.println(fullRounds);
        }
        out.close();
    }
}
