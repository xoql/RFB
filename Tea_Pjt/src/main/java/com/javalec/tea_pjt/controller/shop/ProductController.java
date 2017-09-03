package com.javalec.tea_pjt.controller.shop;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.tea_pjt.controller.member.MemberController;
import com.javalec.tea_pjt.model.shop.dto.ProductDTO;
import com.javalec.tea_pjt.service.shop.ProductService;


@Controller
@RequestMapping("/shop/product/*")
public class ProductController {
	
	private static final Logger logger
	=LoggerFactory.getLogger(ProductController.class);
	

	@Inject
	ProductService productService;

	@RequestMapping("write.do")
	public String write() {

		return "shop/product_write";
	}

	@RequestMapping("insert.do")
	public String insert(ProductDTO dto, HttpServletRequest request, Model model) {
		String path = request.getRealPath("/");
		path = path + "WEB-INF\\views\\images\\";
		
		logger.info("~~~~~~~~~~~~~~~~"+path);

		String filename = "-";
		String savedName = "defaultImage.gif";
		if (!dto.getFile1().isEmpty()) {
			filename = dto.getFile1().getOriginalFilename();
			try {
				new File(path).mkdir();
				savedName = FileUpload(filename, path, dto.getFile1().getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dto.setPicture_url(savedName);
		productService.insertProduct(dto);
		return "redirect:/shop/product/list.do";
	}

	private String FileUpload(String originalFileName, String path, byte[] file) throws IOException {

		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalFileName;
		File target = new File(path, savedName);
		FileCopyUtils.copy(file, target);
		return savedName;
	}

	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav, @RequestParam(defaultValue = "상품1") String product_type) {
		mav.setViewName("/shop/product_list");
		mav.addObject("list", productService.listProduct(product_type));
		return mav;
	}

	@RequestMapping("detail/{product_id}")
	public ModelAndView detail(@PathVariable int product_id, ModelAndView mav) {
		mav.setViewName("/shop/product_detail");

		mav.addObject("dto", productService.detailProduct(product_id));
		return mav;
	}
	
	@RequestMapping(value="update/{product_id}",method=RequestMethod.GET)
	public ModelAndView update(@PathVariable int product_id,ModelAndView mav){
		mav.setViewName("/shop/product_update");
		mav.addObject("dto", productService.detailProduct(product_id));	
		return mav;
	}
	
	@RequestMapping(value="update.do",method=RequestMethod.POST)
	public String update(ProductDTO dto,HttpServletRequest request) throws IOException{
		
		String path = request.getRealPath("/");
		path = path + "WEB-INF\\views\\images\\";
		
		ProductDTO dto2 = productService.detailProduct(dto.getProduct_id());
		if(dto.getFile1().isEmpty()){
			dto.setPicture_url(dto2.getPicture_url());
		}else{
		String savedName = FileUpload(dto.getFile1().getOriginalFilename(), path, dto.getFile1().getBytes());
		dto.setPicture_url(savedName);
		}
		productService.updateProduct(dto);
		
		
		return "redirect:/shop/product/list.do";
	}
	
	@RequestMapping(value="delete.do/{product_id}",method=RequestMethod.GET )
	public String product_delete(@PathVariable int product_id){
		
		
		
		productService.deleteProduct(product_id);
		
		return "redirect:/shop/product/list.do";
	}
	

}
