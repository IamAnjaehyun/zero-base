package 깜짝과제;

import java.util.Scanner;
/*
    안재현
    깜짝과제-1

    숫자만 입력하고 그 외 입력은 하지 않는 것을 전제로 한다.
    입력은 Scanner 클래스의 nextInt 함수를 이용한다.
 */
public class java01 {
    public static void displayMenu() {
        String[] menuList = {"<<<<[메뉴선택]>>>>", "1. 회원 관리", "2. 과목 관리", "3. 수강 관리", "4. 결제 관리", "5. 종료"};

        for (int i = 0; i < menuList.length; i++) {
            System.out.println(menuList[i]);
        }
    }

    public static void selectMenu(int inputMenu){
        switch (inputMenu){
            case 1:
                System.out.println("회원 관리 메뉴를 선택했습니다.");
                break;
            case 2:
                System.out.println("과목 관리 메뉴를 선택했습니다.");
                break;
            case 3:
                System.out.println("수강 관리 메뉴를 선택했습니다.");
                break;
            case 4:
                System.out.println("결제 관리 메뉴를 선택했습니다.");
                break;
            case 5:
                System.out.println("프로그램을 종료합니다.");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputMenu = 0;

        do {
            displayMenu();
            inputMenu = sc.nextInt();
            selectMenu(inputMenu);
        } while (inputMenu != 5);

    }
}
