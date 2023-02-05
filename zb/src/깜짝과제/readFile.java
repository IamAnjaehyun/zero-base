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
public class readFile {
    public static String readFile(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        String files = "";
        int ch;
        while ((ch = reader.read()) != -1) {
            files += (char) ch;
        }
        files = files.toLowerCase();
//        System.out.println(files.length());
        return files;
    }
}
