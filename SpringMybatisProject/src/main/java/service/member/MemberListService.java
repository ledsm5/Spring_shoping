package service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.MemberDTO;
import Model.StartEndPageDTO;
import controller.PageAction;
import repository.MemberRepository;

public class MemberListService {
	@Autowired
	MemberRepository memberRepository;
	public void memList(Model model, String memId,Integer page) {
		int limit = 5;
		int limitPage =5;
		Long startRow = ((long)page-1) *limit +1; //시작리스트
		Long endRow = startRow + limit -1;		//끝리스트
		StartEndPageDTO sep = new StartEndPageDTO();
		sep.setStartRow(startRow);
		sep.setEndRow(endRow);
		
		MemberDTO dto = new MemberDTO();
		dto.setStartEndPageDTO(sep);
		dto.setMemId(memId);
		
		
		List<MemberDTO> list = memberRepository.memList(dto);
		Integer count = memberRepository.listCount();//리스트의 총갯수를 가져와야한다 
		model.addAttribute("lists",list);
		model.addAttribute("count",count); //몇개인지 보여주기위해
		
		
		/*
		 * //총페이지수 int maxPage=(int)((double)count / limit + 0.99); int startPage =
		 * (int)((double)page / limit + 0.99); //시작페이지수 int endPage = startPage +
		 * limitPage -1; //끝페이지수 if(endPage > maxPage)endPage = maxPage;
		 * model.addAttribute("maxPage", maxPage);
		 * model.addAttribute("startPage",startPage);
		 * model.addAttribute("endPage",endPage);
			model.addAttribute("page",page);
		  모듈화를 해서 만들어준다 */
		PageAction pageAction = new PageAction();
		pageAction.page(count,limit,page,limitPage,model,"memList");//마지막 pageUrl
	}
}
