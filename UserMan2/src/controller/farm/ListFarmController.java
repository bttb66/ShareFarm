package controller.farm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Farm;
import model.service.FarmManager;

public class ListFarmController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		FarmManager manager = FarmManager.getInstance();
		List<Farm> list = manager.findTotalFarmList();
		request.setAttribute("farmList", list);
		return "/farm/list.jsp";
	}
}
