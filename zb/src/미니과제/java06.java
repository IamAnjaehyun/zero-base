package 미니과제;

import java.util.Random;
import java.util.Scanner;

/*
    안재현
    가상 대선 당선 시뮬레이션 프로그램

    기호1번 이재명, 기호2번 윤석열, 기호3번 심상정, 기호4번 안철수 순으로 진행
    총 투표수 10,000 건 진행
    각 투표수의 결과는 4명의 대선주자들이 동일한 비율로 랜덤하게 발생(단, 당선자는 동율이 안됨)
    임의번호는 Random함수의 nextInt()함수를 통해서 생성
 */
public class java06 {
    public static void solution(String[] name, int[] vote){
        Random random = new Random();

        int max = 10000;
        int sum = 0;

        while (sum < 10000) {
            int a = random.nextInt(4);
            vote[a]++;
            sum++;
            System.out.printf("[투표 진행율] : %.2f%%, %d명 투표 => %s\n", (double) sum / max * 100, sum, name[a]);
            System.out.printf("[기호:1] 이재명: %.2f%%, (투표수: %d)\n", (double) vote[0] / max * 100, vote[0]);
            System.out.printf("[기호:2] 윤석열: %.2f%%, (투표수: %d)\n", (double) vote[1] / max * 100, vote[1]);
            System.out.printf("[기호:3] 심상정: %.2f%%, (투표수: %d)\n", (double) vote[2] / max * 100, vote[2]);
            System.out.printf("[기호:4] 안철수: %.2f%%, (투표수: %d)\n", (double) vote[3] / max * 100, vote[3]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[] name = {"이재명", "윤석열", "심상정", "안철수"};
        int[] vote = {0, 0, 0, 0};

        solution(name,vote);

        int maxVote = Integer.MIN_VALUE;
        String winner = "";
        for (int i = 0; i < vote.length; i++) {
            if (maxVote < vote[i]) {
                maxVote = vote[i];
                winner = name[i];
            } else if (maxVote == vote[i]) {
                System.out.println("==당선자 동율 발생==");
                solution(name,vote);
            }
        }
        System.out.println("[투표결과] 당선인: " + winner);
    }
}
