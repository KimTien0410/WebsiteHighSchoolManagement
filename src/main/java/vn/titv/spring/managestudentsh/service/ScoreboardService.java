package vn.titv.spring.managestudentsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.titv.spring.managestudentsh.dao.ScorecardDAO;
import vn.titv.spring.managestudentsh.entity.Scorecard;

@Service
public class ScoreCardService implements UtilService<Scorecard>{
    private ScorecardDAO scorecardDAO;
    @Autowired
    public ScoreCardService(ScorecardDAO scorecardDAO) {
        this.scorecardDAO = scorecardDAO;
    }

    @Override
    public Scorecard findById(int id) {
        return this.scorecardDAO.findById(id);
    }

    @Override
    public void save(Scorecard Scorecard) {
        this.scorecardDAO.save(Scorecard);
    }

    @Override
    public void update(Scorecard Scorecard) {
        this.scorecardDAO.update(Scorecard);
    }

    @Override
    public void delete(Scorecard Scorecard) {
        this.scorecardDAO.delete(Scorecard);
    }
}
