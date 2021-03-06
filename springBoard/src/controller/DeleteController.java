package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.*;
import vo.*;

public class DeleteController extends AbstractController {
	private BoardVO vo;
	private BoardService bs;

	public void setBoardVO(BoardVO vo) {
		this.vo = vo;
	}

	public void setboardService(BoardService bs) {
		this.bs = bs;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setPasswd(request.getParameter("passwd"));
		
		bs.delete(vo);
		
		request.setAttribute("vo", vo);
		return new ModelAndView("ajax","Result",vo.getCheck());
	}
}