package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.DashboardResponse;
import in.ashokit.entity.Counsellor;
import in.ashokit.repo.CounsellorRepo;

@Service
public class CounsellorServiceImpl implements CounsellerService {

	@Autowired
	private CounsellorRepo crepo;

	@Override
	public String saveConsellor(Counsellor c) {

		Counsellor obj = crepo.findByEmail(c.getEmail());

		if (obj != null) {
			return "Duplicate Email";
		}

		Counsellor savedObj = crepo.save(c);
		if (savedObj.getCid() != null) {
			return "Registration Success";
		}
		return "Registration Failed";
	}

	@Override
	public Counsellor loginCheck(String email, String pwd) {
		return crepo.findByEmailAndPwd(email, pwd);

	}

	@Override
	public boolean recoverPwd(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DashboardResponse getDashboardInfo(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

}
