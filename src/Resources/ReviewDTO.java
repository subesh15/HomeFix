package Resources;

public class ReviewDTO {
    private int review_id;
    private int user_id;
    private double rating;
    private String comment;

    public ReviewDTO(int review_id, int user_id, double rating, String comment) {
        this.review_id = review_id;
        this.user_id = user_id;
        this.rating = rating;
        this.comment = comment;
    }

    public int getReview_id() {
        return this.review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
