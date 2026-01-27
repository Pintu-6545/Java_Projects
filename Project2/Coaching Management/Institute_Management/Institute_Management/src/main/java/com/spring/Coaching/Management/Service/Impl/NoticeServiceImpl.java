package com.spring.Coaching.Management.Service.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.Coaching.Management.Entity.Notice;
import com.spring.Coaching.Management.Repository.NoticeRepository;
import com.spring.Coaching.Management.Service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository repository;

    public NoticeServiceImpl(NoticeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Notice createNotice(Notice notice) {

        // Auto set publish time
        notice.setNoticeDate(LocalDateTime.now());

        return repository.save(notice);
    }

    @Override
    public Notice updateNotice(Long id, Notice updated) {

        Notice existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notice not found"));

        existing.setTitle(updated.getTitle());
        existing.setMessage(updated.getMessage());
        existing.setBatch(updated.getBatch());

        return repository.save(existing);
    }

    @Override
    public Notice getNoticeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notice not found"));
    }

    @Override
    public List<Notice> getAllNotices() {
        return repository.findAll();
    }

    @Override
    public void deleteNotice(Long id) {
        repository.deleteById(id);
    }
}