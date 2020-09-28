package com.interfaces;

import java.util.List;


import com.model.MusicMaster;

public interface Music_interface {
	public List<MusicMaster> getInfo();
	public boolean insertDetails(MusicMaster atm);
	public boolean deleteData(int id);
	public boolean updateDetails(MusicMaster atm);
}
