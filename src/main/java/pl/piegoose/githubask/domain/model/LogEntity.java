package pl.piegoose.githubask.domain.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "repo")
public class LogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    public String owner;
    @Column(nullable = false)
    public String name;

    public LogEntity() {
        this.name = name;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "LogEntity{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

