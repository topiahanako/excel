package cards;

import java.util.ArrayList;

public class CardField extends ArrayList<Card> {
        /*
        場のカードを管理するクラス
        勝敗の判定とターミナル出力を行う。

        Elements
        --------
        Card

        Fields
        ------
        result: String, "WIN" or "LOSE" or "DRAW"
            勝敗結果
        winCount: int
            勝利回数
        drawCount: int
            引き分け回数

        */

        private String result;
        private int winCount = 0;
        private int drawCount = 0;

        public String getResult() {
            return this.result;
        }

        private void setResult(String result) {
            this.result = result;
        }

        public int getWinCount() {
            return this.winCount;
        }

        private void setWinCount(int winCount) {
            this.winCount = winCount;
        }

        public int getDrawCount() {
            return this.drawCount;
        }

        private void setDrawCount(int drawCount) {
            this.drawCount = drawCount;
        }

        public String toString() {
            /*
            要素をカンマで結合する。

            Returns
            -------
            String

            */
            String s = "";
            for (int i = 0; i < this.size(); i++) {
                s += this.get(i) + ",";
            }
            return s;
        }

        public void calcResult(Card nextCard, String inputValue) {
            /*
            勝敗を判定し、フィールドを更新する。

            Arguments
            ---------
            nextCard: Card
                比較対象のCardインスタンス
            inputValue: String, "high" or  "low"
                入力値

            */
            int i = this.size() - 1;
            Card baseCard = this.get(i);
            String result;
            if (nextCard.equals(baseCard)) {
                result = "DRAW";
            } else {
                if (nextCard.greaterThan(baseCard)) {
                    if (inputValue.equals("high")) {
                        result = "WIN";
                    } else {
                        result = "LOSE";
                    }
                } else {
                    if (inputValue.equals("low")) {
                        result = "WIN";
                    } else {
                        result = "LOSE";
                    }
                }
            }
            this.setResult(result);
            switch (this.getResult()) {
                case "WIN":
                    this.setWinCount(this.getWinCount() + 1);
                    break;
                case "DRAW":
                    this.setDrawCount(this.getDrawCount() + 1);
                    break;
            }
        }

    }

}
