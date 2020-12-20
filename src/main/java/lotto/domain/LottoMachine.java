package lotto.domain;

import lotto.util.NumberUtil;

import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private LottoBucket lottoBucket;

    public LottoMachine(){
        lottoBucket = new LottoBucket();
    }
    public int buyLotto(String money) {
        long calcuratableMoney = NumberUtil.stringTolong(money);
        long numberOfLotto = calcuratableMoney / LOTTO_PRICE;
        int lottos = createLottos(numberOfLotto);
        return lottos;
    }

    protected int createLottos(long numberOfLotto) {
        for(int i = 0; i < numberOfLotto; i++){
            lottoBucket.createLotto();
        }
        return lottoBucket.checkNumberOfLottos();
    }

    public LottoBucket getLottoBuckets() {
        return this.lottoBucket;
    }

}