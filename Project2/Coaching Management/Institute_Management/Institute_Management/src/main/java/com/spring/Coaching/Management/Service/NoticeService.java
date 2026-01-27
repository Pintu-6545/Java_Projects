package com.spring.Coaching.Management.Service;

import java.util.List;

import com.spring.Coaching.Management.Entity.Notice;

public interface NoticeService {

	Notice createNotice(Notice notice);

    Notice updateNotice(Long id, Notice notice);

    Notice getNoticeById(Long id);

    List<Notice> getAllNotices();

    void deleteNotice(Long id);
}
