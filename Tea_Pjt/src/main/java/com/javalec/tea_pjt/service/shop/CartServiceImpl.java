package com.javalec.tea_pjt.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.javalec.tea_pjt.model.shop.dao.CartDAO;
import com.javalec.tea_pjt.model.shop.dto.CartDTO;

@Service
public class CartServiceImpl implements CartService {

	@Inject
	CartDAO cartDao;

	@Override
	public List<CartDTO> cartMoney() {
		// TODO Auto-generated method stub
		return cartDao.cartMoney();
	}

	@Override
	public void insert(CartDTO dto) {
		cartDao.insert(dto);
	}

	@Override
	public List<CartDTO> listCart(String userid) {
		// TODO Auto-generated method stub
		return cartDao.listCart(userid);
	}

	@Override
	public void delete(int cart_id) {
		cartDao.delete(cart_id);
	}

	@Override
	public int sumMoney(String userid) {

		return cartDao.sumMoney(userid);

	}

	@Override
	public void modifyCart(CartDTO dto) {
		cartDao.modifyCart(dto);
	}

	@Override
	public void deleteAll(String userid) {
		cartDao.deleteAll(userid);
	}

}
