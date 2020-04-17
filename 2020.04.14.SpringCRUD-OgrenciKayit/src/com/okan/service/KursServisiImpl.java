package com.okan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.okan.dao.KursDAO;
import com.okan.domain.Kurs;

@Service
public class KursServisiImpl implements KursServisi {

	@Autowired
	private KursDAO kursDAO;
	
	@Transactional
	@Override
	public List<Kurs> getKurslar() {
		
		return kursDAO.getKurslar();
	}

	@Override
	public void saveKurs(Kurs kurs) {
		
		kursDAO.saveKurs(kurs);
		
	}

	@Override
	public Kurs getKurs(int kursId) {
		
		return kursDAO.getKurs(kursId);
	}

	@Override
	public void deleteKurs(int kursId) {
		
		kursDAO.deleteKurs(kursId);
	}

}
