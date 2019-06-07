package th.co.orcsoft.training.common.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.orcsoft.training.common.db.dao.PartyDao;
import th.co.orcsoft.training.common.db.service.PartyService;
import th.co.orcsoft.training.model.db.PartyModel;

@Service
public class PartyServiceImpl implements PartyService {

	@Autowired
	private PartyDao partyDao;

	@Override
	public List<PartyModel> getAllParty() {
		return partyDao.getAllParty();
	}

}
