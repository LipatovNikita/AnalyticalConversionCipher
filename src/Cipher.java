import java.util.ArrayList;
import java.util.Arrays;

public class Cipher {
    final static char[] symbols = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
            'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    final static String stringForCipher = "помехоустойчивоекодированиеэтокодированиесвозможностьювосстановленияпотерянныхилиошибочнопринятыхданных";

    static ArrayList<Integer> listIfIndexes = getListOfIndexes(stringForCipher);

    public static ArrayList<Integer> getListOfIndexes(String string) {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for (int i = 0; i < string.length(); i++) {
            indexes.add(index(string.charAt(i)));
        }
        while (true) {
            if (indexes.size() % 4 != 0) {
                indexes.add(0);
            } else {
                break;
            }
        }
        return indexes;
    }

    public static int index(char sumbol) {
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == sumbol) {
                return i;
            }
        }
        return 0;
    }

    public static void multiplication(ArrayList<Integer> indexes) {
        int[] vector;
        int[][] bufferMatrix = new int[4][4];
        int[] resultVector = new int[4];
        int[][] matrix =
                {
                        {1, 2, 5, 4},
                        {3, 13, 9, 7},
                        {2, 3, 5, 11},
                        {5, 6, -5, 29}
                };
        for (int index = 0; index < listIfIndexes.size() + 22; index++) {
            vector = listIfIndexes.subList(0, 4).stream().mapToInt(Integer::intValue).toArray();
            listIfIndexes.subList(0, 4).clear();

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    bufferMatrix[i][j] = matrix[i][j] * vector[j];
                }
            }

            for (int i = 0; i < bufferMatrix.length; i++) {
                for (int j = 0; j < bufferMatrix[i].length; j++) {
                    resultVector[i] += bufferMatrix[i][j];
                }
                System.out.print(resultVector[i] + " ");
            }
            Arrays.fill(resultVector, 0);
        }

    }

    public static void main(String[] args) {
        System.out.print(listIfIndexes);
        System.out.println();
        multiplication(listIfIndexes);
    }
}
