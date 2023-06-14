package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tan
 * @date 2023/6/12 13:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private int jobId;
    private String jobName;
}
