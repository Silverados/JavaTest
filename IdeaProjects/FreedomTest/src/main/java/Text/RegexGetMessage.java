package Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexGetMessage {
    public static void main(String[] args){
        String uri = "http://dl.stream.qqmusic.qq.com/C400002BJAv411rZ36.m4a?vkey=B5BB423C5E415BEDA3DFC5C38837CA4E8D874F0029E2B0741B78927BD51DE16BE6C3720899AB94FF707A6FBE44520BAE8352CB8290103C02&guid=621891097&uin=0&fromtag=66";
        Pattern pattern = Pattern.compile("(?<=/)C.*(?=\\?)");
        Matcher matcher = pattern.matcher(uri);
        matcher.find();
        String asFileName = matcher.group();
        System.out.println(matcher.group());
    }
}
