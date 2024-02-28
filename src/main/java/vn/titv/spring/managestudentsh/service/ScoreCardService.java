package vn.titv.spring.managestudentsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.titv.spring.managestudentsh.dao.ScorecardDAO;
import vn.titv.spring.managestudentsh.entity.Scorecard;

import java.util.List;

@Service
public class ScoreCardService implements UtilService<Scorecard>{
    private ScorecardDAO scorecardDAO;
    @Autowired
    public ScoreCardService(ScorecardDAO scorecardDAO) {
        this.scorecardDAO = scorecardDAO;
    }

    @Override
    public List<Scorecard> getAll() {
        return this.scorecardDAO.getAll();
    }

    @Override
    public Scorecard findById(int id) {
        return this.scorecardDAO.findById(id);
    }

    @Override
    public void save(Scorecard scorecard) {
        this.scorecardDAO.save(scorecard);
    }

    @Override
    public void update(Scorecard scorecard) {
        this.scorecardDAO.update(scorecard);
    }

    @Override
    public void delete(Scorecard scorecard) {
        this.scorecardDAO.delete(scorecard);
    }
}
