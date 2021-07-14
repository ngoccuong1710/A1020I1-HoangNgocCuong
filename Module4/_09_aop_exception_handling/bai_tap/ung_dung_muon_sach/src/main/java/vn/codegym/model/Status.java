package vn.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String status;

    @OneToMany(mappedBy = "status")
    private Set<Code> codeAvailableSet;

    public Status() {
    }

    public Status(int id) {
        this.id = id;
    }

    public Status(int id, @NotBlank String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Code> getCodeAvailableSet() {
        return codeAvailableSet;
    }

    public void setCodeAvailableSet(Set<Code> codeAvailableSet) {
        this.codeAvailableSet = codeAvailableSet;
    }
}
