package 미니과제;

import java.util.Scanner;

/*
    안재현
    연소득 과세금액 계산 프로그램

    연소득 금액 입력
    주어진 종합소득세율표를 통한 조건 생성
 */

/**
 * 12,000,000원 이하 6%
 * 46,000,000원 이하 15%
 * 88,000,000원 이하 24%
 * 150,000,000원 이하 35%
 * 300,000,000원 이하 38%
 * 500,000,000원 이하 40%
 * 1000,000,000원 이하 42%
 * 1000,000,000원 초과 45%
 */

public class java08 {
    static long taxByRate = 0;           // 세율에 의한 세금
    static long progressiveTax = 0;    // 누진공제 계산에 의한 세금

    // 과세표준
    static long[] taxBase = {0, 12000000L, 46000000L, 88000000L, 150000000L, 300000000L, 500000000L, 1000000000L, Long.MAX_VALUE};
    // 누진공제
    static long[] progressiveDeduction = {0, 0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};
    // 세율
    static int[] rate = {0, 6, 15, 24, 35, 38, 40, 42, 45};

    //세율에 의한 세금
    public static long researchTaxRate(Long money) {
        for (int i = 1; i < taxBase.length; i++) {
            // 작은 금액부터 확인해서 마지막에 여기로 도달
            if (money <= taxBase[i]) {
                //마지막 남은금액
                long now = (money - taxBase[i - 1]) * rate[i] / 100;
                System.out.printf("%10d  *  %2d%% = %10d\n\n", money - taxBase[i - 1], rate[i], now);
                taxByRate += now;
                break;
            // 과세표준별 세율 적용해서 taxBase[i]- taxBase[i-1]꺼 냄
            } else {
                long now = rate[i] * (taxBase[i] - taxBase[i - 1]) / 100;
                System.out.printf("%10d  *  %2d%% = %10d\n", taxBase[i] - taxBase[i - 1], rate[i], now);
                taxByRate += now;//세율에 의한 세금은 반복문 돌때마다 더해줌
            }
        }
        return taxByRate;
    }

    // 누진공제 계산에 의한 세금
    public static long researchProgressiveTax(Long money) {
        for (int i = 1; i < taxBase.length; i++) {
            // 번돈 <= 세금 기준액
            if (money <= taxBase[i]) {
                progressiveTax = (money * rate[i] / 100) - progressiveDeduction[i];
                break;
            }
        }
        return progressiveTax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");
        long money = sc.nextLong();


        System.out.printf("[세율에 의한 세금]:\t\t\t %8d\n", researchTaxRate(money));
        //연소득 1200만원 안넘으면 계산안해도됨
        if (money > 12000000) {
            progressiveTax = researchProgressiveTax(money);
        }
        System.out.printf("[누진공제 계산에 의한 세금]:\t %8d\n", progressiveTax);

        sc.close();
    }
}

