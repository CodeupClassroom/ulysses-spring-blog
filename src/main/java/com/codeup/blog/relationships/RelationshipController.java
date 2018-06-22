package com.codeup.blog.relationships;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@ResponseBody
@Controller
public class RelationshipController {
    private final AdRepository adRepository;
    private final UserRepository userRepository;

    public RelationshipController(AdRepository adRepository, UserRepository userRepository) {
        this.adRepository = adRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/seed")
    public String seed() {

        User user = new User();
        user.setEmail("zach@codeup.com");
        user.setUsername("zgulde");
        user.setPassword("codeup123");
        userRepository.save(user);

        List<Ad> ads = Arrays.asList(
            new Ad("the first one", "lorem"),
            new Ad("the second one", "lorem"),
            new Ad("third ad", "lorem"),
            new Ad("the fourth one", "lorem")
        );

        for (Ad ad : ads) {
            ad.setUser(user);
        }
        adRepository.save(ads);
        return "Check the console.";
    }

    // TODO: show all the ads for a given user
    @GetMapping("/example-profile")
    public String profile() {
        User user = userRepository.findOne(1l);

        System.out.println("Showing ads belonging to user " + user.getUsername());
        List<Ad> ads = user.getAds();
        for (Ad ad : ads) {
            System.out.println("  - " + ad.getTitle());
        }

        return "Again, it's in the console.";
    }

    // TODO: show the email address of the user for a given ad
    @GetMapping("/example-show")
    public String show() {
        Ad ad = adRepository.findOne(1l);
        System.out.println(ad.getUser().getEmail());
        return "Console!";
    }
}
