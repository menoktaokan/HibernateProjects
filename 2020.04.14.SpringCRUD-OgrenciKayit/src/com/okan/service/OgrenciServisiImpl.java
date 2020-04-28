package com.okan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.okan.dao.OgrenciDAO;
import com.okan.domain.Ogrenci;

@Service
public class OgrenciServisiImpl implements OgrenciServisi {

	@Autowired
	private OgrenciDAO ogrenciDAO;


	@Override
	public List<Ogrenci> getOgrenciler() {
		
		return ogrenciDAO.getOgrenciler();
	}


	@Override
	public void saveOgrenci(Ogrenci ogr) {
		
		ogrenciDAO.saveOgrenci(ogr);		
	}

	@Override
	public Ogrenci getOgrenci(int ogrId) {
		
		return ogrenciDAO.getOgrenci(ogrId);
	}

	@Override
	public void deleteOgrenci(int ogrId) {
		
		ogrenciDAO.deleteOgrenci(ogrId);
		
	}

	@Override
	public List<Ogrenci> searchOgrenci(Ogrenci ogrenci) {
		
		return ogrenciDAO.searchOgrenci(ogrenci);
	}
	

}
