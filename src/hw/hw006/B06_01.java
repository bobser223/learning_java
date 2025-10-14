package hw.hw006;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class B06_01 {


    public static void main(String[] args) {
        String text = """
                Замовлення було оформлено 12.03.2022, але оплата надійшла лише 25.04.2022.\s
                Наступне внесення даних заплановано на __.__.____, після чого система автоматично оновить статус.\s
                Останнє оновлення профілю виконано 01.01.2023, але підтвердження користувач має внести до __.__.____.\s
                Документ створено 30.12.2021 і має бути повторно переглянутий __.__.____ для перевірки актуальності.
                
                """;

        System.out.println(replaceAllDatesToToday(text));
    }


    public static String replaceAllDatesToToday(String text){
        LocalDate currDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String today = currDate.format(formatter);

        text = text.replaceAll("\\d{2}\\.\\d{2}\\.\\d{4}", today);
        text = text.replaceAll("_{2}\\._{2}\\._{4}", today);
        return text;
    }
}
