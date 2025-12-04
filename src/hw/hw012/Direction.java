package hw.hw012;

public enum Direction {
    HUMANITARIAN,
    NATURAL,
    NATURAL_HUMANITARIAN;

    public static Direction fromString(String raw) {
        String normalized = raw.trim().toLowerCase();
        return switch (normalized) {
            case "humanitarian" -> HUMANITARIAN;
            case "natural" -> NATURAL;
            case "natural-humanitarian", "natural_humanitarian", "naturalhumanitarian" -> NATURAL_HUMANITARIAN;
            default -> throw new IllegalArgumentException("Unknown direction: " + raw);
        };
    }

    public boolean allows(TeacherProfile profile) {
        if (this == NATURAL_HUMANITARIAN) {
            return true;
        }
        if (profile == TeacherProfile.HUMANITARIAN) {
            return this == HUMANITARIAN;
        }
        return this == NATURAL;
    }
}

