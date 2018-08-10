package ir.sargoll.shop.controller;

import ir.sargoll.shop.model.Contact;
import ir.sargoll.shop.service.ContactServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/contact")
public class ContactController {
    @Autowired
    private ContactServiceApi contactService;

    @GetMapping
    public Contact getContact(Pageable pageable){
        return contactService.getAll(pageable).getContent().get(0);
    }

    @PutMapping
    public Contact updateContact(@RequestBody Contact contact) {
        return contactService.update(contact);
    }
}
