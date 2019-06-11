package th.co.orcsoft.training.common.db.dao.impl;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.CenterPointDao;
import th.co.orcsoft.training.model.db.VoteModel;

@Repository
public class CenterPointDaoImpl extends AbsCorDao implements CenterPointDao {

	@Override
	public List<VoteModel> getRequestedConfirmations() {
		String sql = "SELECT * FROM VOTE WHERE AprvBy = null";
		List<VoteModel> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<VoteModel>(VoteModel.class));
		return list;
	}

	@Override
	public List<VoteModel> getRequestedModifications() {
		String sql = "SELECT * FROM VOTE WHERE AprvBy = null";
		List<VoteModel> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<VoteModel>(VoteModel.class));
		return list;
	}

	@Override
	public void replyRequestedConfirmations(int id, boolean isApproved) {
//		String sql "UPDATE "
		String query = "update users set num_points = ? where first_name = ?";
//	      PreparedStatement preparedStmt = conn.prepareStatement(query);
//	      preparedStmt.setInt   (1, 6000);
//	      preparedStmt.setString(2, "Fred");
	}

	@Override
	public void replyRequestedModifications(int id, boolean isApproved) {
		
	}

}
