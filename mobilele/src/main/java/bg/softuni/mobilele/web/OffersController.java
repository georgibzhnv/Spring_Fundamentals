package bg.softuni.mobilele.web;

import bg.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final OfferService offerService;

    public OffersController(OfferService offerService) {
        this.offerService=offerService;
    }

    @GetMapping("/add")
    public String addOffer(){
        return "offer-add";
    }

    @GetMapping("/all")
    public String getAllOffers(Model model){
        model.addAttribute("models",offerService.getAllOffers());
        return "offers";
    }
}
