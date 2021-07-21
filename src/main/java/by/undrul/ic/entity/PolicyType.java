package by.undrul.ic.entity;

import javax.persistence.*;

@Entity
@Table(name = "policy_types")
public class PolicyType {
    @Id
    @Column(name = "policy_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    public PolicyType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
