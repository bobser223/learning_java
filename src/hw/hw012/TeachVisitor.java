package hw.hw012;

public class TeachVisitor implements StudentVisitor {
    private final TeacherProfile profile;
    private final int credits;

    public TeachVisitor(TeacherProfile profile, int credits) {
        this.profile = profile;
        this.credits = credits;
    }

    @Override
    public void visit(Student student) {
        if (student.isExpelled()) {
            return;
        }
        if (student.getDirection().allows(profile)) {
            student.addCredits(credits);
        }
    }
}

