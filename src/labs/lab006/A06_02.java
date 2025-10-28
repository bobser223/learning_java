package labs.lab006;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A06_02 {


    public static void main(String[] args) throws Exception{
        String s = Files.readString(Path.of("src/labs/lab006/06.txt"));

        String subrgx = "\\d";
        String rgx = "^(?<line>/*?(?<subregex>" + subrgx + ").*)$";

        Pattern p = Pattern.compile(rgx, Pattern.MULTILINE);
        Matcher m = p.matcher(s);

        while (m.find()){
            System.out.println(
                    m.group("line") + ": " + m.group("line")
            );
        }
    }
}
