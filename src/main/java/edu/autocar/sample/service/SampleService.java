package edu.autocar.sample.service;

import edu.autocar.sample.model.SampleVO;

public interface SampleService {
	
	SampleVO select(int boardId) throws Exception;
	
}
