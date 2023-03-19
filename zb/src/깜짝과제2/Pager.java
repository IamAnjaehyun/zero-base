package 깜짝과제2;
/*
  안재현
  깜짝과제 3번

  페이지네비게이션의 html 코드를 출력하는 페이지네비게이션을 구현해보세요.
*/
public class Pager {
    private final long totalCount;
    private final long pageSize = 10;
    private long pageIndex;

    public Pager(long totalCount) {
        this.totalCount = totalCount;
    }

    public String html(long pageIndex) {
        this.pageIndex = pageIndex;
        StringBuilder sb = new StringBuilder();
        sb.append("<a href='#'>[처음]</a>\n");
        sb.append("<a href='#'>[이전]</a>\n\n");

        int start = pageIndex <= 10 ? 1 : (int) (pageIndex / 10) * 10 + 1;
        int last = start > ((totalCount / pageSize) + 1) - 9 ? (int) ((totalCount / pageSize) + 1) : start + 9;

        if (totalCount % 10 == 0) last--; //10으로 나눠서 0으로 나누어 떨어질 때 빈 페이지가 하나 생겨 삭제

        for (int i = start; i <= last; i++) {
            if (pageIndex == i) {
                sb.append("<a href='#' class='on'>").append(i).append("</a>\n");
            } else {
                sb.append("<a href='#'>").append(i).append("</a>\n");
            }
        }

        sb.append("\n<a href='#'>[다음]</a>\n");
        sb.append("<a href='#'>[마지막]</a>\n");

        return sb.toString();
    }

    public static void main(String[] args) {
        long totalCount = 127;
        long pageIndex = 12;

        Pager pager = new Pager(totalCount);
        System.out.println(pager.html(pageIndex));
    }
}
