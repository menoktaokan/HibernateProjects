package com.okan.service;

import java.util.List;

import com.okan.domain.Kurs;

public interface KursServisi {

	public List<Kurs> getKurslar();

	public void saveKurs(Kurs kurs);

	public Kurs getKurs(int kursId);

	public void deleteKurs(int kursId);

}
