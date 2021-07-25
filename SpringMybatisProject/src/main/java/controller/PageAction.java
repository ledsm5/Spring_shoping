package controller;

import org.springframework.ui.Model;

public class PageAction {//모듈화
	public void page(int count, int limit, int page, int limitPage, Model model, String pageUrl) {
		
		//한페이지에 몇개 씩 넣을것인가
		int maxPage = (int)((double)count/ limit + 0.99); 
		// 한페이지에  5개씩 넣을때 3개의게시글일때 3/5 = 0.6 +0.99 = 1.59 맥스 페이지 1개
		
		int startPage = (int)((double)page / limitPage + 0.99);
		// 5개페이지씩 보여줄때 3개페이지 있으면  3/5 = 0.6 +0.99 = 1.59 1개 
		// 5개 씩 6개일때   6/5 =1.2 +0.99 = 2.19 => 시작페이지 2
		int endPage = startPage + limitPage -1;
		if(endPage > maxPage) endPage = maxPage;
		
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("page",page);
		model.addAttribute("pageUrl",pageUrl); // 모든주소에서 해야되니까 어디페이지에서할건지 
		
	}
}
