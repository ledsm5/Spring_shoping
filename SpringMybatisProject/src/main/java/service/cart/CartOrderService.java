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

public class CartOrderService {
	@Autowired
	CartRepository cartRepository;
	public void cartOrderList(String [] prodNums,Model model, HttpSession session) {
		AuthInfoDTO authInfo =(AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		//DTO 에있는 멤버가 1대1 관계인경우 mybatis는 list로 값을 받아오지 못한다.
		List<GoodsCartDTO> list = new ArrayList<GoodsCartDTO>();
		
		
		for(String prodNum : prodNums) {
			/// cart리스트에서 사용했던 정보를 구매페이지에서도 사용하면되어서
			/// cart리스트에서 사용했던 코드를 그대로 적용
			CartDTO dto = new CartDTO();
			dto.setMemId(memId);
			dto.setProdNum(prodNum);
			GoodsCartDTO goodsCartDTO = cartRepository.cartList(dto);
			list.add(goodsCartDTO);
		}
		model.addAttribute("lists",list);
		
	}
}
