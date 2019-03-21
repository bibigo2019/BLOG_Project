package edu.autocar.sample.dao;

import edu.autocar.sample.model.SampleVO;

public interface SampleDao {
	SampleVO select(Integer boardId) throws Exception;
}
