package service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.GoodsDTO;
import repository.GoodsRepository;

public class GoodsListService {
	@Autowired
	GoodsRepository goodsRepository;
	public void listPrint(Model model) {
		List<GoodsDTO> list = goodsRepository.listPrint();
		model.addAttribute("lists33",list);
		
	}
}
