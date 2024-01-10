package in.ashokit.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponse {
	
	private Integer totalEnq;
	private Integer enrolledEnq;
	private Integer lostEnq;
	

}
