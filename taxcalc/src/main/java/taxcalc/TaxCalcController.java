package taxcalc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class TaxCalcController {
	@GetMapping("/getTaxes")
	float calculateTaxe(@PathParam("price")float price) {
		return price * 0.3F;
	}
	

}
