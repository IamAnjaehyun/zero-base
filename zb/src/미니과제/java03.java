package 미니과제;

import java.util.Scanner;

/*
    안재현
    놀이동산 입장권 계산 프로그램

    놀이공원 입장료 구하는 조건에 맞게 로직 작성
    입력내용은 나이, 입장시간, 국가유공자 여부, 복지카드 순으로 입력
 */
public class java03 {
    public static void main(String[] args) {
        int pay = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("[입장권 계산]");

        System.out.print("나이를 입력해 주세요. (숫자):");
        int age = sc.nextInt();

        System.out.print("입장 시간을 입력해 주세요. (숫자입력):");
        int time = sc.nextInt();

        System.out.print("국가유공자 여부를 입력해 주세요. (y/n):");
        char merit = sc.next().charAt(0);

        System.out.print("복지카드 여부를 입력해 주세요. (y/n):");
        char card = sc.next().charAt(0);

        //가격이 낮은 순으로 조건 먼저
        if (age < 3) {//3세 미만 무료입장
            pay = 0;
        } else if (age < 13 || time >= 17) {//13세 미만 or 17시 이후 입장 특별할인
            pay = 4000;
        } else if (card == 'y' || merit == 'y') {//복지카드 보유 or 국가유공자 일반할인
            pay = 8000;
        } else {
            pay = 10000;
        }
        System.out.println("입장료: " + pay);
    }
}

