//package labs.lab006;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//
//public class A06_04 {
//
//    public static void main(String[] args) throws Exception {
//        String days = "(?\\d|3[0-1]|[0-2][0-9]])";
//        String month = "(?\\d|1[0-2])";
//        String year = "\\d{4}";
//
//        String DATE1 ="(?<d1>" +  year + "/" + month + "/" + days+")";
//        String DATE2 = "(?<d1>" + month + "-"+year + "-" + days +")";
//        String DATE3 = "(?<d1>" + days + "\\." + month + "\\." + year +")";
//        String DATE = DATE1 + "|" + DATE2 + "|" + DATE3;
//
//        String s = Files.readString(Path.of("src/labs/lab006/06.txt"));
//
//        Pattern p = Pattern.compile(DATE);
//        Matcher m = p.matcher(s);
//
//        String res = m.replaceAll((match) ->replace((Matcher) match));
//        System.out.println(res);
//
//
//    }
//}
