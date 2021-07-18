package service.goods;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import Model.AuthInfoDTO;
import Model.GoodsDTO;
import command.GoodsCommand;
import repository.GoodsRepository;

public class GoodsRegistService {
	
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsRegist(GoodsCommand goodsCommand,HttpSession session) {
		GoodsDTO dto = new GoodsDTO();
		dto.setCtgr(goodsCommand.getCtgr());
		dto.setProdNum(goodsCommand.getProdNum());
		dto.setProdCapacity(goodsCommand.getProdCapacity());
		dto.setProdDelFee(goodsCommand.getProdDelFee());
		dto.setProdDetail(goodsCommand.getProdDetail());
		dto.setProdName(goodsCommand.getProdName());
		dto.setProdPrice(goodsCommand.getProdPrice());
		dto.setProdSupplyer(goodsCommand.getProdSupplyer());
		dto.setRecommand(goodsCommand.getRecommand());
		
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String employeeId =authInfo.getGrade();
		dto.setEmployeeId(employeeId);
		
		
		
		
		String prodImage = "";
		if (!goodsCommand.getProdImage()[0].getOriginalFilename().equals("")) {
			for (MultipartFile mf : goodsCommand.getProdImage()) {
				// 확장자를 알리기위해
				String original = mf.getOriginalFilename();
				// original에서 확장자만 추ㅜ출
				String originalExt = original.substring(original.lastIndexOf("."));
				String store = UUID.randomUUID().toString().replace("-", "") + originalExt; // 랜덤아이디(같은아이디일때 에러가발생하기
																							// 때문에) 지정
				// 디비에 저장할 파일명을 추출하여 prodImage에 저장
				prodImage += store + ",";
				// 파일을 시스템에 저장
				String realpath = session.getServletContext().getRealPath("WEB-INF/view/goods/upload");
				File file = new File(realpath + "/" + store);
				try {
					mf.transferTo(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// ================================================================파일등록 코드
			dto.setProdImage(prodImage);
		}
		goodsRepository.goodsRegist(dto);
		
	}
}
