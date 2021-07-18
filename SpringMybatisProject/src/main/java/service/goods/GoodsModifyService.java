package service.goods;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import Model.GoodsDTO;
import command.GoodsCommand;
import repository.GoodsRepository;

public class GoodsModifyService {
	@Autowired
	GoodsRepository goodsRepository;
	public void modifyAction(GoodsCommand goodsCommand ,HttpSession session) {
		
		GoodsDTO dto = new GoodsDTO();
		dto.setProdNum(goodsCommand.getProdNum());
		dto.setCtgr(goodsCommand.getCtgr());
		dto.setProdPrice(goodsCommand.getProdPrice());
		dto.setProdCapacity(goodsCommand.getProdCapacity());
		dto.setProdSupplyer(goodsCommand.getProdSupplyer());
		dto.setProdDelFee(goodsCommand.getProdDelFee());
		dto.setProdDetail(goodsCommand.getProdDetail());
		dto.setRecommand(goodsCommand.getRecommand());
		dto.setProdName(goodsCommand.getProdName());
		
		
		
		
		
		//================================================= 파일 수정
		
		
		String [] fileNames = goodsCommand.getFileDel1().split(",");
		GoodsDTO dto1 = goodsRepository.goodsDetail(goodsCommand.getProdNum().toString()); //디비에 저장된 원래파일명가져오기
		dto.setProdImage(dto1.getProdImage()); //dto에 저장
		String realpath = session.getServletContext().getRealPath("WEB-INF/view/goods/upload");//경로
		String storeFile="";
		
		
		//===============
		//파일추가 
		if(!goodsCommand.getProdImage()[0].getOriginalFilename().equals("")) { //파일이 없지 않다면
			for(MultipartFile mf : goodsCommand.getProdImage()) {
				String original = mf.getOriginalFilename();
				String fileNameExt = original.substring(original.lastIndexOf(".")); //확장자명
				String store = UUID.randomUUID().toString().replace("-", "") + fileNameExt; //파일명 +확장자  (랜덤으로 파일명 받아오기)
				File file = new File(realpath + "/" + store);
				try {
					mf.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
					storeFile = storeFile + store + ",";
				}
			}
			//기존파일 삭제
			String goodsFileName = dto1.getProdImage(); //디비에서 커멘드에있는 파일명의 이미지를 지워라 
			if(!fileNames[0].equals("")) {
				//이미지 파일이 변경된 경우 수정된 내용으로 다시 저장 
				for(String s : fileNames) { //나눠놓은 걸 하난하나 불러와서 삭제
					String delfile = s+ ",";
					goodsFileName = goodsFileName.replace(delfile,"");
					File file = new File(realpath + "/" +s);
					if(file.exists()) {
						file.delete(); //파일삭제 
					}
					dto.setProdImage(goodsFileName);
				}
			}
		}
		dto.setProdImage(storeFile + dto.getProdImage());  //기존파일명 + 새로운 파일명 
	
		goodsRepository.goodsModify(dto);
		
	}
}
