package com.interfaces;

import java.util.List;


import com.model.Titlemaster;

public interface Title_interface {
	public List<Titlemaster> getInfo();
	public boolean insertDetails(Titlemaster atm);
	public boolean deleteData(int id);
	public boolean updateDetails(Titlemaster atm);
}
