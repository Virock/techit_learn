package techit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;
    @Column(columnDefinition = "int default 1")
    private boolean enabled = true;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column
    private String department;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "position", columnDefinition = "int default 3")
    private Position position;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Unit.class)
    @JoinColumn(name = "unitid", referencedColumnName = "id")
    private Unit unit;

    @OneToMany(targetEntity = Ticket.class, mappedBy = "reqUser", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @OneToMany(targetEntity = Update.class, mappedBy = "modifier", cascade = CascadeType.ALL)
    private List<Update> updates;

    public enum Position {
        SYS_ADMIN, SUPERVISING_TECHNICIAN, TECHNICIAN, USER;
    };

    public List<Update> getUpdates() {
        return updates;
    }

    public void setUpdates(List<Update> updates) {
        this.updates = updates;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnits(Unit units) {
        this.unit = units;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
                + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
                + ", department=" + department + ", email=" + email + ", position=" + position + ", unit=" + unit
                + "]";
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

}
