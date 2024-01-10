package in.ashokit.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {

	private String courseName;
	private String enqStatus;
	private String mode;

}
