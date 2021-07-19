package service.cart;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.PurchaseListDTO;
import repository.CartRepository;

public class PurchaseListPrintService {
	@Autowired
	CartRepository cartRepository;
	
	
	public void ListPrint(HttpSession session,Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		List<PurchaseListDTO> list = cartRepository.purchaseList(memId);
		model.addAttribute("list",list);
	}
}
