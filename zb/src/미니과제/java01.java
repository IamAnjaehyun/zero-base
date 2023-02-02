package 미니과제;
/*
    안재현
    구구단 출력 프로그램

    다중for문 사용
    format 함수 사용
     1~9단 표시
 */
public class java01 {
    public static void main(String[] args) {
        System.out.println("[구구단 출력]");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%02d * %02d = %02d\t", j, i, j * i);
            }
            System.out.println();
        }
    }
}