package techit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "updates")
public class Update implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = Ticket.class)
    @JoinColumn(name = "ticketid", referencedColumnName = "id")
    private Ticket tickets;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "modifier", referencedColumnName = "id")
    private User modifier;

    @Column
    private String updateDetails;
    @Column(nullable = false)
    private String modifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ticket getTickets() {
        return tickets;
    }

    public void setTickets(Ticket tickets) {
        this.tickets = tickets;
    }

    public User getModifier() {
        return modifier;
    }

    public void setModifier(User modifier) {
        this.modifier = modifier;
    }

    public String getUpdateDetails() {
        return updateDetails;
    }

    public void setDetails(String details) {
        this.updateDetails = details;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
