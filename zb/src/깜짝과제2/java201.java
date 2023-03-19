package 깜짝과제2;

import java.io.*;
/*
    안재현
    깜짝과제 1번

    그림에 보이는 웹브라우저 화면은 자바의 환경 정보를
    html의 테이블 구조로 출력한 화면입니다. 아래 조건에
    맞게 property.html 파일을 만드는 코드를 작성하세요.
    */
public class java201 {
    public static void main(String[] args) {
        try {
            File file = new File("index.html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("<html><head>\n<meta charset=\"UTF-8\" />\n");
            writer.write("<style>\ntable { border-collapse: collapse; width: 100%; }\n");
            writer.write("th, td { border:solid 1px #000; }\n</style>\n</head>\n");

            writer.write("<body>\n<h1>자바 환경정보</h1>\n<table>\n");
            writer.write("<tr>\n<th>키</th>\n<th>값</th>\n</tr>\n");

            for (Object k : System.getProperties().keySet()) {
                String key = k.toString();
                String value = System.getProperty(key);

                writer.write("<tr>\n<td>" + key + "</td>\n<td>" + value + "</td>\n</tr>\n");
            }
            writer.write("\n</table>\n</body>\n</html>\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
