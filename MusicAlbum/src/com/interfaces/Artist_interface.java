package com.interfaces;

import java.util.List;


import com.model.ArtistMaster;

public interface Artist_interface {
	public List<ArtistMaster> getInfo();
	public boolean insertDetails(ArtistMaster atm);
	public boolean deleteData(int id);
	public boolean updateDetails(ArtistMaster atm);

}
