package 미니과제;

import java.util.Random;
import java.util.Scanner;

/*
    안재현
    주민등록번호 생성 프로그램

    주민등록번호 생성 로직에 맞게 주민등록번호 생성
    입력값은 생년, 월, 일, 성별과 임의의 번호를 통해 생성
    임의번호는 Random함수의 nextInt() 함수를 통해 생성
 */
public class java04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해 주세요. (yyyy):");
        int year = sc.nextInt() % 100;

        System.out.print("출생월을 입력해 주세요. (mm):");
        int month = sc.nextInt();

        System.out.print("출생일을 입력해 주세요. (dd):");
        int day = sc.nextInt();

        System.out.print("성별을 입력해 주세요. (m/f):");
        int sex = sc.next().charAt(0) == 'm' ? 3 : 4; //m이면 3 아니면 4

        // 100000 ~ 999999 랜덤범위 지정
        int ran = random.nextInt(899999) + 100000;

        System.out.printf("%02d%02d%02d-%d%d", year, month, day, sex, ran);


    }
}
