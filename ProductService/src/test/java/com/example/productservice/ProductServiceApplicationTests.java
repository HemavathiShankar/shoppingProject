package com.example.productservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.productservice.entity.Product;
import com.example.productservice.model.ProductBody;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.ProductService;
import com.example.productservice.service.ProductServiceImpl;
import com.google.common.base.Optional;

@SpringBootTest
class ProductServiceApplicationTests {
	@Mock
	private ProductRepository repo;
	@InjectMocks
	ProductService service=new ProductServiceImpl();
	
	@Test
	void test_add_product() {
		Product product=getProductEntity();
		ProductBody body=getProductBody();
		//when(repo.save(product)).thenReturn(anyLong());
		doReturn(anyLong()).when(repo.save(product));
		Long id=service.addProduct(body);
		verify(repo,times(1)).save(any());
		assertEquals(product.getProductId(), id);
	}
	
	@Test
	void test_get_product() {
		Product product=getProductEntity();
		ProductBody body=getProductBody();
		doReturn(Optional.of(product)).when(repo.findById(anyLong()));
		ProductBody p=service.findProduct((long) 1);
		verify(repo,times(1)).findById(anyLong());
		assertNotNull(p);
		
		
	}
	@Test
	

	private ProductBody getProductBody() {
		// TODO Auto-generated method stub
		return ProductBody.builder().price(1000).productName("vivo")
				.quantity(5).build();
	}

	private Product getProductEntity() {
		// TODO Auto-generated method stub
		return Product.builder().price(1000).productName("vivo").quantity(5).build();
	}

}
