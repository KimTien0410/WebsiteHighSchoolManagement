package vn.titv.spring.managestudentsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.titv.spring.managestudentsh.dao.ScoreboardDAO;
import vn.titv.spring.managestudentsh.entity.Scoreboard;

import java.util.List;

@Service
public class ScoreboardService implements UtilService<Scoreboard>{
    private ScoreboardDAO scoreboardDAO;
    @Autowired
    public ScoreboardService(ScoreboardDAO scoreboardDAO) {
        this.scoreboardDAO = scoreboardDAO;
    }

    @Override
    public List<Scoreboard> getAll() {
        return this.scoreboardDAO.getAll();
    }

    @Override
    public Scoreboard findById(int id) {
        return this.scoreboardDAO.findById(id);
    }

    @Override
    public void save(Scoreboard scoreboard) {
        this.scoreboardDAO.save(scoreboard);
    }

    @Override
    public void update(Scoreboard scoreboard) {
        this.scoreboardDAO.update(scoreboard);
    }

    @Override
    public void delete(Scoreboard scoreboard) {
        this.scoreboardDAO.delete(scoreboard);
    }
}
