package models;

@Entity
@Table(name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Username cannot be null")
    @Size(min = 2, max = 35)
    private String userName;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public Admin(){}

    public Admin(Long id, String userName, String password){
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {return id;}
    public String getUserName() {return userName;}
    public String getpassword() {return password;}

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setpassword(String password) {
        this.password = password;
    }
}
