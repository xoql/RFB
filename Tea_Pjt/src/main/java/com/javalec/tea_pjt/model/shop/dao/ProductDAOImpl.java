package com.javalec.tea_pjt.model.shop.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javalec.tea_pjt.model.shop.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Inject
	SqlSession sqlSession;

	@Override
	public List<ProductDTO> listProduct(String product_type) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product.list_product",product_type);
	}

	@Override
	public ProductDTO detailProduct(int product_id) {
		return sqlSession.selectOne("product.detail_product",product_id);
	}

	@Override
	public void updateProduct(ProductDTO dto) {
		sqlSession.update("product.update_product",dto);
	}

	@Override
	public void deleteProduct(int product_id) {
		sqlSession.delete("product.delete",product_id);		
	}

	@Override
	public void insertProduct(ProductDTO dto) {
		sqlSession.insert("product.insert",dto);
	}

	@Override
	public String fileInfo(int product_id) {
		// TODO Auto-generated method stub
	 	return null;
	}
	
	
}
