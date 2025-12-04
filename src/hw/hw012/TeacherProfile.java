package hw.hw012;

public enum TeacherProfile {
    HUMANITARIAN,
    NATURAL;

    public static TeacherProfile fromString(String raw) {
        String normalized = raw.trim().toLowerCase();
        return switch (normalized) {
            case "humanitarian" -> HUMANITARIAN;
            case "natural" -> NATURAL;
            default -> throw new IllegalArgumentException("Unknown teacher profile: " + raw);
        };
    }
}

