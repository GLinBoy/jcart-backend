package ir.sargoll.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ir.sargoll.shop.model.Menu;
import ir.sargoll.shop.service.MenuServiceApi;

@RestController
@RequestMapping(path = "/menus")
public class MenuController {
    @Autowired
    private MenuServiceApi menuService;

    @GetMapping
    public Page<Menu> getAllMenus(Pageable pageable) {
        return menuService.getAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public Menu getMenuById(@PathVariable Long id) {
        return menuService.getSingleById(id);
    }

    @PostMapping
    public Menu saveMenu(@RequestBody Menu menu) {
        return menuService.save(menu);
    }

    @PutMapping
    public Menu updateMenu(@RequestBody Menu menu) {
        return menuService.update(menu);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteMenu(@PathVariable Long id) {
        menuService.deleteSingleById(id);
    }
}
