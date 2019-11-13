package com.by.service.impl;

import com.by.dao.PaperDao;
import com.by.pojo.Paper;
import com.by.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;

    @Override
    @Transactional
    public int addPaper(Paper paper) {
        int res = paperDao.addPaper(paper);
        System.err.println(paper);
        return res;
    }

    @Override
    public int deletePaperById(long id) {
        return paperDao.deletePaperById(id);
    }

    @Override
    public int updatePaper(Paper paper) {
        return paperDao.updatePaper(paper);
    }

    @Override
    public Paper queryById(long id) {
        Paper p = paperDao.queryById(id);
        return p;
    }

    @Override
    public List<Paper> queryAllPaper() {
        return paperDao.queryAllPaper();
    }
}
