package service.cart;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.PaymentDTO;
import command.PaymentCommand;
import repository.CartRepository;

public class PaymentActionService {
	@Autowired
	CartRepository cartRepository;
	public void paymentRegist(PaymentCommand paymentCommand,HttpSession session,Model model) {
		PaymentDTO dto = new PaymentDTO();
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		dto.setMemId(authInfo.getUserId());
		dto.setPaymentNumber(paymentCommand.getPurchaseNum());
		dto.setPaymentApprPrice(paymentCommand.getPaymentApprPrice());
		dto.setPurchaseNum(paymentCommand.getPurchaseNum());
		dto.setPaymentMethod("카드");
		cartRepository.paymentRegist(dto);
		model.addAttribute("payment",paymentCommand.getPaymentApprPrice());
	}
}
