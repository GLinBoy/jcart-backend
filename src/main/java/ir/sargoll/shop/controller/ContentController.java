package ir.sargoll.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ir.sargoll.shop.model.Content;
import ir.sargoll.shop.service.ContentServiceApi;

@RestController
@RequestMapping(path = "/contents")
public class ContentController {
    @Autowired
    private ContentServiceApi contentService;

    @GetMapping(path = "/{id}")
    public Content getContentById(@PathVariable Long id) {
        return contentService.getSingleById(id);
    }

    @GetMapping(path = "/{title}")
    public Content getContentById(@PathVariable String title) {
        return contentService.getSingleByTitle(title);
    }

    @PostMapping
    public Content saveContent(@RequestBody Content content) {
        return contentService.save(content);
    }

    @PutMapping
    public Content updateContent(@RequestBody Content content) {
        return contentService.update(content);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteContent(@PathVariable Long id) {
        contentService.deleteSingleById(id);
    }
}
