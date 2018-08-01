package Text;

import org.apache.commons.text.similarity.FuzzyScore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class ParseText {
    public static void main(String[] args){
//        FuzzyScore fuzzyScore = new FuzzyScore(Locale.CHINESE);
//        String[] array = {"运单号","运单金额","运单量","运单总价","总价","运个啥","运个单单","瞎写运单"};
//        String query = "运单";
//        Integer queryScore = fuzzyScore.fuzzyScore(query, query);
//        ArrayList<String> arrayList = new ArrayList<>();
//        for (String s : array) {
//            Integer score = fuzzyScore.fuzzyScore(s,query);
//            System.out.println(score);
//            if (score>=queryScore){
//                arrayList.add(s);
//            }
//        }
//        System.out.println(arrayList.toString());

        FuzzyScore fuzzyScore = new FuzzyScore(Locale.ENGLISH);
        String[] array = {"abcde","aebc","ddabcc","abcdd"};
        String query = "e";
        Integer queryScore = fuzzyScore.fuzzyScore(query, query);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : array) {
            Integer score = fuzzyScore.fuzzyScore(s,query);
            System.out.println(score);
            if (score>=queryScore){
                arrayList.add(s);
            }
        }
        System.out.println(arrayList.toString());

//        FuzzyScore fuzzyScore = new FuzzyScore(Locale.ENGLISH);
//        System.out.println(fuzzyScore.fuzzyScore( "W","Workshop"));
//        System.out.println(fuzzyScore.fuzzyScore( "Wo","Workshop"));
//        System.out.println(fuzzyScore.fuzzyScore( "Wor","Workshop"));
//        System.out.println(fuzzyScore.fuzzyScore( "Woxrk","Workshop"));
//        System.out.println(fuzzyScore.fuzzyScore( "oWork","Workshop"));
//        System.out.println(fuzzyScore.fuzzyScore( "Workshop","Workshop"));
//        System.out.println(fuzzyScore.fuzzyScore( "Workshops","Workshopssss"));



    }
}
