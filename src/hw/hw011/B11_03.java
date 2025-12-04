package hw.hw011;

import java.io.*;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

public class B11_03 {

    public static void main(String[] args) {
        String url = "https://godinnik.com/time/" +
                URLEncoder.encode("київ", StandardCharsets.UTF_8) + '/';

        LocalTime localTime = LocalTime.now();
        int localSec = localTime.toSecondOfDay();

        String html = getHTML(url);
        int webSec = getOnlineTime(html);

        if (webSec == -1) {
            System.out.println("Can't get online time");
            return;
        }

        LocalTime webTime = LocalTime.ofSecondOfDay(webSec);

        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("Local time = " + localTime.format(tf));
        System.out.println("Web time   = " + webTime.format(tf));

        int diff = Math.abs(localSec - webSec);
        if (diff > 12 * 3600) {
            diff = 24 * 3600 - diff;
        }

        System.out.println("Diff = " + diff + " seconds");

        if (diff == 0) {
            System.out.println("Time is correct");
        } else {
            System.out.println("Time is wrong, bias = " + diff + " seconds");
        }
    }

    public static String getHTML(String url) {
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

    public static int getOnlineTime(String html) {
        Pattern p = Pattern.compile("<noscript>(\\d{2}:\\d{2}:\\d{2})</noscript>");
        Matcher m = p.matcher(html);

        if (!m.find()) {
            return -1;
        }

        String timeStr = m.group(1);

        String[] parts = timeStr.split(":");
        int h = Integer.parseInt(parts[0]);
        int m2 = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);

        return h * 3600 + m2 * 60 + s;
    }
}
