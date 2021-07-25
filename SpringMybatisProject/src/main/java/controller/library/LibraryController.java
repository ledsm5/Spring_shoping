package controller.library;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.LibraryCommand;
import controller.FileDownLoad;
import service.library.LibListService;
import service.library.LibraryDelService;
import service.library.LibraryDetailService;
import service.library.LibraryModService;
import service.library.LibraryService;

@Controller
@RequestMapping("lib")
public class LibraryController {
	@Autowired
	LibraryService libraryService;
	@Autowired
	LibListService libListService;
	@Autowired
	LibraryDetailService libraryDetailService;
	@Autowired
	LibraryModService libraryModService;
	@Autowired
	LibraryDelService libraryDelService;

	@RequestMapping("fileDown")
	public void fileDown(@RequestParam(value="str")String store,@RequestParam(value="org")String original,HttpServletRequest request, HttpServletResponse response) {
		String path = "WEB-INF/view/library/upload";
		FileDownLoad fileDownLoad = new FileDownLoad();
		fileDownLoad.fileDown(path,store,original,request,response);
	}
	
	@RequestMapping("libDelAction")
	public String libDelAction(@RequestParam(value="noticeNo")String noticeNo ) {
		libraryDelService.delAction(noticeNo);
		return "redirect:libList";
	}

	@RequestMapping("libDelCon")
	public String libDelCon(@ModelAttribute(value="noticeNo")String noticeNo) {
		return "library/libDelCon";
	}

	@RequestMapping("libModAction")
	public String libModAction(LibraryCommand libraryCommand) {
		libraryModService.modAction(libraryCommand);
		return "redirect:libraryDetail?noticeNo="+libraryCommand.getNoticeNo();
	}
	@RequestMapping("libraryMod")
	public String libraryMod(@RequestParam(value="noticeNo") String noticeNo, Model model) {
		libraryDetailService.libDetail(noticeNo, model);
		return "library/libModify";
	}
	@RequestMapping("libraryDetail")
	public String libDetail(@RequestParam(value="noticeNo") String noticeNo, Model model){
		libraryDetailService.libDetail(noticeNo, model);
		return "library/libDetail";
	}

	@RequestMapping("libRegistAction")
	public String libRegistAction(LibraryCommand libraryCommand,HttpSession session) {
		libraryService.libRegist(libraryCommand,session);
		return "redirect:/";
	}
	@RequestMapping("libRegist")
	public String libRegist() {
		return "library/library";
	}
	
	@RequestMapping("libList")
	public String libList(Model model) {
		libListService.libList(model);
		return "library/libList";
	}
}
