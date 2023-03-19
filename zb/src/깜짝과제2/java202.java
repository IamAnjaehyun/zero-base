package 깜짝과제2;

import java.util.Scanner;
    /*
    안재현
    깜짝과제 2번

    다음 조건에 맞는 프로그램을 작성해 보세요.
      - 나의 좌표 값을 입력 받습니다. (입력은 순서대로 x값, y값을 받습니다.)
      - 이후, 임의의 좌표 값을 입력 받습니다.(역시, x값, y값을 입력 받습니다.)
      - 임의로 입력된 좌표 값 중 동일한 좌표 값을 입력하는 경우는 저장하지 않고 다시 입력하도록 합니다.
      - 입력 받은 값이 10개가 되는 경우,
      입력 받은 좌표 값과 나의 좌표 값의 거리 중 가장 가까운 좌표 값을 화면에 출력하는 프로그램을 작성해 보세요.
    */
public class java202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("내 좌표 x값을 입력해 주세요. ");
        int x = sc.nextInt();
        System.out.println("내 좌표 y값을 입력해 주세요. ");
        int y = sc.nextInt();

        int max = 10;
        int[][] yourXY = new int[max][2]; //비교 좌표
        double[] dist = new double[max]; //거리
        for (int i = 0; i < max; i++) {
            System.out.println(i + 1 + "/" + max + "번째 입력");
            System.out.println("임의의 좌표 x값을 입력해 주세요. ");
            int yourX = sc.nextInt();
            System.out.println("임의의 좌표 y값을 입력해 주세요. ");
            int yourY = sc.nextInt();

            for (int j = 0; j < i; j++) {
                if (yourX == yourXY[j][0] && yourY == yourXY[j][1]) {
                    System.out.println("동일한 좌표값이 이미 존재합니다. 다시 입력해 주세요.");
                    --i;
                }
            }
            yourXY[i][0] = yourX;
            yourXY[i][1] = yourY;

            //거리
            dist[i] = Math.sqrt(Math.pow(yourXY[i][0] - x, 2) + Math.pow(yourXY[i][1] - y, 2));
        }

        double minDist = Integer.MAX_VALUE;
        int minIdx = Integer.MIN_VALUE;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] < minDist) {
                minDist = dist[i];
                minIdx = i;
            }
        }
        for (int i = 0; i < max; i++) {
            System.out.printf("(%d,%d) => %.6f\n", yourXY[i][0], yourXY[i][1], dist[i]);
        }


        System.out.println("제일 가까운 좌표:");
        System.out.printf("(%d,%d) => %.6f", yourXY[minIdx][0], yourXY[minIdx][1], dist[minIdx]);
    }
}

