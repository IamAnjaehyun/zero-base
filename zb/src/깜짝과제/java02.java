package 깜짝과제;


import java.io.FileReader;
import java.io.IOException;

/*
    안재현
    깜짝과제-2

    전체 문자열의 길이는 String.length() 함수를 이용
    문자열(String)에서 특정 자리의 문자를 가져오는 String.charAt(index) 함수를 이용
    대소문자는 구분하지 않습니다.
    출력 형식을 아래 결과 이미지 형식에 맞출 것(포맷일치)
    내용은 텍스트 파일에서 읽어오며, 파일에서 텍스트를 읽어오는 소스는 추가 클래스 참조
 */
public class java02 {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/jaehyun/Desktop/zero-base/zb/src/깜짝과제/mini.txt";

        String files = readFile.readFile(filePath);



        int[] alphaCnt = {
                //a b c d e f g h i j
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0
        };

        for (int i = 0; i < files.length(); i++) {
            char c1 = files.charAt(i);

            if (c1 == 'a') {
                alphaCnt[0]++;
            } else if (c1 == 'b') {
                alphaCnt[1]++;
            } else if (c1 == 'c') {
                alphaCnt[2]++;
            } else if (c1 == 'd') {
                alphaCnt[3]++;
            } else if (c1 == 'e') {
                alphaCnt[4]++;
            } else if (c1 == 'f') {
                alphaCnt[5]++;
            } else if (c1 == 'g') {
                alphaCnt[6]++;
            } else if (c1 == 'h') {
                alphaCnt[7]++;
            } else if (c1 == 'i') {
                alphaCnt[8]++;
            } else if (c1 == 'j') {
                alphaCnt[9]++;
            } else if (c1 == 'k') {
                alphaCnt[10]++;
            } else if (c1 == 'l') {
                alphaCnt[11]++;
            } else if (c1 == 'm') {
                alphaCnt[12]++;
            } else if (c1 == 'n') {
                alphaCnt[13]++;
            } else if (c1 == 'o') {
                alphaCnt[14]++;
            } else if (c1 == 'p') {
                alphaCnt[15]++;
            } else if (c1 == 'q') {
                alphaCnt[16]++;
            } else if (c1 == 'r') {
                alphaCnt[17]++;
            } else if (c1 == 's') {
                alphaCnt[18]++;
            } else if (c1 == 't') {
                alphaCnt[19]++;
            } else if (c1 == 'u') {
                alphaCnt[20]++;
            } else if (c1 == 'v') {
                alphaCnt[21]++;
            } else if (c1 == 'w') {
                alphaCnt[22]++;
            } else if (c1 == 'x') {
                alphaCnt[23]++;
            } else if (c1 == 'y') {
                alphaCnt[24]++;
            } else if (c1 == 'z') {
                alphaCnt[25]++;
            }
        }

//        for (int i = 0; i < alphaCnt.length; i++) {
//            totalCount += alphaCnt[i];
//        }

        int totalCount = files.length();
        for (int i = 0; i < alphaCnt.length; i++) {
            double rate = (double) alphaCnt[i] / totalCount * 100;
            String format = String.format("%c = %6d개, \t %.2f%%", i + 65, alphaCnt[i], rate);
            System.out.println(format);
        }


    }
}
