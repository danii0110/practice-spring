package jpabasic.ex1hellojpa;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id //pk로 매핑(기본키 매핑)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;


    //JPA는 기본 생성자가 있어야 됨
    public Member() {}

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
}
