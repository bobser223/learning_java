package labs.lab011;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebClient {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String site = "https://slovnyk.ua";
        String word = input.next();
        String url = site + "/?swrd=" + URLEncoder.encode(word, StandardCharsets.UTF_8);

//        System.out.println(url);
        String html = getHTML(url);
        String result = parse(html);
        System.out.println(result);
        input.close();
    }

    public static String parse(String html){
        Pattern p = Pattern.compile(
                "<div class=\"toggle-content\".*?>(.*?)</div>",
                Pattern.DOTALL
        );

        Matcher m = p.matcher(html);
        if (m.find()){
            return m.group(1).trim().replaceAll("<.*?>", "");
        }
        return "";
    }


    public static String getHTML(String url){
        URI uri = URI.create(url);

        try(HttpClient client = HttpClient.newHttpClient()){
            HttpRequest request = HttpRequest.newBuilder(uri)
                    .GET()
                    .header("user-agent", "Hello!") //без цього деякі сайти абортять
                    .build();
            HttpResponse<String> response = client.send(
                    request,HttpResponse.BodyHandlers.ofString()
            );

//            System.out.println(response.statusCode());
//            System.out.println(response.headers());
//            System.out.println(response.body());
            return response.body();
        } catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }

    }

}


