package AcademiaDev;

public class Course {
    private String title;
    private String description;
    private String instructorName;
    private int durationInHours;
    private DifficultyLevel difficultyLevel;
    private CourseStatus status;

    // getters
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getInstructorName() {
        return instructorName;
    }
    public int getDurationInHours() {
        return durationInHours;
    }
    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }
    public CourseStatus getStatus() {
        return status;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }
    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public Course(String title, String description, String instructorName, int durationInHours,
                 DifficultyLevel difficultyLevel, CourseStatus status) {
        this.title = title;
        this.description = description;
        this.instructorName = instructorName;
        this.durationInHours = durationInHours;
        this.difficultyLevel = difficultyLevel;
        this.status = status;
    }
}
