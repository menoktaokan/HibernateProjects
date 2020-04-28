//Uygulamamızın database arayüzü olacak
package com.okan.dao;

import java.util.List;

import com.okan.domain.Ogrenci;

public interface OgrenciDAO {
	
	public List<Ogrenci> getOgrenciler();

	public void saveOgrenci(Ogrenci ogr);

	public Ogrenci getOgrenci(int ogrId);

	public void deleteOgrenci(int ogrId);

	public List<Ogrenci> searchOgrenci(Ogrenci ogrenci);

}
