package service.library;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import Model.AuthInfoDTO;
import Model.LibraryDTO;
import command.LibraryCommand;
import repository.LibraryRepository;

public class LibraryService {
@Autowired
LibraryRepository libraryRepository;


	public void libRegist(LibraryCommand libraryCommand,HttpSession session) {
		LibraryDTO dto = new LibraryDTO();
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		dto.setEmployeeId(authInfo.getGrade());
		dto.setNoticeCon(libraryCommand.getNoticeCon());
		dto.setNoticeKind("자료실");
		dto.setNoticeSub(libraryCommand.getNoticeSub());
		
		//파일업로드
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal ="";
		if(libraryCommand.getNoticeFile()[0].getOriginalFilename()!= "") {
			for(MultipartFile mf : libraryCommand.getNoticeFile()) {
				String original = mf.getOriginalFilename(); //파일의 원래이름
				
				String originalExt = original.substring(original.lastIndexOf("."));
				String store = UUID.randomUUID().toString().replace("-", "") + originalExt;
				String fileSize =Long.toString(mf.getSize()); //Long을 String 으로
				//상품때는 사진이기때문에 원래 파일이름을 알필요가없었다  
				//prodImage += store + ","; 그래서 이렇게 하나만 저장을했는데
				//자료실을 어떤 자료인지 알아야 하기 때문에 이렇게 
				// 원래파일 이름  / 저장할 파일이름 / 파일의 크기   이렇게 3개를 저장해야한다
				originalTotal += original + ",";
				storeTotal += store + ",";
				fileSizeTotal += fileSize + ",";
				String path = "WEB-INF/view/library/upload";
				String realPath = session.getServletContext().getRealPath(path);
				File file = new File(realPath + "/" + store);
				try { mf.transferTo(file);} catch (Exception e) {}
				dto.setNoticeOrgFile(originalTotal);
				dto.setNoticeFile(storeTotal);
				dto.setNoticeFileSize(fileSizeTotal);
				
			}
		}
		
		libraryRepository.libRegist(dto);
	}
}
