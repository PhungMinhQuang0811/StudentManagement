package vn.pmq.spring.studentmanagement.Model;

public class Feedback {
    private int feedbackId;
    private int courseId;
    private int staffId;
    private float rate;
    private String comment;

    public Feedback() {
    }

    public Feedback(int feedbackId, int courseId, int staffId, float rate, String comment) {
        this.feedbackId = feedbackId;
        this.courseId = courseId;
        this.staffId = staffId;
        this.rate = rate;
        this.comment = comment;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
