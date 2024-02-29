package Others.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... spiralMatrix) {
        int[][] array = {{12, 42, 73, 34},
                         {45, 68, 67, 80},
                         {78, 97, 10, 14},
                         {88, 91, 11, 44}};
        List<Integer> spiralMatrixResult = spiralMatrix(array);
        System.out.println(spiralMatrixResult);
    }

    private static List<Integer> spiralMatrix(int[][] array) {
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = array.length-1;
        int colEnd = array[0].length-1;
        List<Integer> list = new ArrayList<>();

        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            //Step1
            for (int i=colBegin; i<=colEnd; i++) {
                list.add(array[rowBegin][i]);
            }
            rowBegin++;

            //Step2
            for (int i=rowBegin; i<=rowEnd; i++) {
                list.add(array[i][colEnd]);
            }
            colEnd--;

            //Step3
            if (rowBegin <= rowEnd) {
                for (int i=colEnd; i>=colBegin; i--) {
                    list.add(array[rowEnd][i]);
                }
            }
            rowEnd--;

            //Step4
            if (colBegin <= colEnd) {
                for (int i=rowEnd; i>=rowBegin; i--) {
                    list.add(array[i][colBegin]);
                }
            }
            colBegin++;
        }

        return list;
    }
}
