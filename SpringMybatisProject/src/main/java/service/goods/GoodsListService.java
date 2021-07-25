package service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.GoodsDTO;
import Model.StartEndPageDTO;
import controller.PageAction;
import repository.GoodsRepository;

public class GoodsListService {
	@Autowired
	GoodsRepository goodsRepository;
	public void listPrint(Model model,Integer page) {
		
		
		GoodsDTO dto = new GoodsDTO();
		StartEndPageDTO sep = new StartEndPageDTO();
		int limit = 5;
		int limitPage =5;
		
		if(page!=null) {
		//
		Long startRow = ((long)page-1) *limit +1; //시작리스트
		Long endRow = startRow + limit -1;		//끝리스트
		
		sep.setStartRow(startRow);
		sep.setEndRow(endRow);
		
		dto.setStartEndPageDTO(sep);
		}
		
		List<GoodsDTO> list = goodsRepository.listPrint(dto);
		int count = goodsRepository.count();
		model.addAttribute("lists33",list);
		
		
		if(page != null) { //메인페이지 때문에 
			PageAction pageAction = new PageAction();
			pageAction.page(count, limit, page, limitPage, model, "goodsList");
		}	
	}
}
