package service.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.LibraryDTO;
import repository.LibraryRepository;

public class LibraryDetailService {
	@Autowired
	LibraryRepository libraryRepository;
	
	
	public void libDetail(String noticeNo,Model model) {
		libraryRepository.libCount(noticeNo);
		LibraryDTO dto = libraryRepository.libDetail(noticeNo);
		model.addAttribute("dto", dto);
	}
}
