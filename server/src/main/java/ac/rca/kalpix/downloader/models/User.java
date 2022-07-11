package ac.rca.kalpix.downloader.models;

import ac.rca.kalpix.downloader.models.enums.ERole;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String fullNames;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String nationalId;

    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private ERole role = ERole.ADMIN;
}
