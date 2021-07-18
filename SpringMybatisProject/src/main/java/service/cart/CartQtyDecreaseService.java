package service.cart;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfoDTO;
import Model.CartDTO;
import repository.CartRepository;

public class CartQtyDecreaseService {
	@Autowired
	CartRepository cartRepository;
	
	public void QtyDecrease(String prodNum ,int prodPrice , HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		CartDTO dto = new CartDTO();
		dto.setProdNum(prodNum);
		dto.setCartPrice(prodPrice);
		dto.setMemId(authInfo.getUserId());
		cartRepository.QtyDecrease(dto);
	}
}
