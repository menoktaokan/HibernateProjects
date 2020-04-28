package com.okan.dao;

import java.util.List;

import com.okan.domain.Kurs;

public interface KursDAO {
	
	public List<Kurs> getKurslar();

	public void saveKurs(Kurs kurs);

	public Kurs getKurs(int kursId);

	public void deleteKurs(int kursId);

	public List<Kurs>  searchKurs(Kurs kursAra);

}
