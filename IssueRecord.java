import java.io.Serializable;
import java.time.LocalDate;

public class IssueRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private int recordId;
    private int bookId;
    private int memberId;
    private LocalDate issueDate;
    private LocalDate returnDate; // null if not returned

    public IssueRecord(int recordId, int bookId, int memberId, LocalDate issueDate) {
        this.recordId = recordId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.returnDate = null;
    }

    // Getters and setters
    public int getRecordId() { return recordId; }
    public int getBookId() { return bookId; }
    public int getMemberId() { return memberId; }
    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate d) { this.returnDate = d; }

    public boolean isReturned() { return returnDate != null; }

    @Override
    public String toString() {
        return String.format("IssueRecord[id=%d, bookId=%d, memberId=%d, issue=%s, return=%s]",
                recordId, bookId, memberId, issueDate.toString(), (returnDate==null?"not returned":returnDate.toString()));
    }
}
