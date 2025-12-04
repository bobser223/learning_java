package hw.hw011;

import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.zip.GZIPInputStream;

public class B11_06 {


    public static void main(String[] args) throws IOException, InterruptedException {
        getWeatherByCity();

    }

    public static void getWeatherByCity() {
//        String url = "https://ua.sinoptik.ua/погода-";
        Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
//
        System.out.print("Enter City Name in ukrainian: ");
        String city = in.next();
//
//        url = url + URLEncoder.encode(word, "UTF-8");
        String url = "https://ua.sinoptik.ua/" + URLEncoder.encode("погода-"+city, StandardCharsets.UTF_8);
        System.out.println(url);
        String page = getHTML(url);
        System.out.println(page);
        HTML2String(page);
//        System.out.println(getDecl(page));

        in.close();
    }


    public static String getHTML(String url){
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("User-Agent", "Java HttpClient")
                .header("Accept-Encoding", "identity")
                .build();

        try {
            HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

            System.out.println("Status: " + response.statusCode());
            Optional<String> encOpt = response.headers().firstValue("Content-Encoding");
            System.out.println("Encoding: " + encOpt);
            System.out.println("Content-Type: " + response.headers().firstValue("Content-Type"));

            byte[] bodyBytes = response.body();
            String encoding = encOpt.orElse("");

            if ("gzip".equalsIgnoreCase(encoding)) {
                try (GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(bodyBytes));
                     InputStreamReader isr = new InputStreamReader(gis, StandardCharsets.UTF_8);
                     BufferedReader br = new BufferedReader(isr)) {

                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    return sb.toString();
                }
            } else {
                return new String(bodyBytes, StandardCharsets.UTF_8);
            }
        } catch (InterruptedException | IOException e) {
            System.out.println(e);
        }
        return "";
    }

    public static void HTML2String(String html) {
        String scriptKey = "id=\"preloaded-state\">";
        int scriptIdx = html.indexOf(scriptKey);
        if (scriptIdx == -1) {
            System.out.println("didn't find preloaded-state :(");
            return;
        }

        int jsonStart = scriptIdx + scriptKey.length();
        int jsonEnd = html.indexOf("</script>", jsonStart);
        if (jsonEnd == -1) {
            System.out.println("didn't find end of preloaded-state :(");
            return;
        }

        String json = html.substring(jsonStart, jsonEnd).trim();

        String date = null;
        String forecastKey = "\"forecast\":[";
        int fIdx = json.indexOf(forecastKey);
        if (fIdx != -1) {
            String dateKey = "\"date\":\"";
            int dateIdx = json.indexOf(dateKey, fIdx);
            if (dateIdx != -1) {
                int start = dateIdx + dateKey.length();
                int end = json.indexOf("\"", start);
                if (end != -1) {
                    date = json.substring(start, end);
                }
            }
        }

        if (date == null) {
            System.out.println("didn't find date :(");
        }

        String hoursKey = "\"hours\":[";
        int hoursIdx = json.indexOf(hoursKey, fIdx);
        if (hoursIdx == -1) {
            System.out.println("didn't find hours :(");
            return;
        }

        List<Integer> temps = new ArrayList<>();
        String tempKey = "\"temperature\":";
        int searchFrom = hoursIdx + hoursKey.length();

        for (int i = 0; i < 8; i++) {
            int tIdx = json.indexOf(tempKey, searchFrom);
            if (tIdx == -1) break;

            int numStart = tIdx + tempKey.length();
            int numEnd = json.indexOf(",", numStart);
            if (numEnd == -1) break;

            String numStr = json.substring(numStart, numEnd).trim();
            try {
                temps.add(Integer.parseInt(numStr));
            } catch (NumberFormatException e) {
            }
            searchFrom = numEnd;
        }

        System.out.println("Date: " + date);
        System.out.println("First 8 temperatures: " + temps);
    }

}
