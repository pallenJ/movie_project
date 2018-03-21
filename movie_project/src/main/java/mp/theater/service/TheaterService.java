package mp.theater.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mp.theater.bean.Theater;

@Service
public interface TheaterService {
	//영화관 등록 (지점 입장)
	String register(Theater theater);
	//영화관 조회 (지점 입장)
	Theater my(String managerid);
	//영화관 수정 (지점 입장)
	void edit(String id, String name, String region, String address,
			String tel, String manager);
	//영화관 삭제 (지점 입장)
	void delete(String theaterid, String sessionid, String managerpw);
	//영화관 목록 조회 (고객 입장)
	List<Theater> list();
	//영화관 상세 조회 (고객 입장)
	Theater detail(String theaterid);
}
