package Resources;

public class PaymentDTO {
    private int pay_id;
    private String pay_type;
    private int amount;
    private int issue_id;

    public PaymentDTO(int pay_id, String pay_type, int amount, int issue_id) {
        this.pay_id = pay_id;
        this.pay_type = pay_type;
        this.amount = amount;
        this.issue_id = issue_id;
    }

    public int getPay_id() {
        return this.pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }

    public String getPay_type() {
        return this.pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIssue_id() {
        return this.issue_id;
    }

    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

}
