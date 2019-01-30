package com.shop.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.shop.application.DTO.PictureDTO;
import com.shop.domain.Picture;
import com.shop.domain.Shop;
import com.shop.persistence.ShopRepository;


@Controller
public class PictureController {
	
	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private ShopController shopController;
	
	public PictureDTO createPICTURE(int shopId, PictureDTO pictureDTO) throws Exception {
		Shop shop = shopController.getShop(shopId);
		Picture picture= new Picture(pictureDTO.getName(), pictureDTO.getAuthor(), pictureDTO.getPrice());
		shop.addPicture(picture);
		
		shopRepository.addPicture(picture);

		shopRepository.addShop(shop);
	
		return new PictureDTO(picture);	
		
	}
	
	
    public List<PictureDTO> getAllPicturesByShop(int shopId) throws Exception {
        List<PictureDTO> pictures = new ArrayList<>();
        Shop shop = shopRepository.getShopById(shopId);
        for (Picture picture : shop.getAllPicture()) {
           
            pictures.add(new PictureDTO(picture));
        }
        return pictures;
    }

}
