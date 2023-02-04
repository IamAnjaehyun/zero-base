package 미니과제;

import java.util.Scanner;
/*
    안재현
    결제금액 캐시백 프로그램

    로직에 맞는 캐시백 계산
    결제 금액 입력시. 이에 대한 캐시백 계산 후 결과 출력
 */
public class java02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("결제 금액을 입력해 주세요.(금액):");
        int money = sc.nextInt();

        int point = (int)(money * 0.1);

        if (point >= 300) {
            point = 300;
        } else if (point >= 200) {
            point = 200;
        } else if (point >= 100) {
            point = 100;
        } else {
            point = 0;
        }

        System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.", money, point);
        sc.close();
    }
}
