package service.library;

import org.springframework.beans.factory.annotation.Autowired;


import repository.LibraryRepository;

public class LibraryDelService {
	@Autowired
	LibraryRepository libraryRepository;
	public void delAction(String noticeNo) {
		System.out.println(noticeNo);
		libraryRepository.libDel(noticeNo);
	}
}
