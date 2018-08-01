package Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternRegex {
    public static void main(String[] args) {
        String regex = "((\\d)\\d)\\2\\2";
        String line = "121121";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        System.out.println(m.groupCount());

        while (m.find()) {
            System.out.println(m.group());
            for (int i = 0; i <= m.groupCount(); i++) {
                System.out.println("group"+i +": "+ m.group(i)+" ");
            }
        }

//
//        String input =
//                "Today's specials are apple chocolate pie and cherry banana pie." ;
//
//        Pattern pattern = Pattern.compile( "(apple|cherry)(?= chocolate)" );
//        // Matches "apple" or "cherry" where the following pattern
//        // matches " chocolate".  " chocolate" is not a part of the
//        // resulting match, it follows it.
//
//        Matcher matcher = pattern.matcher( input );
//
//        System.out.println( matcher.find() );       // Prints true.
//        System.out.println( matcher.groupCount() ); // Prints 1.
//        System.out.println( matcher.group( 1 ) );   // Prints "apple".
//        System.out.println( matcher.group() );      // Prints "apple".
//
//        pattern = Pattern.compile( "(apple|cherry)(?! chocolate)" );
//        // Matches "apple" or "cherry" where the following pattern
//        // does not match " chocolate".
//
//        matcher = pattern.matcher( input );
//
//        System.out.println( matcher.find() );       // Prints true.
//        System.out.println( matcher.groupCount() ); // Prints 1.
//        System.out.println( matcher.group( 1 ) );   // Prints "cherry".
//        System.out.println( matcher.group() );      // Prints "cherry".
//
//
//        input =
//                "Tomorrow's special is fried bananas with baked clam." ;
//
//        pattern = Pattern.compile( "(?<=fried )(bananas|clam)" );
//        // Matches "bananas" or "clam" if preceded by "fried ".
//        // "fried " is not part of the resulting match, it precedes it.
//
//        matcher = pattern.matcher( input );
//
//        System.out.println( matcher.find() );       // Prints true.
//        System.out.println( matcher.groupCount() ); // Prints 1.
//        System.out.println( matcher.group( 1 ) );   // Prints "bananas".
//        System.out.println( matcher.group() );      // Prints "bananas".
//
//        pattern = Pattern.compile( "(?<!fried )(bananas|clam)" );
//        // Matches "bananas" or "clam" if not preceded by "fried ".
//
//        matcher = pattern.matcher( input );
//
//        System.out.println( matcher.find() );       // Prints true.
//        System.out.println( matcher.groupCount() ); // Prints 1.
//        System.out.println( matcher.group( 1 ) );   // Prints "clam".
//        System.out.println( matcher.group() );      // Prints "clam".
//
//
//        input =
//                "Humpty Dumpty sat on a wall. " +
//                        "Humpty Dumpty had a great fall. " +
//                        "All the king's horses and all the king's men " +
//                        "Couldn't put Humpty together again! " ;
//
//        pattern = Pattern.compile( "((H|D)(umpty) ){2}" );
//        // Matches six characters ending in "umpty" and
//        // beginning with "H" or "D".  Three capturing
//        // groups are defined and remembered by the Matcher.
//
//        matcher = pattern.matcher( input );
//
//        System.out.println( matcher.find() );       // Prints true.
//        System.out.println( matcher.groupCount() ); // Prints 3.
//        System.out.println( matcher.group( 1 ) );   // Prints "Dumpty ".
//        System.out.println( matcher.group( 2 ) );   // Prints "D".
//        System.out.println( matcher.group( 3 ) );   // Prints "umpty".
//        System.out.println( matcher.group( 0 ) );   // Prints "Humpty Dumpty "
//
//        pattern = Pattern.compile( "((?:H|D)(?:umpty) ){2}" );
//        // Matches six characters ending in "umpty" and
//        // beginning with "H" or "D".  Three groups
//        // are defined, one is a capturing group that
//        // will be remembered by the Matcher.
//
//        matcher = pattern.matcher( input );
//
//        System.out.println( matcher.find() );       // Prints true.
//        System.out.println( matcher.groupCount() ); // Prints 1.
//        System.out.println( matcher.group( 1 ) );   // Prints "Dumpty ".
//        System.out.println( matcher.group( 0 ) );   // Prints "Humpty Dumpty ".
    }
}