package techit.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import techit.model.User;

@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String userFirstName;
    @Column(nullable = false)
    private String userLastName;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    @Column
    private String department;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "progress", columnDefinition = "int default 0")
    private Progress currentProgress; // Current progress of the ticket
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "priority", columnDefinition = "int default 0")
    private Priority currentPriority; // Importance or level of urgency of the ticket
    @Column(nullable = false)
    private String subject;			// Subject of the ticket.
    @Column(nullable = false)
    private String details; 		// Text concerning the project.
    @Column(nullable = false)
    private Date startDate; 		// Project's starting date.

    @Column
    private Date endDate; 			// When the project was completed.
    @Column(nullable = false)
    private Date lastUpdated;		// Last date where changes were made to the ticket (edits, technician updates, etc.)

    @Column(nullable = false)
    private String ticketLocation; 	// Location where the project is.

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private User reqUser;

    @ManyToOne(targetEntity = Unit.class)
    @JoinColumn(name = "unitid", referencedColumnName = "id")
    private Unit units;

    @ManyToMany
    @JoinTable(name = "tech_ticket", joinColumns = @JoinColumn(name = "tech_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ticket_id", referencedColumnName = "id"))
    private List<User> technicians;

    @OneToMany(targetEntity = Update.class, mappedBy = "tickets", cascade = CascadeType.ALL)
    private List<Update> updates;

    public enum Progress {
        OPEN, INPROGRESS, ONHOLD, COMPLETED, CLOSED;
    };

    public enum Priority {
        NA, LOW, MEDIUM, HIGH;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // --------------- Getters and Setters below ---------------
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getTicketLocation() {
        return ticketLocation;
    }

    public void setTicketLocation(String ticketLocation) {
        this.ticketLocation = ticketLocation;
    }

    public User getReqUser() {
        return reqUser;
    }

    public Progress getCurrentProgress() {
        return currentProgress;
    }

    public void setCurrentProgress(Progress currentProgress) {
        this.currentProgress = currentProgress;
    }

    public Priority getCurrentPriority() {
        return currentPriority;
    }

    public void setCurrentPriority(Priority currentPriority) {
        this.currentPriority = currentPriority;
    }

    public List<Update> getUpdates() {
        return updates;
    }

    public void setUpdates(List<Update> updates) {
        this.updates = updates;
    }

    public void setReqUser(User reqUser) {
        this.reqUser = reqUser;
    }

    public Unit getUnits() {
        return units;
    }

    public void setUnits(Unit units) {
        this.units = units;
    }

}
