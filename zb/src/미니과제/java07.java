package 미니과제;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/*
    안재현
    로또 당첨 프로그램

    로또 구매 수량 입력
    입력한 개수만큼의 로또 개수 생성
    로또 당첨 번호 생성
    당첨번호와 구매 로또 비교하여 숫자 일치 여부 판단
 */
public class java07 {
    //로또 생성
    public static int[] makeLotto() {
        int[] lotto = new int[6];
        Random random = new Random();

        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = random.nextInt(45) + 1;
            // 중복번호 제거
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(lotto);

        return lotto;
    }

    //당첨개수 판별
    private static int getLottoCount(int[] lo, int[] comLotto) {
        int cnt = 0;
        for (int i = 0; i < lo.length; i++) {
            for (int j = 0; j < comLotto.length; j++) {
                if (lo[i] == comLotto[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[로또 당첨 프로그램]");
        System.out.print("로또 개수를 입력해 주세요.(숫자 1~10):");

        int lottoCount = sc.nextInt();
        char lottoNum = 'A';
        int[][] myLotto = new int[lottoCount][6];

        //컴퓨터가 생성한 로또 번호
        int[] comLotto = makeLotto();

        //입력 개수만큼 로또 생성
        for (int i = 0; i < lottoCount; i++) {
            myLotto[i] = makeLotto();
        }

        //내 로또번호 출력
        for (int[] lo : myLotto) {
            System.out.print(lottoNum++ + "\t");
            for (int i = 0; i < 6; i++) {
                System.out.printf("%02d ",lo[i]);
            }
            System.out.println();
        }

        //로또 당첨 번호 출력
        System.out.println("\n[로또 발표]");
        System.out.print("\t");
        for (int i = 0; i < comLotto.length; i++) {
            System.out.printf("%02d ",comLotto[i]);
        }

        //내 로또번호 출력 및 당첨 개수 출력
        System.out.println("\n\n[내 로또 결과]");
        lottoNum = 'A';
        for (int[] lo : myLotto) {
            System.out.print(lottoNum++ + "\t");
            for (int i = 0; i < 6; i++) {
                System.out.printf("%02d ",lo[i]);
            }
            System.out.print(" => " +getLottoCount(lo, comLotto)+"개 일치");
            System.out.println();
        }
    }
}
