package service.cart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.CartDTO;
import Model.GoodsCartDTO;
import repository.CartRepository;

public class CartListService {
	
	@Autowired
	CartRepository cartRepository;
	
	public void cartList(HttpSession session,Model model) {
		
		AuthInfoDTO authInfo =(AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		//DTO 에있는 멤버가 1대1 관계인경우 mybatis는 list로 값을 받아오지 못한다.
		List<String> prodNums = cartRepository.memProdNum(memId);
		List<GoodsCartDTO> list = new ArrayList<GoodsCartDTO>();
		for(String prodNum : prodNums) {
			CartDTO dto = new CartDTO();
			dto.setMemId(memId);
			dto.setProdNum(prodNum);
			GoodsCartDTO goodsCartDTO = cartRepository.cartList(dto);
			list.add(goodsCartDTO);
		}
		model.addAttribute("lists",list);
	}
}
