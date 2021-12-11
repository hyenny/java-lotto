package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;

public abstract class ResultView {

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printLottos(Lottos lottos) {
        int purchasedLotto = lottos.numberOfLotto();
        System.out.printf("%d개를 구매했습니다.\n", purchasedLotto);
        for (Lotto lotto : lottos.lottos()) {
            System.out.println(lotto.toString());
        }
        ResultView.println("");
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()) {
            System.out.printf("%d개 일치 (%d원) - %d개\n", rank.matchedCount(), rank.winningAmount(), lottoResult.numberOfLotto(rank.matchedCount()));
        }
    }

    public static void printProfitRate(LottoResult lottoResult) {
        double profitRate = lottoResult.profitRate();
        System.out.printf("총 수익률은 %.2f입니다.", profitRate);
        if (profitRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

}
