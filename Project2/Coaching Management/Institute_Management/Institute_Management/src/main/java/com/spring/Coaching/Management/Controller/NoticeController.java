package com.spring.Coaching.Management.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Coaching.Management.Entity.Notice;
import com.spring.Coaching.Management.Service.NoticeService;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {

    private final NoticeService service;

    public NoticeController(NoticeService service) {
        this.service = service;
    }

    // CREATE NOTICE
    @PostMapping
    public Notice create(@RequestBody Notice notice) {
        return service.createNotice(notice);
    }

    // UPDATE NOTICE
    @PutMapping("/{id}")
    public Notice update(
            @PathVariable Long id,
            @RequestBody Notice notice) {
        return service.updateNotice(id, notice);
    }

    // GET ALL NOTICES
    @GetMapping
    public List<Notice> getAll() {
        return service.getAllNotices();
    }

    // GET NOTICE BY ID
    @GetMapping("/{id}")
    public Notice getById(@PathVariable Long id) {
        return service.getNoticeById(id);
    }

    // DELETE NOTICE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteNotice(id);
        return "Notice deleted successfully";
    }
}