package 미니과제;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Scanner;

/*
    안재현
    달력 출력 프로그램

    입력받은 년도와 월을 통한 달력 생성
    입력값은 년도, 월을 입력
    날짜는 LoaclDate클래스를 이용 (Calendar와 Date클래스도 이용 가능)
 */
public class java05 {
    public static void solution(int year, int month) {
        int cnt = 0;

        System.out.printf("[%04d년%02d월]\n", year, month);
        System.out.println("일\t월\t화\t수\t목\t금\t토\t");

        LocalDate base = LocalDate.of(year, month, 1);

        int firstDay = base.get(ChronoField.DAY_OF_WEEK); //1일의 요일 3 = 수
        int lastDate = base.lengthOfMonth(); //마지막 날짜


        //첫 날이 월요일인 날이 있을 수 있으니 (firstDay != 7) 일때만 /t로 시작점 위치를 조정
        if (firstDay != 7) {
            for (int i = 0; i < firstDay; i++) {
                System.out.print("\t");
                cnt++;
            }
        }

        for (int j = 1; j <= lastDate; j++) {
            System.out.printf("%02d\t", j);
            cnt++;
            if (cnt % 7 == 0) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int year;
        int month;

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[달력 출력 프로그램]");
            System.out.print("달력의 년도를 입력해 주세요. (yyyy):");
            year = sc.nextInt();
            if (year < 0) {
                System.out.println("년도 입력이 잘못되었습니다. 처음으로 돌아갑니다.\n");
                continue;
            }

            System.out.print("달력의 월을 입력해 주세요. (mm):");
            month = sc.nextInt();
            if (month <= 0 || month > 12) {
                System.out.println("월 입력이 잘못되었습니다. 처음으로 돌아갑니다.\n");
                continue;
            }
            break;
        }

        solution(year, month);
        sc.close();
    }
}
