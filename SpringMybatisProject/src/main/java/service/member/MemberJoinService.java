package service.member;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Model.MemberDTO;
import command.MemberCommand;
import controller.MailService;
import repository.MemberRepository;

public class MemberJoinService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	MailService mailService;
	public void memJoin(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setDetailAdd(memberCommand.getDetailAdd());
		dto.setMemAccount(memberCommand.getMemAccount());
		dto.setMemAddress(memberCommand.getMemAddress());
		dto.setMemBirth(memberCommand.getMemBirth());
		dto.setMemEmail(memberCommand.getMemEmail());
		dto.setMemEmailCk(memberCommand.getMemEmailCk());
		dto.setMemGender(memberCommand.getMemGender());
		dto.setMemId(memberCommand.getMemId());
		dto.setMemName(memberCommand.getMemName());
		dto.setMemPhone(memberCommand.getMemPhone());
		dto.setMemPw(bcryptPasswordEncoder.encode(memberCommand.getMemPw()));
		dto.setPostNumber(memberCommand.getPostNumber());
		memberRepository.memInsert(dto);
		
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMddHHmmss");
		String num = dateForm.format(new Date());
		String subject = "가입환영인사";
		String content = "<html><body>" + "안녕하세요." + dto.getMemId() + "님의 가입을 축하드립니다 <br> "
				+ "아래 링크를 눌러서 가입을 확인해 주세요. "
				+ "<a href='http://192.168.4.198:8005/SpringMybatisProject/Register/memberMail?num="+ num + ""
				+ "&receiver="+dto.getMemEmail()+"'>가입확인</a> "
				+ "</body></html>";
		try {
			mailService.sendMail(dto.getMemEmail(),content, subject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
