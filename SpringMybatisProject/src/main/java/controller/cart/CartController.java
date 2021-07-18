package controller.cart;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.CartOrderCommand;
import service.cart.CartAddService;
import service.cart.CartListService;
import service.cart.CartOrderService;
import service.cart.CartQtyDecreaseService;
import service.cart.PaymentActionService;

@Controller
@RequestMapping("cart")
public class CartController {
	@Autowired
	CartAddService cartAddService;
	@Autowired
	CartListService cartListService;
	@Autowired
	CartQtyDecreaseService cartQtyDecreaseService;
	@Autowired
	CartOrderService cartOrderService;
	@Autowired
	PaymentActionService paymentActionService;

	
	@RequestMapping("paymentConfirm")
	public String paymentConfirm(@ModelAttribute(value="purchaseNum")String purchaseNum,@ModelAttribute(value="purchaseTotPrice")String purchaseTotPrice) {
		return "cart/payment";
	}
	
	@RequestMapping("goodsPayment")
	public String goodsPayment(CartOrderCommand cartOrderCommand,HttpSession session) {
		String purchaseNum = paymentActionService.purchaseInsert(cartOrderCommand,session);
		return "redirect:paymentConfirm?purchaseNum="+purchaseNum + "&purchaseTotPrice="+cartOrderCommand.getPurchaseTotPrice();
	}
	
	
	@RequestMapping(value="goodsBuy" , method = RequestMethod.POST)
	public String goodsBuy(@RequestParam(value="prodCk")String [] prodNums , Model model,HttpSession session ) {
		cartOrderService.cartOrderList(prodNums,model,session);
		return "cart/cartOrderSheet";
	}
	
	
	@RequestMapping(value="cartQtyDecrease" ,method=RequestMethod.GET)
	public String cartQtyDecrease(@RequestParam(value="prodNum")String prodNum,@RequestParam(value="prodPrice")int prodPrice,HttpSession session) {
		cartQtyDecreaseService.QtyDecrease(prodNum,prodPrice,session);
		return "redirect:cartList";
	}
	
	
	@RequestMapping("cartList")
	public String cartListPrint(HttpSession session,Model model) {
		cartListService.cartList(session,model);
		return "cart/cartList";
	}
	
	@RequestMapping(value="cartAdd",method=RequestMethod.GET)
	public String cartQtyAdd(@RequestParam(value="cartQty") int cartQty, @RequestParam(value="prodNum") String prodNum,@RequestParam(value="prodPrice") int prodPrice, Model model, HttpSession session) {
		cartAddService.cartAdd(cartQty,prodNum,prodPrice,session,model);
		return "redirect:cartList";
	}
	@RequestMapping(value= "cartAdd", method = RequestMethod.POST)
	public String cartAdd(@RequestParam(value="cartQty") int cartQty, @RequestParam(value="prodNum") String prodNum,@RequestParam(value="prodPrice") int prodPrice, Model model, HttpSession session) {
		cartAddService.cartAdd(cartQty,prodNum,prodPrice,session,model);
		return "cart/cartAdd";
	}
	
}
