package com.javalec.tea_pjt.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.javalec.tea_pjt.model.shop.dao.ProductDAO;
import com.javalec.tea_pjt.model.shop.dto.ProductDTO;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Inject
	ProductDAO productDao;

	@Override
	public List<ProductDTO> listProduct(String product_type) {
		return productDao.listProduct(product_type);
	}

	@Override
	public ProductDTO detailProduct(int product_id) {
		return productDao.detailProduct(product_id);
	}

	@Override
	public void updateProduct(ProductDTO dto) {
		 productDao.updateProduct(dto);
	}

	@Override
	public void deleteProduct(int product_id) {
		productDao.deleteProduct(product_id);
	}

	@Override
	public void insertProduct(ProductDTO dto) {
/*		String description =dto.getDescription();
		description = description.replace("<","&lt;");
		description = description.replace(">","&gt;");
		description = description.replaceAll("  ","&nbsp;&nbsp;");
		description = description.replaceAll("\n","<br>");
		
		dto.setDescription(description);
		System.out.println("들어온값 :" +  dto.getDescription());*/
		productDao.insertProduct(dto);
	}

	@Override
	public String fileInfo(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
