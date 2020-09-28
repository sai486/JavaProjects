package com.interfaces;

import java.util.List;
import com.model.Genremaster;

public interface Genre_interface {
	public List<Genremaster> getInfo();
	public boolean insertDetails(Genremaster atm);
	public boolean deleteData(int id);
	public boolean updateDetails(Genremaster atm);
}
