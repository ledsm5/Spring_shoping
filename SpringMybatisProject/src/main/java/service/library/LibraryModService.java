package service.library;

import org.springframework.beans.factory.annotation.Autowired;

import Model.LibraryDTO;
import command.LibraryCommand;
import repository.LibraryRepository;

public class LibraryModService {
	@Autowired
	LibraryRepository libraryRepository;
	public void modAction(LibraryCommand libraryCommand) {
		LibraryDTO dto = new LibraryDTO();
		dto.setNoticeCon(libraryCommand.getNoticeCon());
		dto.setNoticeSub(libraryCommand.getNoticeSub());
		dto.setNoticeNo(libraryCommand.getNoticeNo());
		libraryRepository.libMod(dto);
	}
}
