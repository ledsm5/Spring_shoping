package service.cart;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfoDTO;
import Model.CartDTO;
import Model.PurchaseDTO;
import command.CartOrderCommand;
import repository.CartRepository;

public class PurchaseInsertService {
	@Autowired
	CartRepository cartRepository;
	public String purchaseInsert(CartOrderCommand cartOrderCommand,HttpSession session) {
		PurchaseDTO dto = new PurchaseDTO();
		dto.setPurchaseAddr(cartOrderCommand.getPurchaseAddr());
		dto.setPurchaseMethod(cartOrderCommand.getPurchaseMethod());
		dto.setPurchaseRequest(cartOrderCommand.getPurchaseRequest());
		dto.setPurchaseTotPrice(cartOrderCommand.getPurchaseTotPrice());
		dto.setReceiverName(cartOrderCommand.getReceiverName());
		dto.setReceiverPhone(cartOrderCommand.getReceiverPhone());
		
		//구매번호
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String purchaseNum = df.format(new Date());
		dto.setPurchaseNum(purchaseNum);
		
		
		AuthInfoDTO authInfo=(AuthInfoDTO)session.getAttribute("authInfo");
		dto.setMemId(authInfo.getUserId());
		cartRepository.purchaseInsert(dto);
		
		String [] prodNums = cartOrderCommand.getProdNums().split(",");
		for(String prodNum : prodNums) {
			CartDTO dto2 = new CartDTO();
			dto2.setPurchaseNum(purchaseNum);
			dto2.setMemId(authInfo.getUserId());
			dto2.setProdNum(prodNum);
			int i = cartRepository.purchaseListInsert(dto2);
			if(i == 1) {
				cartRepository.cartDelete(dto2);
			}
		}
		return purchaseNum;

	}
}
