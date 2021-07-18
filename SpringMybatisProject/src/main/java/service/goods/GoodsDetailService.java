package service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import Model.GoodsDTO;
import repository.GoodsRepository;

public class GoodsDetailService {
	
	@Autowired
	GoodsRepository goodsRepository;
	
	public void detailPrint(@RequestParam(value="prodNum")String prodNum,Model model) {
		GoodsDTO dto = goodsRepository.goodsDetail(prodNum);
		model.addAttribute("goodsCommand" ,dto);
	}
}
