package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.binding.SearchCriteria;
import in.ashokit.entity.StudentEnq;
import in.ashokit.service.EnquiryService;

@Controller
public class EnquiryController {

	@Autowired
	private EnquiryService enqService;

	@GetMapping("/enquiry")
	public String enqPage(Model model) {
		model.addAttribute("enq", new StudentEnq());
		return "addEnqView";

	}

	@PostMapping
	public String addEnquiry(StudentEnq se, Model model) {
		boolean addEnq = enqService.addEnq(se);
		if (addEnq) {
			// succes msg
		} else {
			// error msg
		}
		return "addEnqView";

	}

	@GetMapping("/enquiries")
	public String viewEnquiries(Model model) {
		List<StudentEnq> enquiriesList = enqService.getEnquiries(null, null);
		model.addAttribute("enquiries", enquiriesList);
		return "displayEnqView";

	}

	@PostMapping("/filter-enquiries")
	public String filterEnquiries(SearchCriteria sc, Model model) {
		List<StudentEnq> enquiriesList = enqService.getEnquiries(null, null);
		model.addAttribute("enquiries", enquiriesList);
		return "displayEnqView";
	}
}
