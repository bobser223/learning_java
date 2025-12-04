package hw.hw012;

public class ActionParser {

    public static StudentVisitor parse(String line) {
        String[] tokens = line.trim().split("\\s+");
        if (tokens.length < 2) {
            throw new IllegalArgumentException("Cannot parse action from line: " + line);
        }

        String action = tokens[0].toLowerCase();
        switch (action) {
            case "teach" -> {
                TeacherProfile profile = TeacherProfile.fromString(tokens[1]);
                int credits = (tokens.length >= 3) ? Integer.parseInt(tokens[2]) : 3;
                return new TeachVisitor(profile, credits);
            }
            case "obtain" -> {
                if (tokens.length < 3) {
                    throw new IllegalArgumentException("Missing amount in line: " + line);
                }
                int amount = Integer.parseInt(tokens[2]);
                return new MoneyIncomeVisitor(amount);
            }
            case "pay" -> {
                if (tokens.length < 3) {
                    throw new IllegalArgumentException("Missing payment amount in line: " + line);
                }
                int amount = Integer.parseInt(tokens[2]);
                return new PaymentVisitor(amount);
            }
            default -> throw new IllegalArgumentException("Unknown action: " + action);
        }
    }
}

