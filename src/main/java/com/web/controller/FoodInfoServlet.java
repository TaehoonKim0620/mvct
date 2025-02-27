package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dto.FoodInfoDTO;
import com.web.service.FoodInfoService;


public class FoodInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FoodInfoService fiService = new FoodInfoService();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		List<FoodInfoDTO> foodInfos = fiService.getFoodInfos(null);
		out.print("<table border='1'>");
		out.print("<tr>");
		out.print("<th>번호</th>");
		out.print("<th>음식이름</th>");
		out.print("<th>가격</th>");
		out.print("</tr>");
		for(int i =0;i<foodInfos.size();i++) {
			FoodInfoDTO foodInfo = foodInfos.get(i);
			out.print("<tr>");
			out.print("<th>"+foodInfo.getFiNum() + "</th>");
			out.print("<th>"+foodInfo.getFiName() + "</th>");
			out.print("<th>"+foodInfo.getFiPrice() + "</th>");
			out.print("</tr>");
		}
		out.print("</table>");		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
