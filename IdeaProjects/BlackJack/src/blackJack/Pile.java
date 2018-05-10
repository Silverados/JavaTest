package blackJack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pile {

        String[] points = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] suits = {"黑桃","红桃","梅花","方块"};
        String[] piles = new String[52];
        String[] temporatys = new String[53];
        List<String> pileList = new ArrayList<String>();

        public List<String> createNormalPiles(){

            for (int j = 1; j <= suits.length; j++) {
                for (int i = 1; i <= points.length; i++) {
                    temporatys[(j-1)*points.length+i] = suits[j-1] + points[i-1];
                }
            }
            piles = Arrays.copyOfRange(temporatys,1,53);
            pileList = Arrays.asList(piles);

            return pileList;
        }

        public List<String>  createRandomPiles(){
            List<String> randomPiles = this.createNormalPiles();
            Collections.shuffle(randomPiles);
            return  randomPiles;
        }



}
