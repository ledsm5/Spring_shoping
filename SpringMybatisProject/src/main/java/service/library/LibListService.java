package service.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.LibraryDTO;
import repository.LibraryRepository;

public class LibListService {
	@Autowired
	LibraryRepository libraryRepository;
	
	
	public void libList(Model model) {
		List<LibraryDTO> list = libraryRepository.libList();
		model.addAttribute("list",list);
	}
}