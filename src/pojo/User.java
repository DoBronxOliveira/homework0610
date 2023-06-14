package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tan
 * @date 2023/6/10 17:02
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String admin;
    private int deptId;
    private int jobId;

    public User(String username, String password, String admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public User(String username, String password, String admin, int deptId, int jobId) {
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.deptId = deptId;
        this.jobId = jobId;
    }
}
