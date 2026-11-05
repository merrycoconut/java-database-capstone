package models;

@Entity
@Table(name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Username cannot be null")
    @Size(min = 2, max = 35)
    private String username;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public Admin(){}

    public Admin(Long id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {return id;}
    public String getUsername() {return username;}
    public String getpassword() {return password;}

    public void setUsername(String username) {
        this.username = username;
    }

    public void setpassword(String password) {
        this.password = password;
    }
}
